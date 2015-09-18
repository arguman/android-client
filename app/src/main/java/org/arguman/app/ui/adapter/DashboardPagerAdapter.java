package org.arguman.app.ui.adapter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.arguman.app.R;
import org.arguman.app.library.ObjectCache;
import org.arguman.app.model.ItemsModel;
import org.arguman.app.ui.activity.ArgumentDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardPagerAdapter extends PagerAdapter {

    private Activity activity;
    private List<String> titleList;
    private ArrayList<ItemsModel> items;
    private ObjectCache objectCache;

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
        objectCache = ObjectCache.getInstance(activity);
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
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = activity.getLayoutInflater().inflate(R.layout.pager_item, container, false);
        container.addView(view);

        final ListItemAdapter adapter = new ListItemAdapter(activity, R.layout.list_item, items);
        ListView listView = (ListView) view.findViewById(R.id.pager_list_view);
        listView.setAdapter(adapter);

        // Argument details activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                objectCache.putObject("argument", adapter.getArgument(i));
                objectCache.commit();
                Intent argumentDetails = new Intent(activity, ArgumentDetails.class);
                activity.startActivity(argumentDetails);
            }
        });

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
