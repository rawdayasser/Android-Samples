package com.example.rawda.database_apps;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;

public class MainAdapter extends BaseAdapter implements Filterable {
    Context context;
    ArrayList<Class> classes;

    public MainAdapter(Context context, ArrayList<Class> classes) {
        this.classes = classes;
        this.context = context;
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    @Override
    public int getCount() {
        return classes.size();
    }

    @Override
    public Object getItem(int i) {
        return (Object) classes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.main_row, null, true);
        Button button = view.findViewById(R.id.button);
        button.setText(classes.get(i).getSimpleName());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, classes.get(i));
                context.startActivity(intent);
            }
        });
        return view;
    }
}
