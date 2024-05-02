package com.cylorun.autosaveadjust;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class AutoSaveOptions {
    public int interval_seconds = 5;
    private static AutoSaveOptions instance;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    public static AutoSaveOptions getInstance() {
        if (instance == null) {
            if (Files.exists(AutoSaveAdjust.CONFIG_PATH)) {
                try {
                    instance = GSON.fromJson(new String((Files.readAllBytes(AutoSaveAdjust.CONFIG_PATH))), AutoSaveOptions.class);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                instance = new AutoSaveOptions();
                save();
            }

        }
        return instance;
    }

    public static void save() {
        FileWriter writer;
        try {
            writer = new FileWriter(AutoSaveAdjust.CONFIG_PATH.toFile());
            GSON.toJson(instance, writer);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
