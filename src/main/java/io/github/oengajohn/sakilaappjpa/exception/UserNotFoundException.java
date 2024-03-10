package io.github.oengajohn.sakilaappjpa.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String userNotFoundMessage) {
        super(userNotFoundMessage);
    }
}
