package com.crossover.trial.properties.model;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class CustomProperties {
	
	private LinkedHashMap<String,String> orderedProperties = new LinkedHashMap<>();
	
    private static final Logger LOGGER = Logger.getLogger(CustomProperties.class.getName());
	
	public CustomProperties(LinkedHashMap<String,String> map) {
		
		for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            if (StringUtils.isEmpty(value)) {
                LOGGER.severe("Missing property value for: " + key);
            } else {
                put(key, value);
            }
        }
	}
	
	public CustomProperties() {
		orderedProperties = new LinkedHashMap<String,String>();
	}
	
	 /**
     * Copies all the properties from the given {@code CrossOverProperties} to this object.
     *
     * @param properties the {@code CrossOverProperties} to be copied
     */
    public void putAll(CustomProperties properties) {
    	Set<String> propertyKeys=properties.orderedProperties.keySet();
    	Iterator<String> itr=propertyKeys.iterator();
    	while(itr.hasNext()){
    		String key = itr.next();
        	if(orderedProperties.containsKey(key)){
        		orderedProperties.remove(key);
        	}
    	}
        orderedProperties.putAll(properties.orderedProperties);
    }
    
    /**
     * Adds a property having the specified key and value.
     *
     * @param key   the property key
     * @param value the property value
     */
    public void put(String key, String value) {
        orderedProperties.put(key, value);
    }

    /**
     * Returns a string representation of this object. The representation will have the following format:
     * "<property key>, <property class>, <property value>".
     *
     * @return the string representation of this object
     */
    @Override
    public String toString() {
        return orderedProperties.entrySet().stream()
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
        			Integer.valueOf(propertyValue);
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
        return orderedProperties.size();
    }

    /**
     * Gets the property with the given key.
     *
     * @param key the property key
     * @return the value associated with the given key
     */
    public String get(String key) {
        return orderedProperties.get(key);
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
