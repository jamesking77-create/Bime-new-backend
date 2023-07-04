package semicolon.bime.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequest {
    private String password;
    private String username;
}
