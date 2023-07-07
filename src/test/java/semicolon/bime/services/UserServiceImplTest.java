package semicolon.bime.services;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.bime.Util.UserLoginMsg;
import semicolon.bime.Util.UserRegistrationMsg;
import semicolon.bime.data.repositories.UserRepository;
import semicolon.bime.dto.requests.UserLoginRequest;
import semicolon.bime.dto.requests.UserRegisterRequest;
import semicolon.bime.dto.responses.LoginResponse;
import semicolon.bime.dto.responses.UserResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static semicolon.bime.Util.UserLoginMsg.USER_LOGIN_SUCCESSFUL;
import static semicolon.bime.Util.UserRegistrationMsg.USER_REGISTER_SUCCESSFUL;


@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;
<<<<<<< HEAD
    @Autowired
    private UserRepository userRepository;
=======

    @Autowired
    private  UserRepository userRepository;
>>>>>>> a494c6acb8baa0ff8285df7bdd3c78c917423f38
    private UserRegisterRequest registerRequest;
    private UserLoginRequest  loginRequest;
    private UserResponse userResponse;

    private LoginResponse loginResponse;


    @BeforeEach
    void setUp() {
       registerRequest = new UserRegisterRequest
               ("jamesking","opi09l@gmail.com","089999");
       loginRequest = new UserLoginRequest
               ("jamesking","089999");
    }


    @Test
    void testThatUserRegisterResponseIsNotEmpty() {
        userRepository.deleteAll();
        userResponse = userService.register(registerRequest);
        assertEquals(USER_REGISTER_SUCCESSFUL,userResponse.getMessage());
    }
    @Test
    void testThat_registeredUser_Can_Login(){
       loginResponse = userService.login(loginRequest);
        assertEquals(USER_LOGIN_SUCCESSFUL, loginResponse.getMessage());
    }


}