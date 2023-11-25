package Application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CarNotBookedException extends RuntimeException {
    public CarNotBookedException(String message) {
        super(message);
    }
}
