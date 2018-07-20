package lucky.recipespringapp.com.recipespringapp.repositories;

import lucky.recipespringapp.com.recipespringapp.models.UOM;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UOMRepository extends CrudRepository<UOM, Long> {
}
