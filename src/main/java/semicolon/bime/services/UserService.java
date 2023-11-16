package semicolon.bime.services;

import semicolon.bime.Exception.RegistrationException;
import semicolon.bime.dto.requests.UserLoginRequest;
import semicolon.bime.dto.requests.UserRegisterRequest;
import semicolon.bime.Exception.UserNotFoundException;
import semicolon.bime.dto.responses.LoginResponse;
import semicolon.bime.dto.responses.UserResponse;

import java.security.NoSuchAlgorithmException;

public interface UserService {
   UserResponse register(UserRegisterRequest request) throws RegistrationException, NoSuchAlgorithmException;
    LoginResponse login(UserLoginRequest request) throws UserNotFoundException, NoSuchAlgorithmException;
}
