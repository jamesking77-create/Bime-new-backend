package semicolon.bime.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.bime.Exception.ActivationLinkFailedException;
import semicolon.bime.dto.requests.EmailNotificationRequest;
import semicolon.bime.dto.requests.Recipient;
import semicolon.bime.dto.requests.Sender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static semicolon.bime.Util.AppUtils.MAIL_TEMPLATE_LOCATION;

@SpringBootTest
public class TrialTest {
    @Autowired
    private MailService mailService;

    @Test
    public void testSendMail() {

        Sender sender = new Sender("bime inc.", "noreply@bime.com");

        Recipient recipient = new Recipient ("jamesasuelimen77@gmail.com");

        EmailNotificationRequest emailNotificationRequest = new EmailNotificationRequest();
        emailNotificationRequest.setEmailSender(sender);
        emailNotificationRequest.setRecipients(Set.of(recipient));

        emailNotificationRequest.setContent(getMailTemplate());
        emailNotificationRequest.setSubject("Welcome to bime");

        var response = mailService.sendMail(emailNotificationRequest);

        assertThat(response).isNotNull();

    }

    private String getMailTemplate(){
        try(BufferedReader reader =
                    new BufferedReader(new FileReader(MAIL_TEMPLATE_LOCATION))){
            return  reader.lines().collect(Collectors.joining());
        }catch (IOException exception){
            throw new ActivationLinkFailedException("Failed to send activation link");
        }
    }
}
