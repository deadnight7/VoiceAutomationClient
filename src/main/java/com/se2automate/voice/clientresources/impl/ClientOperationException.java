package com.se2automate.voice.clientresources.impl;


import java.io.IOException;

/**
 * create by Gaurav Tiwari
 */

/**
 * Customized Exception thrown in voice automation client operations.
 */
public class ClientOperationException extends IOException {

    /**
     * Default constructor for ClientOperationException.
     */
    public ClientOperationException() {
        super();
    }

    /**
     * Constructor for ClientOperationException.
     *
     * @param message - error message
     */
    public ClientOperationException(final String message) {
        super(message);
    }

    /**
     * Constructor for ClientOperationException.
     *
     * @param message - error message
     * @param cause   - error cause
     */
    public ClientOperationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor for ClientOperationException.
     *
     * @param cause - error cause
     */
    public ClientOperationException(final Throwable cause) {
        super(cause);
    }
}
