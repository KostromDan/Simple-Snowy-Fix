package dev.kostromdan.mods.simple_snowy_fix;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Config {
    public static Path CONFIG_PATH = Paths.get("config", "simple_snowy_fix_common.json");

    /**
     * Boolean parameter to determine if snow should be placed on leaves under other leaves. Defaults to false.
     */
    private boolean placeSnowOnLeavesUnderLeaves = false;

    public boolean getPlaceSnowOnLeavesUnderLeaves() {
        return placeSnowOnLeavesUnderLeaves;
    }

    public void setPlaceSnowOnLeavesUnderLeaves(boolean value) {
        this.placeSnowOnLeavesUnderLeaves = value;
    }

    public static Config loadConfig() {
        File configFile = CONFIG_PATH.toFile();
        if (configFile.exists()) {
            try (FileReader reader = new FileReader(configFile)) {
                Gson gson = new Gson();
                Config config = gson.fromJson(reader, Config.class);
                return config != null ? config : new Config();
            } catch (IOException e) {
                SimpleSnowyFixMod.LOGGER.error("Error reading config file: ", e);
                return new Config();
            } catch (JsonSyntaxException e) {
                SimpleSnowyFixMod.LOGGER.error("Invalid JSON in config file: ", e);
                return new Config();
            }
        } else {
            Config defaultConfig = new Config();
            saveConfig(defaultConfig); // Create file with default values
            return defaultConfig;
        }
    }

    public static void saveConfig(Config config) {
        try {
            File configFile = CONFIG_PATH.toFile();
            File parentDir = configFile.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs(); // Ensure config directory exists
            }
            try (FileWriter writer = new FileWriter(configFile)) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(config, writer);
            }
        } catch (IOException e) {
            SimpleSnowyFixMod.LOGGER.error("Error writing config file: ", e);
        }
    }
}