package com.crossover.trial.properties.reader;

import java.io.IOException;
import java.io.InputStream;

/**
 * Implementation of a strategy for reading files from the classpath.
 */
public class ClassPathPropertiesReader extends AbstractPropertiesReader {

    private static final String CLASSPATH_PREFIX = "classpath:";

    /**
     * @see AbstractPropertiesReader#AbstractPropertiesReader(String)
     */
    public ClassPathPropertiesReader(String path) {
        super(path);
    }

    @Override
    protected InputStream getInputStream() throws IOException {
        String filePath = getPath().substring(CLASSPATH_PREFIX.length());
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new IOException("Could not open file: " + filePath);
        }
        return inputStream;
    }
}
