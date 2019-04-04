package com.cit.rt.exception;

public class ResourceNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(Object resourId) {
        super(resourId != null ? resourId.toString() : null);
    }

    public ResourceNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(final String message) {
        super(message);
    }

    public ResourceNotFoundException(final Throwable cause) {
        super(cause);
    }
}
