package com.app.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiErrorResponse(
    int status,
    String error,
    String message,
    String path,
    List<ValidationError> errors,
    LocalDateTime timestamp
) {
    public record ValidationError(String field, String message) {}

    public static ApiErrorResponse of(int status, String error, String message, String path) {
        return new ApiErrorResponse(status, error, message, path, null, LocalDateTime.now());
    }

    public static ApiErrorResponse of(int status, String error, String message, String path, List<ValidationError> errors) {
        return new ApiErrorResponse(status, error, message, path, errors, LocalDateTime.now());
    }
}