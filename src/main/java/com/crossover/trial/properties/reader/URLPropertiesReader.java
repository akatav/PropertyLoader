package com.crossover.trial.properties.reader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Implementation of a strategy for reading files from {@link java.net.URL}s.
 */
public class URLPropertiesReader extends AbstractPropertiesReader {

    /**
     * @see AbstractPropertiesReader#AbstractPropertiesReader(String)
     */
    public URLPropertiesReader(String path) {
        super(path);
    }

    @Override
    protected InputStream getInputStream() throws IOException {
        return new URL(getPath()).openStream();
    }
}
