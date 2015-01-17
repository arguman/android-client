package org.arguman.app.ui.activity;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.arguman.app.R;
import org.arguman.app.libraries.FontCache;
import org.arguman.app.ui.adapter.DashboardPagerAdapter;
import org.arguman.app.ui.view.SlidingTabLayout;

public class Dashboard extends Activity {

    private ViewPager viewPager;
    private SlidingTabLayout slidingTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new DashboardPagerAdapter(this));
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.tab_layout);
        slidingTabLayout.setViewPager(viewPager);

        int titleId = getResources().getIdentifier("action_bar_title", "id", "android");
        TextView textView = (TextView) findViewById(titleId);
        Typeface typeface = Typeface.create(FontCache.get("fonts/american_typewriter.ttf", this),
                Typeface.NORMAL);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24);
        textView.setTypeface(typeface);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void setFabs(boolean hasLoggedIn) {
        if (hasLoggedIn) {

        }
    }

}