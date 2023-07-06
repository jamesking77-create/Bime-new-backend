package semicolon.bime.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import semicolon.bime.Exception.RegistrationException;
import semicolon.bime.Exception.UserNotFoundException;
import semicolon.bime.Util.UserRegistrationMsg;
import semicolon.bime.dto.requests.UserLoginRequest;
import semicolon.bime.dto.requests.UserRegisterRequest;
import semicolon.bime.dto.responses.UserResponse;
import semicolon.bime.services.UserService;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRegisterRequest registerRequest){
        try{
            return ResponseEntity.ok(userService.register(registerRequest));
        }catch (RegistrationException e){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserLoginRequest loginRequest){
        try {
           return ResponseEntity.ok(userService.login(loginRequest));
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
