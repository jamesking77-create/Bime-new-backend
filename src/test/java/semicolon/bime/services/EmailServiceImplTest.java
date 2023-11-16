package semicolon.bime.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.bime.data.models.EmailDetails;

@SpringBootTest
class EmailServiceImplTest {
    @Autowired
    private EmailServiceImpl emailService;
    private EmailDetails emailDetails = new EmailDetails();

    @BeforeEach
    void setUp(){
       emailDetails.setRecipient("effiongtimothy1@gmail.com");
       emailDetails.setSubject("Testing");
       emailDetails.setMsgBody("checking to see stuff");
    }

    @Test
    public void testThatUserCanReceiveMail(){
        emailService.sendMail(emailDetails);
    }
}