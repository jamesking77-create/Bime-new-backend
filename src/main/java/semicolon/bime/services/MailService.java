package semicolon.bime.services;

import semicolon.bime.dto.requests.EmailNotificationRequest;
import semicolon.bime.dto.responses.SendMailResponse;

public interface MailService {
    SendMailResponse sendMail(EmailNotificationRequest emailNotificationRequest);
}

