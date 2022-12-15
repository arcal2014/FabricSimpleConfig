package net.brokem.fabric.config.configapi;

import java.util.HashMap;

/**
 *
 * this is where the specs are registered
 *
 */

public class ConfigValuesManager {
    public static HashMap<String, Integer> INTEGER_SPEC = new HashMap<String, Integer>();
    public static HashMap<String, Boolean> BOOLEAN_SPEC = new HashMap<String, Boolean>();
    public static HashMap<String, Float> FLOAT_SPEC = new HashMap<String, Float>();
    public static HashMap<String, Double> DOUBLE_SPEC = new HashMap<String, Double>();
    public static HashMap<String, Byte> BYTE_SPEC = new HashMap<String, Byte>();
    public static HashMap<String, Long> LONG_SPEC = new HashMap<String, Long>();
    public static HashMap<String, String> STRING_SPEC = new HashMap<String, String>();
    public static HashMap<String, Character> CHARACTER_SPEC = new HashMap<String, Character>();

    public static void defaultConfigValues() {
        ConfigBuilder.addConfig();
    }

    public static void setIntegerSpecConfigValue(String key, int value) {
        INTEGER_SPEC.put(key, value);
    }

    public static void setBooleanSpecConfigValue(String key, boolean value) {
        BOOLEAN_SPEC.put(key, value);
    }

    public static void setFloatSpecConfigValue(String key, float value) {
        FLOAT_SPEC.put(key, value);
    }

    public static void setDoubleSpecConfigValue(String key, double value) {
        DOUBLE_SPEC.put(key, value);
    }

    public static void setByteSpecSpecConfigValue(String key, byte value) {
        BYTE_SPEC.put(key, value);
    }

    public static void setLongSpecSpecConfigValue(String key, long value) {
        LONG_SPEC.put(key, value);
    }

    public static void setStringSpecSpecConfigValue(String key, String value) {
        STRING_SPEC.put(key, value);
    }

    public static void setCharSpecSpecConfigValue(String key, Character value) {
        CHARACTER_SPEC.put(key, value);
    }
}
