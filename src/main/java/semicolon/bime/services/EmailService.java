package semicolon.bime.services;

import semicolon.bime.data.models.EmailDetails;

public interface EmailService {
    String sendMail(EmailDetails details);
}
