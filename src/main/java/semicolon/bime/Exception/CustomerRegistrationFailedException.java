package semicolon.bime.Exception;

public class CustomerRegistrationFailedException extends IllegalArgumentException{
    public CustomerRegistrationFailedException(String message){
        super(message);
    }
}
