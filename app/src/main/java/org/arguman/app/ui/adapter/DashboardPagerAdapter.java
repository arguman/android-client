package org.arguman.app.ui.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.arguman.app.R;
import org.arguman.app.model.ItemViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardPagerAdapter extends PagerAdapter {

    // TODO: Define an argument list here.
    private Activity activity;
    private List<String> titleList;
    private ArrayList<ItemViewModel> arguments;
    private ItemViewModel argument;

    public DashboardPagerAdapter(Activity activity) {
        arguments = new ArrayList<ItemViewModel>();

        // TODO static data will be changed
        getDummyData();

        this.activity = activity;
        Resources resources = activity.getResources();
        titleList = new ArrayList<>(
                Arrays.asList(
                        resources.getString(R.string.dashboard_tab_news_feed),
                        resources.getString(R.string.dashboard_tab_recent),
                        resources.getString(R.string.dashboard_tab_top),
                        resources.getString(R.string.dashboard_tab_statistics)));
    }

    private void getDummyData() {

        argument = new ItemViewModel();
        argument.setBecause(2);
        argument.setBut(1);
        argument.setHowever(4);
        argument.setTitle("Yazılım toplum içindir.");
        argument.setLast_sender("orkun");
        argument.setTimestamp(20151701035533l);
        argument.setLast_sender("orkun");
        arguments.add(argument);

        argument = new ItemViewModel();
        argument.setBecause(1);
        argument.setBut(2);
        argument.setHowever(0);
        argument.setTitle("Çağdaşlık söylemi sosyal darwinistliktir.");
        argument.setTimestamp(20151701035533l);
        argument.setLast_sender("orkun");
        arguments.add(argument);

        argument = new ItemViewModel();
        argument.setBecause(5);
        argument.setBut(3);
        argument.setHowever(2);
        argument.setTitle("Kedilerin nankör olduğu büyük bir yalandır");
        argument.setTimestamp(20151701035533l);
        argument.setLast_sender("orkun");
        arguments.add(argument);

        argument = new ItemViewModel();
        argument.setBecause(1);
        argument.setBut(2);
        argument.setHowever(0);
        argument.setTitle("Sosyalizmin önündeki en büyük engel işçi sınıfıdır");
        argument.setTimestamp(20151701035533l);
        argument.setLast_sender("orkun");
        arguments.add(argument);

        argument = new ItemViewModel();
        argument.setBecause(2);
        argument.setBut(2);
        argument.setHowever(2);
        argument.setTitle("insanlar urettikleri kadar degerlidir.");
        argument.setTimestamp(20151701035533l);
        argument.setLast_sender("orkun");
        arguments.add(argument);

        argument = new ItemViewModel();
        argument.setBecause(2);
        argument.setBut(2);
        argument.setHowever(3);
        argument.setTitle("İletişim süreçlerinde başarılı olmak isteyen markalar için sosyal medya kullanımı artık bir zorunluluktur.");
        argument.setTimestamp(20151701035533l);
        argument.setLast_sender("orkun");
        arguments.add(argument);

        argument = new ItemViewModel();
        argument.setBecause(1);
        argument.setBut(2);
        argument.setHowever(0);
        argument.setTitle("Bir gün herkes Google Glass kullanacak ve bu bir ihtiyaç halini alacak.");
        argument.setTimestamp(20151701035533l);
        argument.setLast_sender("orkun");
        arguments.add(argument);

        argument = new ItemViewModel();
        argument.setBecause(5);
        argument.setBut(3);
        argument.setHowever(2);
        argument.setTitle("Para kazanmak amaç ise hırsızlık bir meslektir");
        argument.setTimestamp(20151701035533l);
        argument.setLast_sender("orkun");
        arguments.add(argument);

        argument = new ItemViewModel();
        argument.setBecause(1);
        argument.setBut(2);
        argument.setHowever(0);
        argument.setTitle("Giyilebilir teknolojiler çağın gerisindedir");
        argument.setTimestamp(20151701035533l);
        argument.setLast_sender("orkun");
        arguments.add(argument);

        argument = new ItemViewModel();
        argument.setBecause(1);
        argument.setBut(2);
        argument.setHowever(0);
        argument.setTitle("Sosyal Devlet Halkı Tembelleştirir");
        argument.setTimestamp(20151701035533l);
        argument.setLast_sender("orkun");
        arguments.add(argument);

        argument = new ItemViewModel();
        argument.setBecause(5);
        argument.setBut(3);
        argument.setHowever(2);
        argument.setTitle("Hıçkırık tutunca ne yapsan nafile,geçmiyor.");
        argument.setTimestamp(20151701035533l);
        argument.setLast_sender("orkun");
        arguments.add(argument);

        argument = new ItemViewModel();
        argument.setBecause(2);
        argument.setBut(2);
        argument.setHowever(3);
        argument.setTitle("İslam filozofları gerçek manada felsefe yapamamaktadır");
        argument.setTimestamp(20151701035533l);
        argument.setLast_sender("orkun");
        arguments.add(argument);

        argument = new ItemViewModel();
        argument.setBecause(5);
        argument.setBut(3);
        argument.setHowever(2);
        argument.setTitle("Tesadüf diye bir şey yoktur.");
        argument.setTimestamp(20151701035533l);
        argument.setLast_sender("orkun");
        arguments.add(argument);

        argument = new ItemViewModel();
        argument.setBecause(1);
        argument.setBut(2);
        argument.setHowever(0);
        argument.setTitle("Oksijenle temas eden herşey bozulmaya ve çürümeye mahkumdur");
        argument.setTimestamp(20151701035533l);
        argument.setLast_sender("orkun");
        arguments.add(argument);

        argument = new ItemViewModel();
        argument.setBecause(2);
        argument.setBut(2);
        argument.setHowever(3);
        argument.setTitle("Dropshipping bir aldatmacadır.");
        argument.setTimestamp(20151701035533l);
        argument.setLast_sender("orkun");
        arguments.add(argument);

        argument = new ItemViewModel();
        argument.setBecause(5);
        argument.setBut(3);
        argument.setHowever(2);
        argument.setTitle("Content Marketing gelecekte en önemli pazarlama süreci olacaktır.");
        argument.setTimestamp(20151701035533l);
        argument.setLast_sender("orkun");
        arguments.add(argument);

        argument = new ItemViewModel();
        argument.setBecause(1);
        argument.setBut(2);
        argument.setHowever(0);
        argument.setTitle("İstanbul dünyanın en güzel şehridir.");
        argument.setTimestamp(20151701035533l);
        argument.setLast_sender("orkun");
        arguments.add(argument);

        argument = new ItemViewModel();
        argument.setBecause(5);
        argument.setBut(3);
        argument.setHowever(2);
        argument.setTitle("Üniversite okumak pişmanlıktır.");
        argument.setTimestamp(20151701035533l);
        argument.setLast_sender("orkun");
        arguments.add(argument);

        argument = new ItemViewModel();
        argument.setBecause(1);
        argument.setBut(2);
        argument.setHowever(0);
        argument.setTitle("Hamal olmaya gerek yok");
        argument.setTimestamp(20151701035533l);
        argument.setLast_sender("orkun");
        arguments.add(argument);

        argument = new ItemViewModel();
        argument.setBecause(2);
        argument.setBut(2);
        argument.setHowever(3);
        argument.setTitle("Arap Baharı henüz başarıya ulaşmadığı halde ciddi bir değişim dinamiği ortaya çıkarmıştır.");
        argument.setTimestamp(20151701035533l);
        argument.setLast_sender("orkun");
        arguments.add(argument);

    }

    @Override
    public int getCount() {
        return 4;
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

        if (position == 0) {
            ListItemAdapter adapter = new ListItemAdapter(activity, R.layout.list_item, arguments);
            ListView listView = (ListView) view.findViewById(R.id.pager_list_view);
            listView.setAdapter(adapter);
        }

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
