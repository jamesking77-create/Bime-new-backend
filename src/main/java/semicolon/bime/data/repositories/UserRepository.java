package semicolon.bime.data.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import semicolon.bime.data.models.User;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

  
}
