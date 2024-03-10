package io.github.oengajohn.sakilaappjpa.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class GenericResponse<T> {
    private boolean success;
    private String msg;
    @JsonInclude(NON_NULL)
    private T data;

    @JsonInclude(NON_NULL)
    private Number totalCount;

    public static <T> GenericResponse<T> success(T data) {
        return GenericResponse.<T>builder()
                .msg("SUCCESS!")
                .data(data)
                .success(true)
                .build();
    }
    public static <T> GenericResponse<T> error(T data) {
        return GenericResponse.<T>builder()
                .msg("ERROR!")
                .data(data)
                .success(false)
                .build();
    }

    public static <T> GenericResponse<T> error() {
        return GenericResponse.<T>builder()
                .msg("ERROR!")
                .success(false)
                .build();
    }
    public static <T> GenericResponse<T> success() {
        return GenericResponse.<T>builder()
                .msg("SUCCESS!")
                .success(true)
                .build();
    }
    public static <T> GenericResponse<T> success(T data, String message) {
        return GenericResponse.<T>builder()
                .msg(message)
                .data(data)
                .totalCount(null)
                .success(true)
                .build();
    }
    public static <T> GenericResponse<T> error(String message) {
        return GenericResponse.<T>builder()
                .msg(message)
                .totalCount(null)
                .success(false)
                .build();
    }
    public static <T> GenericResponse<T> success(T data, String message,Number total) {
        return GenericResponse.<T>builder()
                .msg(message)
                .data(data)
                .totalCount(total)
                .success(true)
                .build();
    }
    public static <T> GenericResponse<T> success(T data,Number total) {
        return GenericResponse.<T>builder()
                .msg("SUCCESS!")
                .data(data)
                .totalCount(total)
                .success(true)
                .build();
    }

}