package log.devdotlog.petclinic.repositories;

import log.devdotlog.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
