package org.arguman.app.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.arguman.app.R;
import org.arguman.app.model.PremisesModel;
import org.arguman.app.ui.view.ArgumanTextView;

import java.util.ArrayList;

public class PremiseItemAdapter extends ArrayAdapter<PremisesModel> {

    private Context context;
    private int resource;
    private ArrayList<PremisesModel> items;

    public PremiseItemAdapter(Context context, int resource, ArrayList<PremisesModel> items) {
        super(context, resource, items);
        this.context = context;
        this.resource = resource;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource, parent, false);

        ArgumanTextView premiseType = (ArgumanTextView) view.findViewById(R.id.premise_type);
        TextView premise = (TextView) view.findViewById(R.id.premise);
        ArgumanTextView sender = (ArgumanTextView) view.findViewById(R.id.sender);

        String premise_type = context.getResources().getString(R.string.premise_type_because);
        int premise_title_color = context.getResources().getColor(R.color.dark_green);
        int premise_color = context.getResources().getColor(R.color.green);

        switch (items.get(position).getPremise_type()) {
            case 0:
                premise_type = context.getResources().getString(R.string.premise_type_but);
                premise_title_color = context.getResources().getColor(R.color.dark_red);
                premise_color = context.getResources().getColor(R.color.red);
                break;
            case 1:
                premise_type = context.getResources().getString(R.string.premise_type_because);
                premise_title_color = context.getResources().getColor(R.color.dark_green);
                premise_color = context.getResources().getColor(R.color.green);
                break;
            case 2:
                premise_type = context.getResources().getString(R.string.premise_type_however);
                premise_title_color = context.getResources().getColor(R.color.dark_yellow);
                premise_color = context.getResources().getColor(R.color.yellow);
                break;
        }

        premiseType.setText(premise_type);
        premiseType.setTextColor(premise_title_color);

        premise.setText(items.get(position).getText());
        premise.setBackgroundColor(premise_color);

        sender.setText(context.getResources().getString(R.string.premise_sender) + ": " + items.get(position).getUser().getUsername());

        return view;
    }

}
