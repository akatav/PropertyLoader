package com.crossover.trial.properties.parser;

import com.crossover.trial.properties.model.CustomProperties;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;

import org.apache.commons.io.IOUtils;

/**
 * Implementation of a strategy for parsing properties from JSON strings.
 */
public class JsonPropertiesParser implements PropertiesParser {

    private Gson gson = new Gson();

    /**
     * @see PropertiesParser#parseProperties(String)
     */
    /*
    @Override
    public CrossOverProperties parseProperties(String toBeParsed) {
        Properties properties = gson.fromJson(toBeParsed, Properties.class);
        if (properties == null) {
            properties = new Properties();
        }
        return new CrossOverProperties(properties);
    }
*/
	@Override
	public CustomProperties parseProperties(InputStream is) throws IOException {
		Type ResponseList = new TypeToken<LinkedHashMap<String, String>>() {}.getType();
		LinkedHashMap<String,String> map = gson.fromJson(IOUtils.toString(is).toLowerCase(), ResponseList);
		CustomProperties customProperties = new CustomProperties(map);
		return customProperties;
	}
}
