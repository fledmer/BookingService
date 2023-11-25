package Application.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Slf4j
public class BaseResponseEntityExceptionHandler {
    protected ResponseEntity<Object> handleException(String logMessage, String uiMessage, HttpStatus httpStatus) {
        log.error(logMessage);

        return new ResponseEntity<>(uiMessage, httpStatus);
    }
}