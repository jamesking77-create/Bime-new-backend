package semicolon.bime.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.metamodel.mapping.ModelPart;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semicolon.bime.Exception.RegistrationException;
import semicolon.bime.Util.UserRegistrationErrorMsg;
import semicolon.bime.data.models.User;
import semicolon.bime.data.repositories.UserRepository;
import semicolon.bime.dto.requests.UserLoginRequest;
import semicolon.bime.dto.requests.UserRegisterRequest;
import semicolon.bime.dto.responses.UserLoginResponse;
import semicolon.bime.dto.responses.UserRegisterResponse;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;



    @Override
    public UserLoginResponse login(UserLoginRequest request) {


        return null;
    }

    @Override
    public UserRegisterResponse register(UserRegisterRequest request) throws RegistrationException {
        User user1  = modelMapper.map(request, User.class);
        boolean isRegistered = userRepository.findByUsername(user1.getUsername()).isPresent();
        if (isRegistered) throw new RegistrationException(UserRegistrationErrorMsg.ERROR_Username_Already_Exists);
        User savedUser = userRepository.save(user1);
        boolean isSaved = savedUser.getId() == null;
        if (isSaved) throw new RegistrationException(UserRegistrationErrorMsg.ERROR_User_Not_SAVED);
        return responseBuilder(savedUser);
    }


    private UserRegisterResponse responseBuilder(User user) {
        return UserRegisterResponse.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }
}
