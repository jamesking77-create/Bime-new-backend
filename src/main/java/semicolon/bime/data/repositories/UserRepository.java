package semicolon.bime.data.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import semicolon.bime.data.models.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
  
}
