package net.brokem.fabric.config.configapi;

/**
 *
 * extends this class and override addConfigs
 *
 */

public class ConfigBuilderAccessor {
    ConfigBuilderAccessor INSTANCE = new ConfigBuilderAccessor();

    /**
     *
     * @param builder ue this parameter to add config;
     *
     * use like this:
     *  builder.integerConfig.put("example key", integer value like: 0, 1...).
     *
     */
    public void addConfigs(ConfigBuilder builder) {
    }

    public void accessor(ConfigBuilder builder) {
        INSTANCE.addConfigs(builder);
    }
}
