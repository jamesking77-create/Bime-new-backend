//package semicolon.bime;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import semicolon.bime.Exception.RegistrationException;
//import semicolon.bime.dto.requests.UserRegisterRequest;
//import semicolon.bime.dto.responses.UserRegisterResponse;
//import semicolon.bime.services.UserServiceImpl;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@SpringBootTest
//class BimeApplicationTests {
//
//	@Autowired
//	private UserServiceImpl userService;
//	private UserRegisterResponse response;
//
//	@BeforeEach
//	void setUp() throws RegistrationException {
//		UserRegisterRequest request = new UserRegisterRequest();
//		response= new UserRegisterResponse();
//		request.setUsername("Username");
//		request.setEmail("Email@gmail.com");
//		request.setPassword("Password");
//		response = new UserRegisterResponse();
//		response =userService.register(request);
//	}
//	@Test
//	void testThatUserRegisterResponseIsNotEmpty() {
//		assertThat(response).isNotNull();
//	}
//
//}
