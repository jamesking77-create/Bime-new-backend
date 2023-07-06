package semicolon.bime.services;

import semicolon.bime.Exception.RegistrationException;
import semicolon.bime.dto.requests.UserLoginRequest;
import semicolon.bime.dto.requests.UserRegisterRequest;
import semicolon.bime.Exception.UserNotFoundException;
import semicolon.bime.dto.responses.UserResponse;

public interface UserService {
   UserResponse register(UserRegisterRequest request) throws RegistrationException;
    UserResponse login(UserLoginRequest request) throws UserNotFoundException;
}
