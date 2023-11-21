package extension.bime.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import extension.bime.data.models.Individual;

import java.util.Optional;

public interface IndividualRepository extends MongoRepository<Individual, String> {

    Optional<Individual> findByEmail(String email);

    Optional<Individual> findByName(String name);
}
