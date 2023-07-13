package semicolon.bime.Exception;

public class EmailVerificationFailed extends IllegalArgumentException{
    public EmailVerificationFailed(String message) {
        super(message);
    }
}
