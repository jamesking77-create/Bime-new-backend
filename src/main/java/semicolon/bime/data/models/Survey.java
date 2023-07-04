package semicolon.bime.data.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
public class Survey {
    @Id
    private int id;
    private List<Question> questions;
}
