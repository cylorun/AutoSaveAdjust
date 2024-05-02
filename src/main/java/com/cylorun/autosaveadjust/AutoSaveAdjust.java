package com.cylorun.autosaveadjust;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;

import org.apache.logging.log4j.*;

import java.nio.file.Path;

public class AutoSaveAdjust implements ModInitializer {
    public static final ModContainer MOD_CONTAINER = FabricLoader.getInstance().getModContainer("autosaveadjust").orElseThrow(RuntimeException::new);
    public static final String MOD_NAME = MOD_CONTAINER.getMetadata().getName();
    public static final String MOD_VERSION = String.valueOf(MOD_CONTAINER.getMetadata().getVersion());
    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);
    public static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("autosave.json");

    public static void log(Object msg) {
        LOGGER.log(Level.INFO, msg);
    }

    @Override
    public void onInitialize() {
        log("Using " + MOD_NAME + " v" + MOD_VERSION);
    }
}
