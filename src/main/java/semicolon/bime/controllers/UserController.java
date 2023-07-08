package semicolon.bime.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import semicolon.bime.Exception.RegistrationException;
import semicolon.bime.Exception.UserNotFoundException;
import semicolon.bime.dto.requests.UserLoginRequest;
import semicolon.bime.dto.requests.UserRegisterRequest;
import semicolon.bime.dto.responses.LoginResponse;
import semicolon.bime.dto.responses.UserResponse;
import semicolon.bime.services.UserService;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/bime/auth/")
public class UserController{
    private final UserService userService;
    @PostMapping("register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRegisterRequest registerRequest){
        try{
            return new ResponseEntity<>(userService.register(registerRequest), HttpStatus.CREATED);
        }catch (RegistrationException e){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@RequestBody UserLoginRequest loginRequest){
        try {
           return new ResponseEntity<>(userService.login(loginRequest), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
