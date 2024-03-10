package io.github.oengajohn.sakilaappjpa.exception;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String authenticationFailedMessage) {
        super(authenticationFailedMessage);
    }
}
