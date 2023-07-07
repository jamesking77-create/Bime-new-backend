package semicolon.bime.services;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import semicolon.bime.Exception.RegistrationException;
import semicolon.bime.Util.UserLoginMsg;
import semicolon.bime.data.models.User;
import semicolon.bime.data.repositories.UserRepository;
import semicolon.bime.dto.requests.UserLoginRequest;
import semicolon.bime.dto.requests.UserRegisterRequest;
import semicolon.bime.Exception.UserNotFoundException;
import semicolon.bime.dto.responses.LoginResponse;
import semicolon.bime.dto.responses.UserResponse;

import static semicolon.bime.Util.UserLoginMsg.*;
import static semicolon.bime.Util.UserRegistrationMsg.*;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserResponse register(UserRegisterRequest request) throws RegistrationException{
        boolean isRegistered = userRepository.findByEmail(request.getEmail()).isPresent();
        if (isRegistered) throw new RegistrationException(EMAIL_ADDRESS_ALREADY_EXIST_ERROR);
        User user = modelMapper.map(request,User.class);
        userRepository.save(user);
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setId(user.getId());
        userResponse.setMessage(USER_REGISTER_SUCCESSFUL);
        userResponse.setSuccessful(true);
        return userResponse;
    }
    @Override
    public LoginResponse login(UserLoginRequest request) throws UserNotFoundException{
        User user = userRepository.findByUsername(request.getUsername())
            .orElseThrow(()->new UserNotFoundException(User_DO_NOT_EXIST_ERROR));
        if (!user.getPassword().equals(request.getPassword())) throw new UserNotFoundException(USER_DETAILS_INVALID);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage(USER_LOGIN_SUCCESSFUL);
        loginResponse.setSuccessful(true);
        return loginResponse;
    }
}

