package semicolon.bime.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Data
public class EmailDetails {
    private String recipient;
    private String msgBody;
    private String subject;
}
