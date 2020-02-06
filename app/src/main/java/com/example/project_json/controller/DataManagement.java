package com.example.project_json.controller;

import android.content.Context;

import com.example.project_json.models.Unit;
import com.example.project_json.models.Vocabulary;
import com.example.project_json.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class DataManagement {
    private static DataManagement sInstance;
    private ArrayList<Unit> mUnitList;
    private HashMap<Integer ,ArrayList<Vocabulary>> mVocabularyList;

    private DataManagement(){
        mUnitList = new ArrayList<>();
        mVocabularyList = new HashMap<>();
    }
    public static  DataManagement getsInstance(){
        if (sInstance == null){
            sInstance = new DataManagement();
        }
        return sInstance;
    }

    public ArrayList<Unit> getUnits(){
        return mUnitList;
    }
    //hash map ko co lay toan bo
     public ArrayList<Vocabulary> getVocabularies(Unit unit){
        return mVocabularyList.get(unit.getId());
    }
    //check id
//    public ArrayList<Vocabulary> getVocabularies(Unit unit){
//        ArrayList<Vocabulary> list = new ArrayList<>();
//        for (Vocabulary v : mVocabularyList){
//            if(v.getUnitId() ==unit.getId()){
//                list.add(v);
//            }
//        }
//        return list;
//    }
    //hashmap Vocabulary
    public void add(Vocabulary v){
        ArrayList<Vocabulary> list = mVocabularyList.get(v.getUnitId());
        if (list == null){
            list = new ArrayList<>();
            //day ds vao (list) ban dau null chua khoi tao
            mVocabularyList.put(v.getUnitId(),list);

        }
        list.add(v);
    }
    public  void load(Context context){
        //doc noi dung
        String content = Utils.readAssets(context,"data.json");
        try {
            JSONObject jsonObject = new JSONObject(content);
            // Units
            JSONArray jsonArray = jsonObject.getJSONArray("units");
            for (int i = 0; i< jsonArray.length();i++){
                JSONObject object = jsonArray.getJSONObject(i);
                int id = object.getInt(Unit.FIELD_ID);
                String titleEN = object.getString(Unit.FIELD_TITLEEN);
                String titleVI = object.getString(Unit.FIELD_TITLEVI);
                Unit s = new Unit(id,titleEN,titleVI);
                mUnitList.add(s);
            }
            //Vocabulary
            JSONArray jsonArrayVo = jsonObject.getJSONArray("vocabularies");
            for (int j = 0; j< jsonArrayVo.length();j++){
                JSONObject objectVo = jsonArrayVo.getJSONObject(j);
                int unitId = objectVo.getInt(Vocabulary.FIELD_UNIT_ID);
                String word = objectVo.getString(Vocabulary.FIELD_WORD);
                String type = objectVo.getString(Vocabulary.FIELD_TYPE);
                String pronunciation = objectVo.getString(Vocabulary.FIELD_PRONUNCIATION);
                String vietnameseMean = objectVo.getString(Vocabulary.FIELD_VIETNAMESEMEAN);
                String example = objectVo.getString(Vocabulary.FIELD_EXAMPLE);

                Vocabulary v = new Vocabulary(unitId,word,type,pronunciation,vietnameseMean,example);
                add(v);
            }


//            Toast.makeText(context,"Units" + version,Toast.LENGTH_SHORT).show();
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
