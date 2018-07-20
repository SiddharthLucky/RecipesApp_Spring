package lucky.recipespringapp.com.recipespringapp.repositories;

import lucky.recipespringapp.com.recipespringapp.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>
{
    //Methods are being queried by using just the method names
    Optional<Category> findByDescription(String descriptuon);
}
