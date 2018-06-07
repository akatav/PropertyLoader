package com.crossover.trial.properties.parser;

import com.crossover.trial.properties.exception.UnsupportedFileFormatException;
import com.crossover.trial.properties.format.FileFormat;

/**
 * Creates {@link PropertiesParser}s according to various file formats.
 */
public class PropertiesParserFactory {

    /**
     * Gets the {@link PropertiesParser} for the specified {@link FileFormat}.
     *
     * @param format the file format
     * @return the {@code PropertiesParser}
     * @throws UnsupportedFileFormatException if there is no parser available for the specified format
     */
    public static PropertiesParser getParser(FileFormat format) throws UnsupportedFileFormatException {
        if (format == null) {
            throw new IllegalArgumentException("The format cannot be null");
        }
        switch (format) {
            case PROPERTIES_FILE:
                return new PropertiesFilePropertiesParser();
            case JSON:
                return new JsonPropertiesParser();
            default:
                throw new UnsupportedFileFormatException();
        }
    }
}
