package semicolon.bime.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import semicolon.bime.Exception.EmailVerificationFailed;
import semicolon.bime.data.models.EmailDetails;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;
//    @Value("${spring.mail.username}")
    private String sender = "ezeikefelix999@gmail.com";

    @Override
    public String sendMail(EmailDetails details) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setSubject(details.getSubject());
            mailMessage.setText(details.getMsgBody());
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }
        catch (EmailVerificationFailed e) {
            return "Error while Sending Mail";
        }
    }
    }
