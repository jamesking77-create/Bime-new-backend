package semicolon.bime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class BimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BimeApplication.class, args);
	}

}
