package com.crossover.trial.properties.parser;

import com.crossover.trial.properties.model.CrossOverProperties;
import com.crossover.trial.properties.model.CustomProperties;

import java.io.IOException;
import java.io.InputStream;

/**
 * Parses properties from a string.
 */
public interface PropertiesParser {

    /**
     * Parses the properties from the specified string.
     *
     * @param toBeParsed the string to be parsed
     * @return the parsed {@link CrossOverProperties}
     * @throws IOException if an error occurred during the parsing
     */
    //CrossOverProperties parseProperties(String toBeParsed) throws IOException;
    
    CustomProperties parseProperties(InputStream is) throws IOException;
}
