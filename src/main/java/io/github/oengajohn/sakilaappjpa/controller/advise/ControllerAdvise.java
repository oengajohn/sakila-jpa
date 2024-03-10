package io.github.oengajohn.sakilaappjpa.controller.advise;


import io.github.oengajohn.sakilaappjpa.controller.dto.GenericResponse;
import io.github.oengajohn.sakilaappjpa.exception.AuthenticationException;
import io.github.oengajohn.sakilaappjpa.exception.UserNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@RestControllerAdvice
@Slf4j
public class ControllerAdvise {


    @ExceptionHandler(value = {UserNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public GenericResponse<?> resourceNotFoundException(UserNotFoundException ex) {
        return GenericResponse.error(ex.getMessage());
    }
    @ExceptionHandler(value = {MaxUploadSizeExceededException.class})
    @ResponseStatus(value = HttpStatus.PAYLOAD_TOO_LARGE)
    public GenericResponse<?> resourceNotFoundException(MaxUploadSizeExceededException ex) {
        return GenericResponse.error(ex.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public GenericResponse<?> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        String errorMessage = "Required parameter '" + ex.getParameterName() + "' is missing";
        return GenericResponse.error(errorMessage);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public  GenericResponse<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        String errorMessage = "Malformed request body or unsupported media type";
        return GenericResponse.error(errorMessage);

    }

    @ExceptionHandler(value = {NoResourceFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public GenericResponse<?> noResourceFoundException(NoResourceFoundException ex) {
        return GenericResponse.error(ex.getMessage());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public final GenericResponse<?> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
        // Customize the response entity as needed
        String message = "Integrity Constraint Violation: Cannot perform the given operation";
        log.error(ex.getMessage());
        return GenericResponse.error(message);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public final GenericResponse<?> handleEntityNotFoundException(EntityNotFoundException ex) {
        return GenericResponse.error(ex.getMessage());

    }
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public final GenericResponse<?> handleAuthenticationException(AuthenticationException ex) {
        return GenericResponse.error(ex.getMessage());

    }
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public GenericResponse<?> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            errors.put(violation.getPropertyPath().toString(), violation.getMessage());
        }
        return GenericResponse.error(errors);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public GenericResponse<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return GenericResponse.error(errors);
    }


}
