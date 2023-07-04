package semicolon.bime.services;


import semicolon.bime.dto.requests.UserLoginRequest;
import semicolon.bime.dto.responses.UserLoginResponse;

public interface UserService {
    UserLoginResponse login(UserLoginRequest request);
}
