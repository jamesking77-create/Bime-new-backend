package semicolon.bime.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import semicolon.bime.Exception.RegistrationException;
import semicolon.bime.Exception.UserNotFoundException;
import semicolon.bime.data.models.User;
import semicolon.bime.data.repositories.UserRepository;
import semicolon.bime.dto.requests.UserLoginRequest;
import semicolon.bime.dto.requests.UserRegisterRequest;
import semicolon.bime.dto.responses.LoginResponse;
import semicolon.bime.dto.responses.UserResponse;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import static semicolon.bime.Util.UserLoginMsg.*;
import static semicolon.bime.Util.UserRegistrationMsg.EMAIL_ADDRESS_ALREADY_EXIST_ERROR;
import static semicolon.bime.Util.UserRegistrationMsg.USER_REGISTER_SUCCESSFUL;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    @Override
    public UserResponse register(UserRegisterRequest request) throws RegistrationException, NoSuchAlgorithmException {
        boolean isRegistered = userRepository.findByEmail(request.getEmail()).isPresent();
        if (isRegistered) throw new RegistrationException(EMAIL_ADDRESS_ALREADY_EXIST_ERROR);
        User user = modelMapper.map(request,User.class);
        var userPassword= hashUserPassword(request.getPassword());
        user.setPassword(Arrays.toString(userPassword));
        userRepository.save(user);
        return buildUserResponse(user);
    }

    private byte[] hashUserPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(password.getBytes());
        return md.digest(password.getBytes(StandardCharsets.UTF_8));
    }

    private UserResponse buildUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setId(user.getId());
        userResponse.setMessage(USER_REGISTER_SUCCESSFUL);
        userResponse.setSuccessful(true);
        return userResponse;
    }

    @Override
    public LoginResponse login(UserLoginRequest request) throws UserNotFoundException, NoSuchAlgorithmException {
        User user = userRepository.findByUsername(request.getUsername())
            .orElseThrow(()->new UserNotFoundException(User_DO_NOT_EXIST_ERROR));
        var savedUserPassword = hashUserPassword(request.getPassword());
        if (!user.getPassword().equals(Arrays.toString(savedUserPassword))) throw new UserNotFoundException(USER_DETAILS_INVALID);
        return buildUserLoginResponse();
    }

    private LoginResponse buildUserLoginResponse() {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage(USER_LOGIN_SUCCESSFUL);
        loginResponse.setSuccessful(true);
        return loginResponse;
    }
}

