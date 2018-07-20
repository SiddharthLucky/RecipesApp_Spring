package lucky.recipespringapp.com.recipespringapp.repositories;

import lucky.recipespringapp.com.recipespringapp.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
