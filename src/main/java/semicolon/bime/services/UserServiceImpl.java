package semicolon.bime.services;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import semicolon.bime.Exception.RegistrationException;
import semicolon.bime.Util.UserLoginMsg;
import semicolon.bime.Util.UserRegistrationMsg;
import semicolon.bime.data.models.User;
import semicolon.bime.data.repositories.UserRepository;
import semicolon.bime.dto.requests.UserLoginRequest;
import semicolon.bime.dto.requests.UserRegisterRequest;
import semicolon.bime.Exception.UserNotFoundException;
import semicolon.bime.dto.responses.UserResponse;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserResponse register(UserRegisterRequest request) throws RegistrationException{
        boolean isRegistered = userRepository.findByEmail(request.getEmail()).isPresent();
        if (isRegistered) throw new RegistrationException(UserRegistrationMsg.ERROR_EmailAddress_Already_Exists);
        User user = modelMapper.map(request,User.class);
        userRepository.save(user);
        UserResponse userResponse = new UserResponse();
        userResponse.setData(UserRegistrationMsg.USER_REGISTER_SUCCESSFUL);
        userResponse.setSuccessful(true);
        return userResponse;
    }
    @Override
    public UserResponse login(UserLoginRequest request) throws UserNotFoundException{
        User user = userRepository.findByUsername(request.getUsername())
            .orElseThrow(()->new UserNotFoundException(UserLoginMsg.ERROR_User_DO_NOT_Exists));
        if (!user.getPassword().equals(request.getPassword())) throw new UserNotFoundException(UserLoginMsg.USER_DETAILS_INVALID);
        UserResponse userResponse = new UserResponse();
        userResponse.setData(UserLoginMsg.USER_LOGIN_SUCCESSFUL);
        userResponse.setSuccessful(true);
        return userResponse;

    }
}

