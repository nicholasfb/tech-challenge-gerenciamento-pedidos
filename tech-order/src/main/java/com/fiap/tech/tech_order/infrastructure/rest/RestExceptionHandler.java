package com.fiap.tech.tech_order.infrastructure.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.tech.tech_order.core.exception.BusinessException;
import com.fiap.tech.tech_order.core.exception.NotFoundException;
import jakarta.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handle(final NotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handle(final BusinessException e) {
        return ResponseEntity.unprocessableEntity().body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handle(final ValidationException e) {
        return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Object> handle(final HttpRequestMethodNotSupportedException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handle(final IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler()
    public ResponseEntity<Object> handle(final Exception exception) {
        try {
            this.logger.error("Error captured: ");
            this.logger.error(this.objectMapper.writeValueAsString(exception.getCause()));
        } catch (final JsonProcessingException e) {
            this.logger.error("Error converting exception to json");
        }

        return ResponseEntity.internalServerError()
                .body(new ErrorResponse("Internal Server Error"));
    }

}
