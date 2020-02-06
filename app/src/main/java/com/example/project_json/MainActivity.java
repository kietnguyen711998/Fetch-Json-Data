package com.example.project_json;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.project_json.adapter.ReadBookArrayAdapter;
import com.example.project_json.controller.DataManagement;
import com.example.project_json.models.Unit;
import com.example.project_json.models.Vocabulary;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView tvNumber,tvTiEn,tvTiVN;
    private ListView lvDetail;
    private ReadBookArrayAdapter mAdapter;
    private ArrayList<Unit> mList;
    private int mCurrentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWidgets();
        //Units
        DataManagement.getsInstance().load(this);
        mList = DataManagement.getsInstance().getUnits();

        mAdapter = new ReadBookArrayAdapter(this, R.layout.items_listview, mList);
        lvDetail.setAdapter(mAdapter);

        lvDetail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mCurrentIndex = i;
                Intent intent = new Intent(MainActivity.this, VocabularyActivity.class);
                Unit unit = mList.get(i);
                intent.putExtra("PassActivity2", unit);
                startActivity(intent);
            }
        });


    }
    public void setWidgets(){
        tvNumber = findViewById(R.id.tvNumber);
        tvTiEn = findViewById(R.id.tvTiEN);
        tvTiVN = findViewById(R.id.tvTiVN);
        lvDetail = findViewById(R.id.lvDetail);
    }
}
