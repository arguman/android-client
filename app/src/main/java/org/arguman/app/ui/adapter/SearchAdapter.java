package org.arguman.app.ui.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

import org.arguman.app.R;
import org.arguman.app.ui.view.ArgumanTextView;

import java.util.ArrayList;

public class SearchAdapter extends CursorAdapter {

    private ArrayList<String> items;
    private ArgumanTextView   text;

    public SearchAdapter(Context context, Cursor cursor, ArrayList<String> items) {
        super(context, cursor, false);
        this.items = items;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        text.setText(items.get(cursor.getPosition()));
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.search_item, parent, false);
        text = (ArgumanTextView) view.findViewById(R.id.item);
        return view;
    }

}
