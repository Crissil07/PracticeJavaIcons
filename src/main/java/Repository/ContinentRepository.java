package Repository;

import Entity.ContinentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinentRepository extends JpaRepository<ContinentEntity,Long> {
}
