package semicolon.bime.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import semicolon.bime.data.models.User;
import semicolon.bime.dto.responses.UserLoginResponse;

public interface UserRepository extends MongoRepository<User, String> {
    UserLoginResponse findUserByUsername(String username);
}
