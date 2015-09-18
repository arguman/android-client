package org.arguman.app.ui.adapter;

import android.content.Context;
import android.util.Log;
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

        ArgumanTextView because = (ArgumanTextView) view.findViewById(R.id.because);
        ArgumanTextView but = (ArgumanTextView) view.findViewById(R.id.but);
        ArgumanTextView however = (ArgumanTextView) view.findViewById(R.id.however);
        ArgumanTextView title = (ArgumanTextView) view.findViewById(R.id.title);
        ArgumanTextView lastSender = (ArgumanTextView) view.findViewById(R.id.last_sender);
        ArgumanTextView time = (ArgumanTextView) view.findViewById(R.id.time);

        // Calculating counts of premise types:
        int because_count = 0;
        int but_count = 0;
        int however_count = 0;
        for (int i = 0; i < items.get(position).getPremises().size(); i++) {
            int premise_type = items.get(position).getPremises().get(i).getPremise_type();
            if (premise_type == 0) {
                but_count++;
            } else if (premise_type == 1) {
                because_count++;
            } else if (premise_type == 2) {
                however_count++;
            }
        }

        because.setText(String.valueOf(because_count));
        but.setText(String.valueOf(but_count));
        however.setText(String.valueOf(however_count));

        title.setText(items.get(position).getTitle());
        lastSender.setText(context.getString(R.string.last_sender) + ": " + items.get(position).getUser().getUsername());

        // TODO: following timestamp hardcoded and will be changed after getting from api
        time.setText("5 saat önce");

        return view;
    }

    public ItemsModel getArgument(int position) {
        return items.get(position);
    }

}
