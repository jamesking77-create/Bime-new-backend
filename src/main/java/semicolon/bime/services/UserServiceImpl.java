package semicolon.bime.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semicolon.bime.data.models.User;
import semicolon.bime.data.repositories.UserRepository;
import semicolon.bime.dto.requests.UserLoginRequest;
import semicolon.bime.dto.responses.UserLoginResponse;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    User user = new User();

    @Override
    public UserLoginResponse login(UserLoginRequest request) {

    }
}
