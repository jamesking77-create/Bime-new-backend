package semicolon.bime.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import semicolon.bime.data.models.User;

public interface UserRepository extends MongoRepository<User, String> {
}
