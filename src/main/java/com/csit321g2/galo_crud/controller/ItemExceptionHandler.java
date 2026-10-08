package com.csit321g2.galo_crud.controller;

import com.csit321g2.galo_crud.service.NameErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.ErrorResponse;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestControllerAdvice(assignableTypes = ItemController.class)
public class ItemExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ItemExceptionHandler.class);

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<NameErrorResponse> handleStatusException(ResponseStatusException ex) {
        return error(ex.getStatusCode(), ex.getReason());
    }

    @ExceptionHandler({HttpMessageNotReadableException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<NameErrorResponse> handleBadRequest(Exception ex) {
        return error(HttpStatus.BAD_REQUEST, "Invalid request body or parameter.");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<NameErrorResponse> handleException(Exception ex) {
        if (ex instanceof ErrorResponse response) {
            return error(response.getStatusCode(), response.getBody().getDetail());
        }
        log.error("Unexpected item API error", ex);
        return error(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred.");
    }

    private ResponseEntity<NameErrorResponse> error(HttpStatusCode status, String message) {
        NameErrorResponse error = new NameErrorResponse();
        error.setStatus(status.value());
        error.setMessage(message);
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, status);
    }
}
