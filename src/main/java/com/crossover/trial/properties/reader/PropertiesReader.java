package com.crossover.trial.properties.reader;

import com.crossover.trial.properties.format.FileFormat;

import java.io.IOException;
import java.io.InputStream;

/**
 * Reads the contents of property files.
 */
public interface PropertiesReader {

    /**
     * The file format.
     *
     * @return the {@link FileFormat}
     */
    FileFormat getFormat();

    /**
     * Reads the file contents.
     *
     * @return the file contents
     * @throws IOException if the file could not be read
     */
    String read() throws IOException;
    
    InputStream readAsInputStream() throws IOException;
}
