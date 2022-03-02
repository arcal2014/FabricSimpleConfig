package net.brokem.fabric.config.configapi;

import java.util.HashMap;

public class ConfigBuilder {
    private static ConfigBuilder INSTANCE = new ConfigBuilder();

    public HashMap<String, Integer> integerConfig = ConfigValuesManager.INTEGER_SPEC;
    public HashMap<String, Boolean> booleanConfig = ConfigValuesManager.BOOLEAN_SPEC;
    public HashMap<String, Float> floatConfig = ConfigValuesManager.FLOAT_SPEC;
    public HashMap<String, Double> doubleConfig = ConfigValuesManager.DOUBLE_SPEC;
    public HashMap<String, Byte> byteConfig = ConfigValuesManager.BYTE_SPEC;
    public HashMap<String, Long> longConfig = ConfigValuesManager.LONG_SPEC;
    public HashMap<String, String> stringConfig = ConfigValuesManager.STRING_SPEC;
    public HashMap<String, Character> charConfig = ConfigValuesManager.CHARACTER_SPEC;

    public static void addConfig() {
        new ConfigBuilderAccessor().accessor(INSTANCE);
    }
}
