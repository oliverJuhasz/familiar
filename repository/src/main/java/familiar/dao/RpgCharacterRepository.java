package familiar.dao;

import familiar.entities.character.RpgCharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RpgCharacterRepository extends JpaRepository<RpgCharacterEntity, Long> {

}
