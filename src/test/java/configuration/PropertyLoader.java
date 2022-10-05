package configuration;

import java.io.IOException;
import java.util.Properties;

import static com.google.common.base.Strings.isNullOrEmpty;

public class PropertyLoader {
    private static final String TEST_CONFIG = "test.properties";

    public enum Property {
        PLATFORM_NAME("platform.name"),
        PLATFORM_VERSION("platform.version"),
        DEVICE_NAME("device.name"),
        DEVICE_ADDRESS("device.address"),
        APP_PACKAGE("app.package"),
        APP_ACTIVITY("app.activity"),
        WAIT("explicit.wait");

        public final String key;

        Property(String key) {
            this.key = key;
        }
    }

    private static final Properties properties;

    static {
        Properties environmentProperties = loadPropertiesFrom(TEST_CONFIG);
        properties = new Properties();
        properties.putAll(environmentProperties);
    }

    public static String get(Property property) {
        String propFromFile = PropertyLoader.properties.getProperty(property.key);
        if (!isNullOrEmpty(propFromFile)) {
            return propFromFile;
        }
        throw new RuntimeException(String.format("Could not load property '%s'", property.key));
    }

    private static Properties loadPropertiesFrom(String file) {
        Properties result = new Properties();
        try {
            result.load(PropertyLoader.class.getClassLoader().getResourceAsStream(file));
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException(String.format("Could not load properties from %s file", file));
        }
        return result;
    }
}
