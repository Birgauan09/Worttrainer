package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

public class JSONUsage {
    public JSONUsage() {
        try {
            FileReader fileReader= new FileReader("daten.json");
            JsonParser jsonParser= new JsonParser();
            JsonObject jsonData= jsonParser.parse(fileReader).getAsJsonObject();
            Rechtschreibtrainer rt= new Rechtschreibtrainer();

            JsonArray entries= jsonData.getAsJsonArray("entries");
            for(int i=0; i< entries.size(); i++) {
                JsonObject entry= entries.get(i).getAsJsonObject();
                String name= entry.get("name").getAsString();
                String url= entry.get("url").getAsString();
                rt.openFrame(name, url, "Bitte erraten Sie das Bild!: ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
