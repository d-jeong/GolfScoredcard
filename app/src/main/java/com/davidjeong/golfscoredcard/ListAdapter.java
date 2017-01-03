package com.davidjeong.golfscoredcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;


public class ListAdapter extends BaseAdapter {
    private final Context mContext;
    private final Hole[] mHoles;

    public ListAdapter (Context context, Hole[] holes) {
        mContext = context;
        mHoles = holes;
    }
    
    @Override
    public int getCount() {
        return mHoles.length;
    }

    @Override
    public Object getItem(int position) {
        return mHoles[position];
    }

    @Override
    public long getItemId(int position) {
        return 0; // Not implemented
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.holeLabel = (TextView) convertView.findViewById(R.id.holeLabel);
            holder.holeScore = (TextView) convertView.findViewById(R.id.holeScore);
            holder.minusButton = (Button) convertView.findViewById(R.id.minusButton);
            holder.plusButton = (Button) convertView.findViewById(R.id.plusButton);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.holeLabel.setText(mHoles[position].getLabel());
        holder.holeScore.setText(mHoles[position].getHoleScore() + "");

        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int updatedScore = mHoles[position].getHoleScore() - 1;
                if (updatedScore < 0) {
                    updatedScore = 0;
                }

                mHoles[position].setHoleScore(updatedScore);
                holder.holeScore.setText(updatedScore + "");
            }
        });

        holder.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int updatedScore = mHoles[position].getHoleScore() + 1;

                mHoles[position].setHoleScore(updatedScore);
                holder.holeScore.setText(updatedScore + "");
            }
        });

        return convertView;
    }

    private static class ViewHolder {
        TextView holeLabel;
        TextView holeScore;
        Button minusButton;
        Button plusButton;
    }
}
