package org.arguman.app.ui.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.arguman.app.R;
import org.arguman.app.ui.adapter.DashboardPagerAdapter;
import org.arguman.app.ui.view.SlidingTabLayout;

public class Dashboard extends ActionBarActivity {

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

}
