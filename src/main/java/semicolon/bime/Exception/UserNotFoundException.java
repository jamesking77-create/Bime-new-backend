package semicolon.bime.Exception;

//import semicolon.bime.exceptions.BimeException;

public class UserNotFoundException extends IllegalArgumentException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
