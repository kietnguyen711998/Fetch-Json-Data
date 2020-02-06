package com.example.project_json.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.project_json.R;
import com.example.project_json.models.Unit;
import com.example.project_json.models.Vocabulary;

import java.util.ArrayList;

public class DetailBookArrayAdapter extends ArrayAdapter<Vocabulary> {
    private Context mContext;
    private int mLayoutId;
    public ArrayList<Vocabulary> mList;
    public DetailBookArrayAdapter(Context context, int resource, ArrayList<Vocabulary> list) {
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

            viewHolder.tvWord       = convertView.findViewById(R.id.tvWord);
            viewHolder.tvType       = convertView.findViewById(R.id.tvType);
            viewHolder.tvPronunciation = convertView.findViewById(R.id.tvPronunciation);
            viewHolder.tvMean       = convertView.findViewById(R.id.tvMean);
            viewHolder.tvExample    = convertView.findViewById(R.id.tvExample);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Vocabulary v = mList.get(position);
        viewHolder.tvWord.setText(v.getWord());
        viewHolder.tvType.setText(v.getType());
        viewHolder.tvPronunciation.setText(v.getPronunciation());
        viewHolder.tvMean.setText(v.getVietnameseMean());
        viewHolder.tvExample.setText(v.getExample());
        convertView.getTag();
        return convertView;
    }

    private class ViewHolder {
        public TextView tvWord,tvType,tvPronunciation,tvMean,tvExample;

    }
}