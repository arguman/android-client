package org.arguman.app.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import org.arguman.app.R;
import org.arguman.app.model.ArgumentsModel;
import org.arguman.app.ui.view.ArgumanTextView;

import java.util.ArrayList;

public class ListItemAdapter extends ArrayAdapter<ArgumentsModel> {

    private Context context;
    private int resource;
    private ArrayList<ArgumentsModel> items;

    private static final String BECAUSE = "çünkü";
    private static final String BUT = "ama";
    private static final String HOWEVER = "ancak";

    private int because_count;
    private int but_count;
    private int however_count;

    private String lastSenderUsername;

    public ListItemAdapter(Context context, int resource, ArrayList<ArgumentsModel> items) {
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

        // Total because, but and however calculation
        because_count = 0;
        but_count = 0;
        however_count = 0;
        for (int i = 0; i < items.get(position).getPremises().size(); i++) {
            if (items.get(position).getPremises().get(i).getPremise_type().equals(BECAUSE)) {
                because_count++;
            } else if (items.get(position).getPremises().get(i).getPremise_type().equals(BUT)) {
                but_count++;
            } else if (items.get(position).getPremises().get(i).getPremise_type().equals(HOWEVER)) {
                however_count++;
            }
        }

        // Getting last sender username
        lastSenderUsername = items.get(position).getPremises().get(items.get(position).getPremises().size() - 1).getUser().getUsername();

        because.setText(String.valueOf(because_count));
        but.setText(String.valueOf(but_count));
        however.setText(String.valueOf(however_count));

        title.setText(items.get(position).getTitle());
        lastSender.setText(context.getString(R.string.last_sender) + ": " + lastSenderUsername);

        // TODO: following timestamp hardcoded and will be changed after getting from api
        time.setText("5 saat önce");

        return view;
    }

}
