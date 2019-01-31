package com.example.rawda.menu_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.ArrayList;

public class MyMainAdapter extends BaseAdapter {
    Context context;
    ArrayList<Class> activities;

    public MyMainAdapter(Context context, ArrayList<Class> activities) {
        this.context = context;
        this.activities = activities;
    }

    @Override
    public int getCount() {
        return activities.size();
    }

    @Override
    public Object getItem(int i) {
        return (Object)activities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.main_row, null, true);
        ViewHolder holder = new ViewHolder();
        holder.button = view.findViewById(R.id.button);
        holder.button.setText(activities.get(i).getSimpleName());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, activities.get(i));
                context.startActivity(intent);
            }
        });
        return view;
    }
    private class ViewHolder{
      Button button;

    }
}
