package org.arguman.app.ui.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.arguman.app.R;
import org.arguman.app.model.ItemsModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardPagerAdapter extends PagerAdapter {

    private Activity activity;
    private List<String> titleList;
    private ArrayList<ItemsModel> items;

    public DashboardPagerAdapter(Activity activity, ArrayList<ItemsModel> items) {
        this.activity = activity;
        this.items = items;
        Resources resources = activity.getResources();
        titleList = new ArrayList<>(
                Arrays.asList(
                        resources.getString(R.string.dashboard_tab_news_feed),
                        resources.getString(R.string.dashboard_tab_recent),
                        resources.getString(R.string.dashboard_tab_top),
                        resources.getString(R.string.dashboard_tab_statistics)));
    }

    @Override
    public int getCount() {
        return titleList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object == view;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = activity.getLayoutInflater().inflate(R.layout.pager_item, container, false);
        container.addView(view);

        ListItemAdapter adapter = new ListItemAdapter(activity, R.layout.list_item, items);
        ListView listView = (ListView) view.findViewById(R.id.pager_list_view);
        listView.setAdapter(adapter);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
