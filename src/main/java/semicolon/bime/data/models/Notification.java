package semicolon.bime.data.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
public class Notification {
    @Id
    private Long id;
    private String message;
    private LocalDateTime timeOfMessage;
}
