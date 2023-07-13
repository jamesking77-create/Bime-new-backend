package semicolon.bime.services;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.bime.data.repositories.UserRepository;
import semicolon.bime.dto.requests.UserLoginRequest;
import semicolon.bime.dto.requests.UserRegisterRequest;
import semicolon.bime.dto.responses.LoginResponse;
import semicolon.bime.dto.responses.UserResponse;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static semicolon.bime.Util.UserLoginMsg.USER_LOGIN_SUCCESSFUL;
import static semicolon.bime.Util.UserRegistrationMsg.USER_REGISTER_SUCCESSFUL;


@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserRepository userRepository;

    private UserRegisterRequest registerRequest;
    private UserLoginRequest  loginRequest;
    private UserResponse userResponse;

    private LoginResponse loginResponse;


    @BeforeEach
    void setUp() {
       registerRequest = new UserRegisterRequest
               ("jamesking","ezeikefelix@gmail.com","089999");
       loginRequest = new UserLoginRequest
               ("jamesking","089999");
    }


    @Test
    void testThatUserRegisterResponseIsNotEmpty() throws NoSuchAlgorithmException {
        userRepository.deleteAll();
        userResponse = userService.register(registerRequest);
        assertEquals(USER_REGISTER_SUCCESSFUL,userResponse.getMessage());
    }
    @Test
    void testThat_registeredUser_Can_Login() throws NoSuchAlgorithmException {
       loginResponse = userService.login(loginRequest);
        assertEquals(USER_LOGIN_SUCCESSFUL, loginResponse.getMessage());
    }


}