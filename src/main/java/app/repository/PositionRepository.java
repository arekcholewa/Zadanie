package app.repository;

import app.domain.Position;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PositionRepository extends CrudRepository<Position, Long> {

    Optional<Position> findByName(String name);

}
