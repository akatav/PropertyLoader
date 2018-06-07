package com.crossover.trial.properties.exception;

/**
 * Indicates that the specified path is not corresponding to one of the protocols supported by the application.
 */
public class UnsupportedProtocolException extends Exception {

    /**
     * Constructs a new {@link UnsupportedProtocolException} with the given message.
     *
     * @param message the exception message
     */
    public UnsupportedProtocolException(String message) {
        super(message);
    }
}
