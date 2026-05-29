package com.arakan.rpglike.save;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.arakan.rpglike.character.player.Player;
import com.google.gson.Gson;

public class SaveManager {
	public static void save(SaveData data) {
		   
    	try {
    		Gson gson = new Gson();
			FileWriter writer = new FileWriter("save/save.json");
			gson.toJson(data, writer);
			System.out.println("セーブしました。");
			writer.close();
		} catch (Exception e) {
			System.out.println("セーブに失敗しました。");
			e.printStackTrace();
		}
    	
    }

	public static Player load() {

		Player player = new Player();
	    try {
	        File dir = new File("save");
	        // saveフォルダが無ければ作成
	        if (!dir.exists()) {
	            dir.mkdirs();
	        }
	        File file = new File("save/save.json");
	        // save.json が無ければ初期セーブ作成
	        if (!file.exists()) {
	            System.out.println("セーブデータが無いため新規作成します");
	            SaveData initData = new SaveData();
	            // 初期値設定
	            initData.initializeData();
	            Gson gson = new Gson();
	            FileWriter writer = new FileWriter(file);
	            gson.toJson(initData, writer);
	            writer.close();
	        }
	        // ロード処理
	        System.out.println("ロードします");
	        Gson gson = new Gson();
	        FileReader reader = new FileReader(file);
	        SaveData data = gson.fromJson(reader, SaveData.class);
	        reader.close();
	        player.initialize(data);
	        return player;
	    } catch (IOException e) {
	        System.out.println("ロードに失敗しました。");
	        e.printStackTrace();
	    }
	    return player;
	}
}
