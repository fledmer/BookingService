package Application.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class AuthRequest {
    private String username;
    private String password;
}
