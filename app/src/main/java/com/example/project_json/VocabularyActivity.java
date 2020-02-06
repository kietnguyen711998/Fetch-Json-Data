package com.example.project_json;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.project_json.adapter.DetailBookArrayAdapter;
import com.example.project_json.adapter.ReadBookArrayAdapter;
import com.example.project_json.controller.DataManagement;
import com.example.project_json.models.Unit;
import com.example.project_json.models.Vocabulary;

import java.util.ArrayList;

public class VocabularyActivity extends AppCompatActivity {
    private ListView lvApply;
    private ArrayList<Vocabulary> mList;
    private ArrayAdapter<Vocabulary> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);
        setWidgets();

        Intent intent = getIntent();
        Unit unit = (Unit) intent.getSerializableExtra("PassActivity2");
        mList = DataManagement.getsInstance().getVocabularies(unit);

//        mAdapter = new ArrayAdapter<Vocabulary>(this,android.R.layout.i, mList);
        mAdapter = new DetailBookArrayAdapter(this, R.layout.items_listview_vocabulary, mList);
        lvApply.setAdapter(mAdapter);
        lvApply.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }
    public void setWidgets(){
        lvApply = findViewById(R.id.lvApply);
    }
}
