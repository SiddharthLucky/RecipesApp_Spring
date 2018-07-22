package lucky.recipespringapp.com.recipespringapp.services;

import lombok.extern.slf4j.Slf4j;
import lucky.recipespringapp.com.recipespringapp.models.Recipe;
import lucky.recipespringapp.com.recipespringapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j //Logger from lombok
@Service
public class RecipeServiceImpl implements RecipeService
{
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        log.debug("I am inside the service layer");

        //Method calling is similar to referencing the DAO class to perform a SELECT * from DB operation.
        //Instead of directly calling the Repo from the controller we make a reference of the repo in the service file and call it from there.

        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe getRecipeById(Long l)
    {
        Optional<Recipe> recipeOptional = recipeRepository.findById(l);
        if(!recipeOptional.isPresent())
        {
            throw new RuntimeException("No Recipe found for the given ID");
        }
        return recipeOptional.get();
    }
}
