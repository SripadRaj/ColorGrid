package com.opteamix.colorgrid;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by SRamesh on 7/7/2016.
 */
public class ColorAdapter extends BaseAdapter {

    private Context context;
    private List<String> colors;
    public int mSelectedPosition = -1;

    public ColorAdapter(Context c,List<String> colors){
        this.context = c;
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return colors.size();
    }

    @Override
    public String getItem(int position) {
        return colors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.color_item,parent,false);
        LinearLayout colorView = (LinearLayout) v.findViewById(R.id.color);
        FrameLayout selectorView = (FrameLayout) v.findViewById(R.id.selector);

        colorView.setBackgroundColor(Color.parseColor(colors.get(position)));

        if(position == mSelectedPosition){
            selectorView.setBackgroundResource(R.drawable.ic_selected);
        }else{
            notifyDataSetChanged();
        }


        return v;
    }
}
