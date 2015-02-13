package org.arguman.app.ui.activity;

import android.app.SearchManager;
import android.content.Context;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.SearchView;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import org.arguman.app.R;
import org.arguman.app.controller.UserController;
import org.arguman.app.library.TypefaceSpan;
import org.arguman.app.model.ArgumentsModel;
import org.arguman.app.model.ItemsModel;
import org.arguman.app.rest.ArgumanClient;
import org.arguman.app.ui.adapter.DashboardPagerAdapter;
import org.arguman.app.ui.adapter.SearchAdapter;
import org.arguman.app.ui.view.SlidingTabLayout;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Dashboard extends ActionBarActivity {

    private static final String LOG_TAG = "Dashboard";

    private ViewPager viewPager;
    private DashboardPagerAdapter adapter;
    private SlidingTabLayout slidingTabLayout;
    private ArgumanClient argumanClient = new ArgumanClient();
    private ArrayList<ArgumentsModel> items = new ArrayList<>();
    private ArrayList<String> itemTitle = new ArrayList<>();
    private FloatingActionsMenu fabGroup;
    private View fabHighlight;

    private SearchManager searchManager;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_main);

        setSupportProgressBarIndeterminateVisibility(true);

        Toolbar toolbar = (Toolbar) findViewById(R.id.dashboard_toolbar);
        setSupportActionBar(toolbar);

        // TODO: add a loading zimbirti here
        getData();

        fabHighlight = findViewById(R.id.highlight);
        fabGroup = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.tab_layout);
        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.slider_tab_background));
        slidingTabLayout.setDividerColors(getResources().getColor(R.color.slider_tab_divider));

        SpannableString s = new SpannableString(getResources().getString(R.string.app_name));
        s.setSpan(new TypefaceSpan(this, "fonts/american_typewriter.ttf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(s);
        /*int titleId = getResources().getIdentifier("action_bar_title", "id", "android");
        TextView textView = (TextView) findViewById(titleId);
        Typeface typeface = Typeface.create(FontCache.get("fonts/american_typewriter.ttf", this), Typeface.NORMAL);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24);
        textView.setText(getString(R.string.app_name));
        textView.setTypeface(typeface);
*/
        boolean loginState = UserController.getInstance(getApplicationContext()).getLoginState();
        setFabs(loginState);
    }

    private void getData() {
        argumanClient.getArgumentService().getArguments(new Callback<ItemsModel>() {
            @Override
            public void success(ItemsModel itemsModel, Response response) {
                items = (ArrayList<ArgumentsModel>) itemsModel.getResults();
                loadData();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(LOG_TAG, error.getLocalizedMessage());
            }
        });
    }

    private void loadData() {
        adapter = new DashboardPagerAdapter(this, items);
        viewPager.setAdapter(adapter);
        slidingTabLayout.setViewPager(viewPager);
        setSupportProgressBarIndeterminateVisibility(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        View notificationsItemView = menu.findItem(R.id.action_notifications).getActionView();
        ((TextView) notificationsItemView.findViewById(R.id.item_title)).setText(String.valueOf(2));

        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                loadHistory(s);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void loadHistory(String s) {
        String[] columns = new String[]{"_id", "text"};
        Object[] temp = new Object[]{0, "default"};
        MatrixCursor cursor = new MatrixCursor(columns);
        itemTitle = new ArrayList<String>();
        for (int i = 0; i < items.size(); i++) {
            temp[0] = i;
            temp[1] = items.get(i).getTitle();
            if (items.get(i).getTitle().toLowerCase().contains(s.toLowerCase())) {
                itemTitle.add(items.get(i).getTitle());
                cursor.addRow(temp);
            }
        }
        searchView.setSuggestionsAdapter(new SearchAdapter(this, cursor, itemTitle));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void setFabs(boolean loginState) {
        // TODO: If somewhere other than fabGroup gets clicked, collapse fabGroup.
        fabGroup.setOnFloatingActionsMenuUpdateListener(
                new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
                    @Override
                    public void onMenuExpanded() {
                        fabHighlight.setVisibility(View.VISIBLE);
                        // TODO: set viewpager not clickable.
                    }

                    @Override
                    public void onMenuCollapsed() {
                        fabHighlight.setVisibility(View.GONE);
                        // TODO: set viewpager clickable.
                    }
                });
        FloatingActionButton actionAddArgument = new FloatingActionButton(getBaseContext());
        setFabButtonStyle(actionAddArgument, R.drawable.ic_create, R.color.fab_mini,
                R.color.fab_mini_pressed, R.string.fab_argument);
        FloatingActionButton actionFeedback = new FloatingActionButton(getBaseContext());
        setFabButtonStyle(actionFeedback, R.drawable.ic_email, R.color.fab_mini,
                R.color.fab_mini_pressed, R.string.fab_feedback);
        FloatingActionButton actionAbout = new FloatingActionButton(getBaseContext());
        setFabButtonStyle(actionAbout, R.drawable.ic_info, R.color.fab_mini,
                R.color.fab_mini_pressed, R.string.fab_about);
        fabGroup.addButton(actionFeedback);
        fabGroup.addButton(actionAbout);
        if (loginState) {
            FloatingActionButton actionProfile = new FloatingActionButton(getBaseContext());
            setFabButtonStyle(actionProfile, R.drawable.ic_person, R.color.fab_mini,
                    R.color.fab_mini_pressed, R.string.fab_profile);
            fabGroup.addButton(actionProfile);
        } else {
            FloatingActionButton actionLogin = new FloatingActionButton(getBaseContext());
            setFabButtonStyle(actionLogin, R.drawable.ic_key, R.color.fab_mini,
                    R.color.fab_mini_pressed, R.string.fab_login);
            FloatingActionButton actionSignUp = new FloatingActionButton(getBaseContext());
            setFabButtonStyle(actionSignUp, R.drawable.ic_key, R.color.fab_mini,
                    R.color.fab_mini_pressed, R.string.fab_sign_up);
            fabGroup.addButton(actionLogin);
            fabGroup.addButton(actionSignUp);
        }
        fabGroup.addButton(actionAddArgument);
    }

    private void setFabButtonStyle(FloatingActionButton floatingActionButton, int iconResId,
                                   int colorResId, int pressedColorResId, int titleResId) {
        floatingActionButton.setSize(FloatingActionButton.SIZE_MINI);
        floatingActionButton.setColorNormal(getResources().getColor(colorResId));
        floatingActionButton.setColorPressed(getResources().getColor(pressedColorResId));
        floatingActionButton.setIcon(iconResId);
        floatingActionButton.setTitle(getResources().getString(titleResId));
        floatingActionButton.setStrokeVisible(false);
    }

}
