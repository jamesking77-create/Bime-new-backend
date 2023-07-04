package semicolon.bime.dto.responses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class UserLoginResponse {
    private String password;
    private String username;
}
