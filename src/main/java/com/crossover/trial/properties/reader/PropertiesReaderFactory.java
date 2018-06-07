package com.crossover.trial.properties.reader;

import com.crossover.trial.properties.exception.UnsupportedProtocolException;
import org.apache.commons.lang3.StringUtils;

/**
 * Creates {@link PropertiesReader}s for different sources (classpath or {@link java.net.URL}s).
 */
public class PropertiesReaderFactory {

    private static final String CLASSPATH_PROTOCOL = "classpath:";

    /**
     * According to <a href="http://www.faqs.org/rfcs/rfc3986.html">RFC 3986</a> file URIs can start with only one
     * slash (e.g. "file:/C:/test.txt"). This is the current implementation from {@link java.io.File#toURI}. For more
     * information, also see <a href="http://bugs.java.com/view_bug.do?bug_id=6351751">this bug</a>.
     */
    private static final String FILE_PROTOCOL = "file:/";

    private static final String HTTP_PROTOCOL = "http://";

    /**
     * Creates a {@link PropertiesReader} that can be used to read the file specified by the given path.
     *
     * @param path the file path
     * @return the {@link PropertiesReader}  that can be used for reading the specified file
     * @throws UnsupportedProtocolException if the protocol corresponding to the given path is not supported
     */
    public static PropertiesReader getReader(String path) throws UnsupportedProtocolException {
        if (StringUtils.isEmpty(path)) {
            throw new IllegalArgumentException("The path cannot be null or empty");
        }
        if (path.startsWith(CLASSPATH_PROTOCOL)) {
            return new ClassPathPropertiesReader(path);
        }
        if (path.startsWith(FILE_PROTOCOL) || path.startsWith(HTTP_PROTOCOL)) {
            return new URLPropertiesReader(path);
        }
        throw new UnsupportedProtocolException(
                String.format("%s  does not use one of the supported protocols: " + "%s, %s or %s", path,
                        CLASSPATH_PROTOCOL, FILE_PROTOCOL, HTTP_PROTOCOL));
    }
}
