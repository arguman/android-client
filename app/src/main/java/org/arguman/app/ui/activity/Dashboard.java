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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import org.arguman.app.R;
import org.arguman.app.controller.UserController;
import org.arguman.app.util.TypefaceSpan;
import org.arguman.app.model.ArgumentModel;
import org.arguman.app.ui.adapter.DashboardPagerAdapter;
import org.arguman.app.ui.adapter.SearchAdapter;
import org.arguman.app.ui.view.SlidingTabLayout;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Dashboard extends ActionBarActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.viewpager)
    ViewPager viewPager;
    @InjectView(R.id.fab_menu_highlight)
    View fabHighlight;
    @InjectView(R.id.fab_menu)
    FloatingActionsMenu fabGroup;
    @InjectView(R.id.sliding_tab_layout)
    SlidingTabLayout slidingTabLayout;

    private Menu menu;
    private ArrayList<ArgumentModel> arguments = new ArrayList<ArgumentModel>();
    private ArrayList<String> argumentTitles = new ArrayList<String>();
    private ArgumentModel argument;

    private SearchManager searchManager;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        setSupportActionBar(toolbar);

        // TODO: temporary -BEGIN-
        getDummyData();
        // TODO: temporary -END-

        viewPager.setAdapter(new DashboardPagerAdapter(this, arguments));
        slidingTabLayout.setViewPager(viewPager);
        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.slider_tab_background));
        slidingTabLayout.setDividerColors(getResources().getColor(R.color.slider_tab_divider));

        SpannableString s = new SpannableString(getResources().getString(R.string.app_name));
        s.setSpan(new TypefaceSpan(this, "fonts/american_typewriter.ttf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(s);

        boolean loginState = UserController.getInstance(getApplicationContext()).getLoginState();
        setFabs(loginState);
    }

    private void getDummyData() {

        argument = new ArgumentModel();

        argument = new ArgumentModel();
        argument.setTitle("Çağdaşlık söylemi sosyal darwinistliktir.");
        argument.setTimestamp(20151701035533l);
        arguments.add(argument);

        argument = new ArgumentModel();
        argument.setTitle("Kedilerin nankör olduğu büyük bir yalandır");
        argument.setTimestamp(20151701035533l);
        arguments.add(argument);

        argument = new ArgumentModel();
        argument.setTitle("Sosyalizmin önündeki en büyük engel işçi sınıfıdır");
        argument.setTimestamp(20151701035533l);
        arguments.add(argument);

        argument = new ArgumentModel();
        argument.setTitle("insanlar urettikleri kadar degerlidir.");
        argument.setTimestamp(20151701035533l);
        arguments.add(argument);

        argument = new ArgumentModel();
        argument.setTitle("İletişim süreçlerinde başarılı olmak isteyen markalar için sosyal medya kullanımı artık bir zorunluluktur.");
        argument.setTimestamp(20151701035533l);
        arguments.add(argument);

        argument = new ArgumentModel();
        argument.setTitle("Bir gün herkes Google Glass kullanacak ve bu bir ihtiyaç halini alacak.");
        argument.setTimestamp(20151701035533l);
        arguments.add(argument);

        argument = new ArgumentModel();
        argument.setTitle("Para kazanmak amaç ise hırsızlık bir meslektir");
        argument.setTimestamp(20151701035533l);
        arguments.add(argument);

        argument = new ArgumentModel();
        argument.setTitle("Giyilebilir teknolojiler çağın gerisindedir");
        argument.setTimestamp(20151701035533l);
        arguments.add(argument);

        argument = new ArgumentModel();
        argument.setTitle("Sosyal Devlet Halkı Tembelleştirir");
        argument.setTimestamp(20151701035533l);
        arguments.add(argument);

        argument = new ArgumentModel();
        argument.setTitle("Hıçkırık tutunca ne yapsan nafile,geçmiyor.");
        argument.setTimestamp(20151701035533l);
        arguments.add(argument);

        argument = new ArgumentModel();
        argument.setTitle("İslam filozofları gerçek manada felsefe yapamamaktadır");
        argument.setTimestamp(20151701035533l);
        arguments.add(argument);

        argument = new ArgumentModel();
        argument.setTitle("Tesadüf diye bir şey yoktur.");
        argument.setTimestamp(20151701035533l);
        arguments.add(argument);

        argument = new ArgumentModel();
        argument.setTitle("Oksijenle temas eden herşey bozulmaya ve çürümeye mahkumdur");
        argument.setTimestamp(20151701035533l);
        arguments.add(argument);

        argument = new ArgumentModel();
        argument.setTitle("Dropshipping bir aldatmacadır.");
        argument.setTimestamp(20151701035533l);
        arguments.add(argument);

        argument = new ArgumentModel();
        argument.setTitle("Content Marketing gelecekte en önemli pazarlama süreci olacaktır.");
        argument.setTimestamp(20151701035533l);
        arguments.add(argument);

        argument = new ArgumentModel();
        argument.setTitle("İstanbul dünyanın en güzel şehridir.");
        argument.setTimestamp(20151701035533l);
        arguments.add(argument);

        argument = new ArgumentModel();
        argument.setTitle("Üniversite okumak pişmanlıktır.");
        argument.setTimestamp(20151701035533l);
        arguments.add(argument);

        argument = new ArgumentModel();
        argument.setTitle("Hamal olmaya gerek yok");
        argument.setTimestamp(20151701035533l);
        arguments.add(argument);

        argument = new ArgumentModel();
        argument.setTitle("Arap Baharı henüz başarıya ulaşmadığı halde ciddi bir değişim dinamiği ortaya çıkarmıştır.");
        argument.setTimestamp(20151701035533l);
        arguments.add(argument);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        this.menu = menu;

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
        argumentTitles = new ArrayList<String>();
        for (int i = 0; i < arguments.size(); i++) {
            temp[0] = i;
            temp[1] = arguments.get(i).getTitle();
            if (arguments.get(i).getTitle().toLowerCase().contains(s.toLowerCase())) {
                argumentTitles.add(arguments.get(i).getTitle());
                cursor.addRow(temp);
            }
        }
        searchView.setSuggestionsAdapter(new SearchAdapter(this, cursor, argumentTitles));
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
