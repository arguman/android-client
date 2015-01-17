package org.arguman.app.ui.activity;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.database.MatrixCursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;

import org.arguman.app.R;
import org.arguman.app.controller.UserController;
import org.arguman.app.library.FontCache;
import org.arguman.app.library.TimestampParser;
import org.arguman.app.model.ArgumentModel;
import org.arguman.app.ui.adapter.DashboardPagerAdapter;
import org.arguman.app.ui.adapter.SearchAdapter;
import org.arguman.app.ui.view.SlidingTabLayout;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Dashboard extends Activity {

    private ViewPager viewPager;
    private SlidingTabLayout slidingTabLayout;
    private Menu menu;
    private ArrayList<ArgumentModel> arguments = new ArrayList<ArgumentModel>();
    private ArrayList<String> argumentTitles = new ArrayList<String>();
    private ArgumentModel argument;
    private TimestampParser timestampParser; // TODO: temporary

    private SearchManager searchManager;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: temporary -BEGIN-
        getDummyData();
        timestampParser = TimestampParser.getInstance(this);
        timestampParser.setTimestamp(Timestamp.valueOf("2014-01-17 15:00:33.812"));
        Log.d("TimestampParser_Test", String.valueOf(timestampParser.getDifference()) + " " +
                                      timestampParser.getDifferenceExtension() + " " +
                                      getString(R.string.timestamp_ago));
        // TODO: temporary -END-

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new DashboardPagerAdapter(this, arguments));
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.tab_layout);
        slidingTabLayout.setViewPager(viewPager);
        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.slider_tab_background));
        slidingTabLayout.setDividerColors(getResources().getColor(R.color.slider_tab_divider));

        int titleId = getResources().getIdentifier("action_bar_title", "id", "android");
        TextView textView = (TextView) findViewById(titleId);
        Typeface typeface = Typeface.create(FontCache.get("fonts/american_typewriter.ttf", this), Typeface.NORMAL);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24);
        textView.setText(getString(R.string.app_name));
        textView.setTypeface(typeface);

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
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu = menu;
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

        return true;
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
        if (loginState) {

        } else {

        }
    }

}
