package com.springboot.excption;

public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("No User");
    }
}
