package semicolon.bime.dto.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    public String message;
    public boolean isSuccessful;
}
