package extension.bime.data.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document
public class Organisation {
    @Id
    private String id;
    //    @Id
//    private String registeredOrganisationId;
    private String organisationName;
    private String organisationEmail;
    private String code; //I'm not sure whether int os String
    private int capacity; // should we use long
}
