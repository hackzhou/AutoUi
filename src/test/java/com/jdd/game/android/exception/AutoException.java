package com.jdd.game.android.exception;

public class AutoException extends RuntimeException {
	private static final long serialVersionUID = -114523890183047004L;

	public AutoException(){}
	
	public AutoException(String message){
		super(message);
	}
	
	public AutoException(String message, Throwable cause) {
        super(message, cause);
    }
	
	public AutoException(Throwable cause) {
        super(cause);
    }
}
