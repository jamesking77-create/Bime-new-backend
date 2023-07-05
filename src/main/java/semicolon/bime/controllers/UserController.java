package semicolon.bime.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import semicolon.bime.dto.requests.UserLoginRequest;
import semicolon.bime.dto.responses.UserLoginResponse;
import semicolon.bime.exceptions.BimeException;
import semicolon.bime.exceptions.UserNotFoundException;
import semicolon.bime.services.UserService;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public ResponseEntity<?> login(@RequestBody UserLoginRequest request){
        try {
           return new ResponseEntity<>(userService.login(request), HttpStatus.OK);
        } catch (BimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
