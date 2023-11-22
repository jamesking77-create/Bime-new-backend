package semicolon.bime.data.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document

public class RegisteredOrganisation {
    @Id
//what will status contain again
//how will we reference the foreign key I heard about @DBRef
    private String id;
    private LocalDateTime date;
}
