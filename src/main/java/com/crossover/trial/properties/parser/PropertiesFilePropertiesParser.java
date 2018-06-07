package com.crossover.trial.properties.parser;

import com.crossover.trial.properties.model.CustomProperties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.logging.Logger;

/**
 * Implementation of a strategy for parsing properties in the ".properties" format.
 */
public class PropertiesFilePropertiesParser implements PropertiesParser {
	
	private static final Logger LOGGER = Logger.getLogger(PropertiesFilePropertiesParser.class.getName());
	
    /**
     * @see PropertiesParser#parseProperties(String)
     */
	/*
    @Override
    public CrossOverProperties parseProperties(String toBeParsed) throws IOException {
        Properties properties = new Properties();
        if (toBeParsed != null) {
        	StringReader s = new StringReader(toBeParsed);
        	properties.load(new StringReader(toBeParsed));
        }
        return new CrossOverProperties(properties);
    }
	*/
    
	@Override
	public CustomProperties parseProperties(InputStream is) throws IOException {
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
	    BufferedReader br = new BufferedReader(new InputStreamReader(is));
	    String line="";
	    while((line=br.readLine()) != null) {
	    	String[] tokens=line.toLowerCase().split("=");
	    	if(tokens.length<2)
	    		LOGGER.severe("Error while parsing line: " + line + "\n in properties file. Missing key,value pair. ");
	    	else
	    		map.put(tokens[0], tokens[1]);
	    }
	    CustomProperties customProperties = new CustomProperties(map);
	    return customProperties;
	}
	
}
