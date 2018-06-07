package com.crossover.trial.properties.loader;

import com.crossover.trial.properties.exception.UnsupportedFileFormatException;
import com.crossover.trial.properties.exception.UnsupportedProtocolException;
import com.crossover.trial.properties.model.CustomProperties;
import com.crossover.trial.properties.parser.PropertiesParser;
import com.crossover.trial.properties.parser.PropertiesParserFactory;
import com.crossover.trial.properties.reader.PropertiesReader;
import com.crossover.trial.properties.reader.PropertiesReaderFactory;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Loads the properties from a list of files.
 */
public class PropertiesLoader {

    private static final Logger LOGGER = Logger.getLogger(PropertiesLoader.class.getName());

    //private CrossOverProperties properties = new CrossOverProperties();
    
    private CustomProperties orderedProperties = new CustomProperties();

    /**
     * Loads the properties from the specified files.
     *
     * @param paths the file paths
     */
    public void load(String... paths) {
        if (paths == null || paths.length == 0) {
            throw new IllegalArgumentException("At least one path must be specified");
        }
        for (String path : paths) {
            try {
                loadFile(path);
            } catch (IOException | UnsupportedFileFormatException | UnsupportedProtocolException e) {
                LOGGER.log(Level.SEVERE, "An exception occurred while loading " + path, e);
            }
        }
    }
/*
    private void loadFile(String path) throws UnsupportedProtocolException, IOException,
            UnsupportedFileFormatException {
        PropertiesReader reader = PropertiesReaderFactory.getReader(path);
        PropertiesParser parser = PropertiesParserFactory.getParser(reader.getFormat());
        properties.putAll(parser.parseProperties(reader.read()));
    }
  */
    
    private void loadFile(String path) throws UnsupportedProtocolException,IOException, 
    			UnsupportedFileFormatException {
    	PropertiesReader reader = PropertiesReaderFactory.getReader(path);
    	PropertiesParser parser = PropertiesParserFactory.getParser(reader.getFormat());
    	orderedProperties.putAll(parser.parseProperties(reader.readAsInputStream()));
    }

    /**
     * Gets the loaded properties.
     *
     * @return the properties
     */
    public CustomProperties getProperties() {
        return orderedProperties;
    }
}
