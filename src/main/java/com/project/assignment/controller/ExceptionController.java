package com.project.assignment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.UnknownHostException;

@ControllerAdvice
@Slf4j
public class ExceptionController {

    // 400
    @ExceptionHandler({
            DataIntegrityViolationException.class
    })
    public ResponseEntity handleDataIntegrityViolationException(final DataIntegrityViolationException ex) {
        log.warn("error", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The name or IP already exists");
    }

    // 401
    @ExceptionHandler({ NullPointerException.class })
    public ResponseEntity handleNullPointerException(final NullPointerException ex) {
        log.warn("error", ex);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Can't find the host");
    }

    @ExceptionHandler({ InvalidDataAccessApiUsageException.class })
    public ResponseEntity handleInvalidDataAccessApiUsageException(final InvalidDataAccessApiUsageException ex) {
        log.warn("error", ex);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Can't find the host");
    }

    // 402
    @ExceptionHandler({ UnknownHostException.class })
    public ResponseEntity handleUnknownHostException(final UnknownHostException ex) {
        log.warn("error", ex);
        return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body("Invalidate ip");
    }

    //406
    @ExceptionHandler({ InternalError.class })
    public ResponseEntity handleInternalError(final InternalError ex) {
        log.warn("error", ex);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Number has been exceeded");
    }

    // 500
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(final Exception ex) {
        log.info(ex.getClass().getName());
        log.error("error", ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
