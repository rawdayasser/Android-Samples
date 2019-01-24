package com.example.rawda.activityandintents_app;

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

public class MyMainAdapter extends BaseAdapter implements Filterable {
    ArrayList<Class> buttons;
    Context context;

    public MyMainAdapter(Context context, ArrayList<Class> buttons) {
        super();
        this.buttons = buttons;
        this.context = context;
    }

    @Override
    public int getCount() {
        return buttons.size();
    }

    @Override
    public Object getItem(int i) {
        return buttons.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.main_list_row, null, true);
        ViewHolder holder = new ViewHolder();
        holder.button = view.findViewById(R.id.main_button);
        holder.button.setText(buttons.get(i).getSimpleName());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, buttons.get(i));
                context.startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public Filter getFilter() {
        return null;
    }
    private class ViewHolder{
        Button button;
    }
}
