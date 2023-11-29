package Application.exception;

import lombok.Getter;


@Getter
public class UserAlreadyExistsException extends RuntimeException {
    private String username;
    public UserAlreadyExistsException(String message, String username) {
        super(message);
        this.username = username;
    }
}
