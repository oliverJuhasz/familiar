package familiar.dao;

import familiar.entities.CombatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CombatRepository extends JpaRepository<CombatEntity, Long> {

}
