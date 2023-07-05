package semicolon.bime.utils;

import semicolon.bime.data.models.User;
import semicolon.bime.dto.requests.UserLoginRequest;

public class Mapper {
    public static User map( UserLoginRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        return user;
    }
}
