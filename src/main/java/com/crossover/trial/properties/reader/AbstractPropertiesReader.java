package com.crossover.trial.properties.reader;

import com.crossover.trial.properties.format.FileFormat;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Abstract implementation of a {@link PropertiesReader}. Subclasses need to provide the {@link InputStream} from which
 * to read by implementing {@link #getInputStream()}.
 */
public abstract class AbstractPropertiesReader implements PropertiesReader {

    private final String path;

    protected AbstractPropertiesReader(String path) {
        this.path = path;
    }

    protected String getPath() {
        return path;
    }

    /**
     * @see PropertiesReader#getFormat()
     */
    @Override
    public FileFormat getFormat() {
        if (path.endsWith(".properties")) {
            return FileFormat.PROPERTIES_FILE;
        } else if (path.endsWith(".json")) {
            return FileFormat.JSON;
        } else {
            return FileFormat.UNKNOWN;
        }
    }

    /**
     * @see PropertiesReader#read()
     */
    @Override
    public String read() throws IOException {
    	
        return IOUtils.toString(getInputStream());
    }
    
    public InputStream readAsInputStream() throws IOException {
    	return getInputStream();
    }

    protected abstract InputStream getInputStream() throws IOException;
}
