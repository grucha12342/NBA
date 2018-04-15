package com.example.misiek.nba;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<Match> {

    private final Context context;
    private final ArrayList<Match> itemsArrayList;

    public MyAdapter(Context context, ArrayList<Match> itemsArrayList) {

        super(context, R.layout.row, itemsArrayList);

        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // 3. Get the two text view from the rowView
        TextView labelAwayView = (TextView) rowView.findViewById(R.id.labelAway);
        TextView valueAwayView = (TextView) rowView.findViewById(R.id.valueAway);
        TextView labelHomeView = (TextView) rowView.findViewById(R.id.labelHome);
        TextView valueHomeView = (TextView) rowView.findViewById(R.id.valueHome);

        // 4. Set the text for textView
        labelAwayView.setText(itemsArrayList.get(position).getAwayTeamTriCode());
        valueAwayView.setText(itemsArrayList.get(position).getAwayTeamScore()+"");
        labelHomeView.setText(itemsArrayList.get(position).getHomeTeamTriCode());
        valueHomeView.setText(itemsArrayList.get(position).getHomeTeamScore()+"");

        // 5. retrn rowView
        return rowView;
    }
}
