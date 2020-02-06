package com.example.project_json.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.project_json.R;
import com.example.project_json.models.Unit;

import java.util.ArrayList;

public class ReadBookArrayAdapter extends ArrayAdapter<Unit> {
    private Context mContext;
    private int mLayoutId;
    public ArrayList<Unit> mList;
    public ReadBookArrayAdapter(Context context, int resource, ArrayList<Unit> list) {
        super(context, resource, list);
        mContext = context;
        mLayoutId = resource;
        mList = list;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.tvNumber = convertView.findViewById(R.id.tvNumber);
            viewHolder.tvTiEN = convertView.findViewById(R.id.tvTiEN);
            viewHolder.tvTiVN = convertView.findViewById(R.id.tvTiVN);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Unit unit = mList.get(position);
        viewHolder.tvNumber.setText(unit.getId()+"");
        viewHolder.tvTiEN.setText(unit.getTitleEN());
        viewHolder.tvTiVN.setText(unit.getTitleVI());

        convertView.getTag();
        return convertView;
    }

    private class ViewHolder {
        public TextView tvNumber,tvTiEN,tvTiVN;

    }
}