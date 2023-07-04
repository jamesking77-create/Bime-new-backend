package semicolon.bime.data.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class User {
    @Id
    private int id;
    private String password;
    private String username;
    private String email;
}
