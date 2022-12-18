package com.hubberspot.exception_handling;

public class DatabaseReadException extends Throwable {
    public DatabaseReadException(String message)
    {
        super(message);
    }
}
