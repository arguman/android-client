package org.arguman.app.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import org.arguman.app.R;
import org.arguman.app.library.ObjectCache;
import org.arguman.app.library.TypefaceSpan;
import org.arguman.app.model.ItemsModel;
import org.arguman.app.model.PremisesModel;
import org.arguman.app.ui.adapter.PremiseItemAdapter;
import org.arguman.app.ui.view.ArgumanTextView;

import java.util.ArrayList;

public class ArgumentDetails extends ActionBarActivity {

    private Activity activity;
    private Context context;
    private ObjectCache objectCache;
    private ItemsModel argument;

    private ArgumanTextView tvTitle;
    private ListView premiseList;
    private PremiseItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_argument_detail);

        activity = this;
        context = this;
        objectCache = ObjectCache.getInstance(context);

        Toolbar toolbar = (Toolbar) findViewById(R.id.dashboard_toolbar);
        setSupportActionBar(toolbar);

        SpannableString s = new SpannableString(getResources().getString(R.string.app_name));
        s.setSpan(new TypefaceSpan(this, "fonts/american_typewriter.ttf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(s);

        argument = objectCache.getObject("argument", ItemsModel.class);

        initialize();

    }

    private void initialize() {
        tvTitle = (ArgumanTextView) activity.findViewById(R.id.title);
        tvTitle.setText(argument.getTitle());

        premiseList = (ListView) activity.findViewById(R.id.premise_list);
        premiseList.setDividerHeight(0);
        adapter = new PremiseItemAdapter(context, R.layout.premise_item, (ArrayList<PremisesModel>) argument.getPremises());
        premiseList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_argument_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
