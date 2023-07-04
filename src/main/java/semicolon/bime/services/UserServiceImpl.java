package semicolon.bime.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semicolon.bime.data.repositories.UserRepository;
import semicolon.bime.dto.requests.UserLoginRequest;
import semicolon.bime.dto.responses.UserLoginResponse;
import semicolon.bime.exceptions.UserNotFoundException;
import semicolon.bime.utils.Mapper;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserLoginResponse login(UserLoginRequest request) throws UserNotFoundException {
        boolean userHasNotRegistered = !request.getUsername().equals(userRepository.findUserByUsername(request.getUsername()).getUsername())
                || !request.getPassword().equals(userRepository.findUserByUsername(request.getUsername()).getPassword());
        if (userHasNotRegistered) throw new UserNotFoundException("invalid information");
        return userRepository.findUserByUsername(Mapper.map(request).getUsername() + "login successful");
    }
}
