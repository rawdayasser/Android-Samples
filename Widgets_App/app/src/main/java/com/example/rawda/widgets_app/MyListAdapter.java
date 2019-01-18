package com.example.rawda.widgets_app;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter <String>{
    Activity context;
    int[] images;
    String[] titles;
    String[] subtitles;
    public MyListAdapter(@NonNull Activity context, int[] images, String[] titles, String[] subtitles) {
        super(context, R.layout.list_row, titles);
        this.context = context;
        this.images = images;
        this.titles = titles;
        this.subtitles = subtitles;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.list_row, null, true);
        ImageView image = view.findViewById(R.id.image);
        TextView title = view.findViewById(R.id.title);
        TextView subtitle = view.findViewById(R.id.sub_title);
        image.setImageResource(images[position]);
        title.setText(titles[position]);
        subtitle.setText(subtitles[position]);

        return view;
    }
}
