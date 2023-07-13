package semicolon.bime.services;

import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import semicolon.bime.Exception.ActivationLinkFailedException;
import semicolon.bime.Exception.CustomerRegistrationFailedException;
import semicolon.bime.Exception.RegistrationException;
import semicolon.bime.Exception.UserNotFoundException;
import semicolon.bime.data.models.User;
import semicolon.bime.data.repositories.UserRepository;
import semicolon.bime.dto.requests.*;
import semicolon.bime.dto.responses.LoginResponse;
import semicolon.bime.dto.responses.UserResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import com.auth0.jwt.JWT;

import static semicolon.bime.Util.AppUtils.*;
import static semicolon.bime.Util.ExceptionUtils.USER_REGISTRATION_FAILED;
import static semicolon.bime.Util.UserLoginMsg.*;
import static semicolon.bime.Util.UserRegistrationMsg.EMAIL_ADDRESS_ALREADY_EXIST_ERROR;
import static semicolon.bime.Util.UserRegistrationMsg.USER_REGISTER_SUCCESSFUL;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final MailService mailService;


    @Override
    public UserResponse register(UserRegisterRequest request) throws RegistrationException, NoSuchAlgorithmException {
        boolean isRegistered = userRepository.findByEmail(request.getEmail()).isPresent();
        if (isRegistered) throw new RegistrationException(EMAIL_ADDRESS_ALREADY_EXIST_ERROR);
        User user = modelMapper.map(request,User.class);
        var userPassword= hashUserPassword(request.getPassword());
        user.setPassword(Arrays.toString(userPassword));
        userRepository.save(user);
        EmailNotificationRequest emailNotificationRequest = buildEmailRequest(user);
        var response = mailService.sendMail(emailNotificationRequest);
        log.info("response-->{}", response);
        boolean isSavedCustomer = user.getId() != null;
        if (!isSavedCustomer) throw new CustomerRegistrationFailedException(String.format(USER_REGISTRATION_FAILED, user.getEmail()));
        return buildUserResponse(user);
    }

    private EmailNotificationRequest buildEmailRequest(User user) {
        String token = JWT.create()
                .withIssuedAt(Instant.now())
                .withExpiresAt(Instant.now().plusSeconds(60L))
                .sign(Algorithm.HMAC512("secret".getBytes()));
        EmailNotificationRequest request = new EmailNotificationRequest();
        Sender sender = new Sender(APP_NAME, APP_EMAIL);
        Recipient recipient = new Recipient(user.getEmail());
        request.setEmailSender(sender);
        request.setRecipients(Set.of(recipient));
        request.setSubject(ACTIVATION_LINK_VALUE);
        String template = getEmailTemplate();
        request.setContent(String.format(template, ACTIVATE_ACCOUNT_URL+"?"+token));
        return request;
    }

    private String getEmailTemplate(){
        try(BufferedReader reader =
                    new BufferedReader(new FileReader(MAIL_TEMPLATE_LOCATION))){
            return  reader.lines().collect(Collectors.joining());
        }catch (IOException exception){
            throw new ActivationLinkFailedException("Failed to send activation link");
        }
    }





    private byte[] hashUserPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(password.getBytes());
        return md.digest(password.getBytes(StandardCharsets.UTF_8));
    }

    private UserResponse  buildUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setId(user.getId());
        userResponse.setMessage(USER_REGISTER_SUCCESSFUL);
        userResponse.setSuccessful(true);
        return userResponse;
    }

    @Override
    public LoginResponse login(UserLoginRequest request) throws UserNotFoundException, NoSuchAlgorithmException {
        User user = userRepository.findByUsername(request.getUsername())
            .orElseThrow(()->new UserNotFoundException(User_DO_NOT_EXIST_ERROR));
        var savedUserPassword = hashUserPassword(request.getPassword());
        if (!user.getPassword().equals(Arrays.toString(savedUserPassword))) throw new UserNotFoundException(USER_DETAILS_INVALID);
        return buildUserLoginResponse();
    }

    private LoginResponse buildUserLoginResponse() {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage(USER_LOGIN_SUCCESSFUL);
        loginResponse.setSuccessful(true);
        return loginResponse;
    }
}

