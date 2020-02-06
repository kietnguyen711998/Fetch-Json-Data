package com.example.project_json.models;

public class Vocabulary {
    public static final String FIELD_UNIT_ID ="unitId";
    public static final String FIELD_WORD ="word";
    public static final String FIELD_TYPE ="type";
    public static final String FIELD_PRONUNCIATION ="pronunciation";
    public static final String FIELD_VIETNAMESEMEAN ="vietnameseMean";
    public static final String FIELD_EXAMPLE ="example";


    private int unitId;
    private String word,type,pronunciation,vietnameseMean,example;

    public Vocabulary(int unitId, String word, String type, String pronunciation, String vietnameseMean, String example) {
        this.unitId = unitId;
        this.word = word;
        this.type = type;
        this.pronunciation = pronunciation;
        this.vietnameseMean = vietnameseMean;
        this.example = example;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getVietnameseMean() {
        return vietnameseMean;
    }

    public void setVietnameseMean(String vietnameseMean) {
        this.vietnameseMean = vietnameseMean;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    @Override
    public String toString() {
        {
            return unitId + "\nWord" + word + "\nType" + type + "\nPronunciation"+ pronunciation + "\nvietnameseMean" + vietnameseMean+  "\nExample"+example;
        }
    }
}
