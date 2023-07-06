package semicolon.bime.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.bime.Util.UserLoginMsg;
import semicolon.bime.Util.UserRegistrationMsg;
import semicolon.bime.dto.requests.UserLoginRequest;
import semicolon.bime.dto.requests.UserRegisterRequest;
import semicolon.bime.dto.responses.UserResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;
    private UserRegisterRequest registerRequest;
    private UserLoginRequest  loginRequest;
    private UserResponse userResponse;


    @BeforeEach
    void setUp() {
       registerRequest = new UserRegisterRequest
               ("12364774","opebi","opi09l@gmail.com");
       loginRequest = new UserLoginRequest
               ("12364774","opebi");
    }


    @Test
    void testThatUserRegisterResponseIsNotEmpty() {
        userResponse = userService.register(registerRequest);
        assertEquals(UserRegistrationMsg.USER_REGISTER_SUCCESSFUL,userResponse.getData());
    }
    @Test
    void testThat_registeredUser_Can_Login(){
       userResponse = userService.login(loginRequest);
        assertEquals(UserLoginMsg.USER_LOGIN_SUCCESSFUL,userResponse.getData());
    }

}