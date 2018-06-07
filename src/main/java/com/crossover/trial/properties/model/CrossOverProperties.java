package com.crossover.trial.properties.model;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Wrapper over {@link Properties} that provides type safe accessors for string, integer and boolean values.
 */
public class CrossOverProperties {

    private static final Logger LOGGER = Logger.getLogger(CrossOverProperties.class.getName());

    private Map<String, String> propertyMap = new HashMap<>();

    /**
     * Constructs an empty object.
     */
    public CrossOverProperties() {
    }

    /**
     * Constructs and object with the specified properties.
     *
     * @param properties the {@link Properties} of the new object
     */
    public CrossOverProperties(Properties properties) {
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            if (StringUtils.isEmpty(value)) {
                LOGGER.severe("Missing property value for: " + key);
            } else {
                put(key, value);
            }
        }
    }

    /**
     * Copies all the properties from the given {@code CrossOverProperties} to this object.
     *
     * @param properties the {@code CrossOverProperties} to be copied
     */
    public void putAll(CrossOverProperties properties) {
        propertyMap.putAll(properties.propertyMap);
    }

    /**
     * Adds a property having the specified key and value.
     *
     * @param key   the property key
     * @param value the property value
     */
    public void put(String key, String value) {
        propertyMap.put(key, value);
    }

    /**
     * Returns a string representation of this object. The representation will have the following format:
     * "<property key>, <property class>, <property value>".
     *
     * @return the string representation of this object
     */
    @Override
    public String toString() {
        return propertyMap.entrySet().stream()
                .map(entry -> entry.getKey() + ", " + getPropertyClass(entry.getValue()).getName() + ", "
                        + entry.getValue())
                .collect(Collectors.joining("\n"));
    }

    private Class<?> getPropertyClass(String propertyValue) {
        try {
        	switch(propertyValue) {
        		case "true":
        			return Boolean.class;
        		case "false":
        			return Boolean.class;
        		default:
        			System.out.println(Integer.valueOf(propertyValue));
        			return Integer.class;
        	}
            //Integer.valueOf(propertyValue);
            //return Integer.class;
        } catch (NumberFormatException exception) {
            return String.class;
        }
    }

    /**
     * Returns the number of properties.
     *
     * @return the numbre of properties
     */
    public int size() {
        return propertyMap.size();
    }

    /**
     * Gets the property with the given key.
     *
     * @param key the property key
     * @return the value associated with the given key
     */
    public String get(String key) {
        return propertyMap.get(key);
    }

    /**
     * Gets the integer value associated with the given key.
     *
     * @param key the property key
     * @return the associated integer value
     * @throws NumberFormatException if the value does not contain a
     *                               parsable integer.
     */
    public int getInteger(String key) {
        return Integer.parseInt(get(key));
    }

    /**
     * Gets the boolean value associated with the given key.
     *
     * @param key the property key
     * @return the associated boolean value
     */
    public boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }
}
