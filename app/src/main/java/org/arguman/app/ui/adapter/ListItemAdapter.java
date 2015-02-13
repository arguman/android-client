package org.arguman.app.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import org.arguman.app.R;
import org.arguman.app.model.ItemsModel;
import org.arguman.app.ui.view.ArgumanTextView;

import java.util.ArrayList;

public class ListItemAdapter extends ArrayAdapter<ItemsModel> {

    private Context context;
    private int resource;
    private ArrayList<ItemsModel> items;

    public ListItemAdapter(Context context, int resource, ArrayList<ItemsModel> items) {
        super(context, resource, items);
        this.context = context;
        this.resource = resource;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource, parent, false);

        // TODO: add left line

        ArgumanTextView because = (ArgumanTextView) view.findViewById(R.id.because);
        ArgumanTextView but = (ArgumanTextView) view.findViewById(R.id.but);
        ArgumanTextView however = (ArgumanTextView) view.findViewById(R.id.however);
        ArgumanTextView title = (ArgumanTextView) view.findViewById(R.id.title);
        ArgumanTextView lastSender = (ArgumanTextView) view.findViewById(R.id.last_sender);
        ArgumanTextView time = (ArgumanTextView) view.findViewById(R.id.time);

        // TODO: following premise types hardcoded and will be changed after getting from api
        because.setText("0");
        but.setText("0");
        however.setText("0");

        title.setText(items.get(position).getTitle());
        lastSender.setText(context.getString(R.string.last_sender) + ": " + items.get(position).getUser().getUsername());

        // TODO: following timestamp hardcoded and will be changed after getting from api
        time.setText("5 saat önce");

        return view;
    }

}
