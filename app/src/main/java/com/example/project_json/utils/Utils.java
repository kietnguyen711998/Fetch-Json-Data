package com.example.project_json.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utils {
    public static String readAssets(Context context, String path){
        String content = "";
        try {
            InputStream is = context.getAssets().open(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = br.readLine();
//            int ch = is.read();
            while (line != null){
                content += line + "\n";
                line = br.readLine();
            }
            is.close();
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return content;
    }
}
