package semicolon.bime.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.bime.Exception.RegistrationException;
import semicolon.bime.dto.requests.UserRegisterRequest;
import semicolon.bime.dto.responses.UserRegisterResponse;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@SpringBootTest
@RequiredArgsConstructor
class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;
    private UserRegisterResponse response;
    private UserRegisterRequest request;

    @BeforeEach
    void setUp() throws RegistrationException {
       request = new UserRegisterRequest();
        response= new UserRegisterResponse();
        request.setUsername("loan");
        request.setEmail("opmail@gmail.com");
        request.setPassword("12364774");
        response = new UserRegisterResponse();
        response =userService.register(request);
    }
    @Test
    void testThatUserRegisterResponseIsNotEmpty() {
        assertThat(response).isNotNull();
    }

}