package com.demo.stationapp.exception;

public class DataNotFoundException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;
    private final String message;   
    
    public DataNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}