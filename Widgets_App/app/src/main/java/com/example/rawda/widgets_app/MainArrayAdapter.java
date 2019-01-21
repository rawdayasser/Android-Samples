package com.example.rawda.widgets_app;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import java.util.ArrayList;

public class MainArrayAdapter extends BaseAdapter implements Filterable{
    private ArrayList<String>  buttonText;
    private ArrayList<Class> activity;
    private ArrayList<String> _buttonText;
    private Context context;


    public MainArrayAdapter(Context context, ArrayList<String> buttonText, ArrayList<Class> activity) {
        super();
        this.buttonText = buttonText;
        this._buttonText = new ArrayList<>(buttonText);
        this.activity = activity;
        this.context = context;
        //_buttonText = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return buttonText.size();
    }

    @Override
    public Object getItem(int i) {
        return buttonText.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater;
        ViewHolder holder = new ViewHolder();
        //if (convertView == null) {
            inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.main_list_row, null, true);
            holder.text = convertView.findViewById(R.id.main_text);
            holder.button = convertView.findViewById(R.id.main_button);
            holder.text.setText(buttonText.get(position));
            holder.button.setText("GO");
       // }else {
          //  holder =(ViewHolder)convertView.getTag();
        //}
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, activity.get(position));
                    context.startActivity(intent);
                }
            });

        return convertView;
    }

    @Override
    public boolean isEmpty() {
        return buttonText.isEmpty();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                ArrayList<String> resultsList = new ArrayList<>();
                if (buttonText == null){
                    buttonText = new ArrayList<>(_buttonText);
                }
                Log.d("MainArrayAdapter", _buttonText.size() + "");
                if (buttonText.size() == 0 || buttonText.size() != buttonText.size())
                    buttonText = _buttonText;
                if (buttonText != null && !buttonText.equals(null) && buttonText.size() > 0){
                    for (final String button_text : buttonText){
                            if (button_text.toLowerCase().contains(charSequence.toString())) {
                                resultsList.add(button_text);
                            }

                    }
                    filterResults.count = resultsList.size();
                    filterResults.values = resultsList;
                }
                if (charSequence.length() == 0 || charSequence.equals(null)){
               //     Log.d("Adapter", buttonText.get(0));
                    filterResults.count = buttonText.size();
                    filterResults.values = buttonText;
                }
             //   notifyDataSetChanged();
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                buttonText = (ArrayList<String>) filterResults.values;
                Log.d("MainArrayAdapter", buttonText.size() + "");
                notifyDataSetChanged();
            }
        };
    }



    public class ViewHolder{
        TextView text;
        Button button;

        public ViewHolder() {
        }
    }
}