package semicolon.bime.dto.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    public String username;
    public String  email;
    public String id;
    public String message;
    public boolean isSuccessful;


}
