package semicolon.bime.services;


import semicolon.bime.dto.requests.UserLoginRequest;
import semicolon.bime.dto.responses.UserLoginResponse;
import semicolon.bime.exceptions.UserNotFoundException;

public interface UserService {
    UserLoginResponse login(UserLoginRequest request) throws UserNotFoundException;
}
