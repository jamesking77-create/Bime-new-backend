package semicolon.bime.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static semicolon.bime.Util.AppUtils.MAIL_API_KEY;

@Getter
@AllArgsConstructor
public class MailConfig {

    private final String mailApiKey;
}


