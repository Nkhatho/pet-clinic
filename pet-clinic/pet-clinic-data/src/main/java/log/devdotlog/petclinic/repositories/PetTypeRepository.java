package log.devdotlog.petclinic.repositories;

import log.devdotlog.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
