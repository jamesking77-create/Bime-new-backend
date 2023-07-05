package semicolon.bime.services;


import org.springframework.beans.factory.annotation.Autowired;
import semicolon.bime.Exception.RegistrationException;
import semicolon.bime.dto.requests.UserLoginRequest;
import semicolon.bime.dto.requests.UserRegisterRequest;
import semicolon.bime.dto.responses.UserLoginResponse;
import semicolon.bime.dto.responses.UserRegisterResponse;
import semicolon.bime.exceptions.UserNotFoundException;

public interface UserService {
    UserRegisterResponse register(UserRegisterRequest request) throws RegistrationException
    UserLoginResponse login(UserLoginRequest request) throws UserNotFoundException;
}
