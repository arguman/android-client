package org.arguman.app.ui.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.arguman.app.R;
import org.arguman.app.model.ArgumentsModel;
import org.arguman.app.rest.ArgumanClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardPagerAdapter extends PagerAdapter {

    private Activity activity;
    private List<String> titleList;
    private ArrayList<ArgumentsModel> items;
    private ListItemAdapter adapter;
    private ListView listView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ArgumanClient client = new ArgumanClient();

    public DashboardPagerAdapter(Activity activity, ArrayList<ArgumentsModel> items) {
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

        adapter = new ListItemAdapter(activity, R.layout.list_item, items);
        listView = (ListView) view.findViewById(R.id.pager_list_view);
        listView.setAdapter(adapter);

//        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                client.getArgumentService().getPremises(new Callback<Response>() {
//                    @Override
//                    public void success(Response response, retrofit.client.Response response2) {
//                        Log.d("atkafasi", response.getItems().get(0).getTitle());
//                    }
//
//                    @Override
//                    public void failure(RetrofitError error) {
//
//                    }
//                });
//            }
//        });

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
