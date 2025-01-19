package com.app.store.exception;

import com.app.store.common.ErrorDetail;
import com.app.store.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.UUID;

/**
 * Global controller advisor
 * Global exception control. Can handle custom or default exceptions
 */
@ControllerAdvice
@Slf4j
public class GlobalControllerAdvisor {

    /**
     * It is generated when a controlled error occurs or is likely to occur.
     * @return A server error and detailed error information.
     */
    @ExceptionHandler(TechnicalException.class)
    public ResponseEntity<Response<String>> handleTechnicalException(TechnicalException ex) {
        UUID uuid = UUID.randomUUID();
        log.info("Advisor traceId: {}", uuid);
        Response response = Response.<String>builder()
                .data(null)
                .errors(List.of(
                        ErrorDetail.builder()
                                .errorCode(ex.getErrorCode())
                                .message(ex.getMessage())
                                .traceId(uuid.toString())
                                .build()
                ))
                .build();
        return  ResponseEntity.status(ex.getErrorCode()).body(response);
    }

    /**
     *
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        UUID uuid = UUID.randomUUID();
        log.info("Advisor traceId: {}", uuid);
        Response response = Response.<String>builder()
                .data(null)
                .errors(
                        ex.getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .map(fieldError -> ErrorDetail.builder()
                                        .errorCode(400)
                                        .message(String.format("Field '%s': %s", fieldError.getField(), fieldError.getDefaultMessage()))
                                        .traceId(uuid.toString())
                                        .build()
                                )
                                .toList()
                )
                .build();
        return  ResponseEntity.badRequest().body(response);
    }


}
