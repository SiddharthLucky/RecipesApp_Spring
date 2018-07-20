package lucky.recipespringapp.com.recipespringapp.repositories;

import lucky.recipespringapp.com.recipespringapp.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long>
{

}
