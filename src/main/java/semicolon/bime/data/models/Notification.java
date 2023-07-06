package semicolon.bime.data.models;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document
public class Notification {
    @Id
    private String id;
    private String message;
    private LocalDateTime timeOfMessage;
}
