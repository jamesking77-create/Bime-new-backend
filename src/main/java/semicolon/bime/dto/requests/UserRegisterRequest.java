package semicolon.bime.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {
    private String password;
    private String username;
    private String email;
}
