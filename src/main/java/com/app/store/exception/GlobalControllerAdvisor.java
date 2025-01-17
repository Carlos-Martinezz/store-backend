package com.app.store.exception;

import com.app.store.common.ErrorDetail;
import com.app.store.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

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
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Response<String>> handleTechnicalException(TechnicalException ex) {
        UUID uuid = UUID.randomUUID();
        log.info("Advisor traceId: {}", uuid);
        Response response = Response.<String>builder()
                .data(null)
                .errors(List.of(
                        ErrorDetail.builder()
                                .errorCode(500)
                                .message(ex.getMessage())
                                .traceId(uuid.toString())
                                .build()
                ))
                .build();
        return  ResponseEntity.internalServerError().body(response);
    }

}
