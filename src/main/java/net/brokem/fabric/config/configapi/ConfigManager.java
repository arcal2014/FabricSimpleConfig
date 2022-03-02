package net.brokem.fabric.config.configapi;

import com.google.gson.*;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.util.Arrays;

/**
 *
 * this is the json factory
 *
 */

public class ConfigManager {
    public static File file;

    public static final Gson GSON = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .create();

    public static void initConfig(String modId) {

        ConfigValuesManager.defaultConfigValues();

        file = new File(FabricLoader.getInstance().getConfigDir().toFile(), modId + "_config.json");

        if (!file.exists()) {
            System.out.println("Could not find config, generating new default config.");
            saveConfig();
        } else {
            System.out.println("Reading config values from file.");
            readConfig();
        }
    }

    private static void readConfig() {
        try {
            BufferedReader buf = new BufferedReader(new FileReader(file));
            JsonObject json = (JsonObject) JsonParser.parseReader(buf);

            for (String key : ConfigValuesManager.INTEGER_SPEC.keySet()) {
                if(json.get(key) != null)
                    ConfigValuesManager.setIntegerSpecConfigValue(key, json.get(key).getAsInt());
                else
                    System.err.println("Key Error: Could not find key: " + key);
            }

            for (String key : ConfigValuesManager.BOOLEAN_SPEC.keySet()) {
                if(json.get(key) != null)
                    ConfigValuesManager.setBooleanSpecConfigValue(key, json.get(key).getAsBoolean());
                else
                    System.err.println("Key Error: Could not find key: " + key);
            }

            for (String key : ConfigValuesManager.FLOAT_SPEC.keySet()) {
                if(json.get(key) != null)
                    ConfigValuesManager.setFloatSpecConfigValue(key, json.get(key).getAsFloat());
                else
                    System.err.println("Key Error: Could not find key: " + key);
            }

            for (String key : ConfigValuesManager.DOUBLE_SPEC.keySet()) {
                if(json.get(key) != null)
                    ConfigValuesManager.setFloatSpecConfigValue(key, json.get(key).getAsDouble());
                else
                    System.err.println("Key Error: Could not find key: " + key);
            }

            for (String key : ConfigValuesManager.BYTE_SPEC.keySet()) {
                if(json.get(key) != null)
                    ConfigValuesManager.setByteSpecSpecConfigValue(key, json.get(key).getAsByte());
                else
                    System.err.println("Key Error: Could not find key: " + key);
            }

            for (String key : ConfigValuesManager.LONG_SPEC.keySet()) {
                if(json.get(key) != null)
                    ConfigValuesManager.setLongSpecSpecConfigValue(key, json.get(key).getAsLong());
                else
                    System.err.println("Key Error: Could not find key: " + key);
            }

            for (String key : ConfigValuesManager.STRING_SPEC.keySet()) {
                if(json.get(key) != null)
                    ConfigValuesManager.setStringSpecSpecConfigValue(key, json.get(key).getAsString());
                else
                    System.err.println("Key Error: Could not find key: " + key);
            }

            for (String key : ConfigValuesManager.CHARACTER_SPEC.keySet()) {
                if(json.get(key) != null)
                    ConfigValuesManager.setCharSpecSpecConfigValue(key, json.get(key).getAsCharacter());
                else
                    System.err.println("Key Error: Could not find key: " + key);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void saveConfig() {
        JsonObject config = new JsonObject();

        Object[] integerKeys = ConfigValuesManager.INTEGER_SPEC.keySet().toArray();
        Arrays.sort(integerKeys);

        Object[] booleanKeys = ConfigValuesManager.BOOLEAN_SPEC.keySet().toArray();
        Arrays.sort(booleanKeys);

        Object[] floatKeys = ConfigValuesManager.FLOAT_SPEC.keySet().toArray();
        Arrays.sort(floatKeys);

        Object[] doubleKeys = ConfigValuesManager.DOUBLE_SPEC.keySet().toArray();
        Arrays.sort(doubleKeys);

        Object[] byteKeys = ConfigValuesManager.BYTE_SPEC.keySet().toArray();
        Arrays.sort(byteKeys);

        Object[] longKeys = ConfigValuesManager.LONG_SPEC.keySet().toArray();
        Arrays.sort(longKeys);

        Object[] stringKeys = ConfigValuesManager.STRING_SPEC.keySet().toArray();
        Arrays.sort(stringKeys);

        Object[] charKeys = ConfigValuesManager.CHARACTER_SPEC.keySet().toArray();
        Arrays.sort(charKeys);

        for(Object key : integerKeys) {
            config.addProperty((String) key, ConfigValuesManager.INTEGER_SPEC.get(key));
            System.out.println("Adding key=" + key + ", value=" + ConfigValuesManager.INTEGER_SPEC.get(key));
        }

        for(Object key : booleanKeys) {
            config.addProperty((String) key, ConfigValuesManager.BOOLEAN_SPEC.get(key));
            System.out.println("Adding key=" + key + ", value=" + ConfigValuesManager.BOOLEAN_SPEC.get(key));
        }

        for(Object key : floatKeys) {
            config.addProperty((String) key, ConfigValuesManager.FLOAT_SPEC.get(key));
            System.out.println("Adding key=" + key + ", value=" + ConfigValuesManager.FLOAT_SPEC.get(key));
        }

        for(Object key : doubleKeys) {
            config.addProperty((String) key, ConfigValuesManager.DOUBLE_SPEC.get(key));
            System.out.println("Adding key=" + key + ", value=" + ConfigValuesManager.DOUBLE_SPEC.get(key));
        }

        for(Object key : byteKeys) {
            config.addProperty((String) key, ConfigValuesManager.BYTE_SPEC.get(key));
            System.out.println("Adding key=" + key + ", value=" + ConfigValuesManager.BYTE_SPEC.get(key));
        }

        for(Object key : longKeys) {
            config.addProperty((String) key, ConfigValuesManager.LONG_SPEC.get(key));
            System.out.println("Adding key=" + key + ", value=" + ConfigValuesManager.LONG_SPEC.get(key));
        }

        for(Object key : stringKeys) {
            config.addProperty((String) key, ConfigValuesManager.STRING_SPEC.get(key));
            System.out.println("Adding key=" + key + ", value=" + ConfigValuesManager.STRING_SPEC.get(key));
        }

        for(Object key : charKeys) {
            config.addProperty((String) key, ConfigValuesManager.CHARACTER_SPEC.get(key));
            System.out.println("Adding key=" + key + ", value=" + ConfigValuesManager.CHARACTER_SPEC.get(key));
        }

        String jsonConfig = GSON.toJson(config);

        try {
            FileWriter writer = new FileWriter(file);
            writer.write(jsonConfig);
            writer.close();
        } catch (IOException e) {
            System.err.println("Could not save config file.");
            e.printStackTrace();
        }
    }
}
