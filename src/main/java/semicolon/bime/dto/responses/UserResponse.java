package semicolon.bime.dto.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    public Object data;
    public boolean isSuccessful;
}
