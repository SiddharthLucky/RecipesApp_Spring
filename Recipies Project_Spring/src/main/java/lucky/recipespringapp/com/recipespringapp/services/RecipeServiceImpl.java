package lucky.recipespringapp.com.recipespringapp.services;

import lombok.extern.slf4j.Slf4j;
import lucky.recipespringapp.com.recipespringapp.commands.RecipeCommand;
import lucky.recipespringapp.com.recipespringapp.converters.RecipeCommandtoRecipe;
import lucky.recipespringapp.com.recipespringapp.converters.RecipetoRecipeCommand;
import lucky.recipespringapp.com.recipespringapp.models.Recipe;
import lucky.recipespringapp.com.recipespringapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j //Logger from lombok
@Service
public class RecipeServiceImpl implements RecipeService
{
    private final RecipeRepository recipeRepository;
    private final RecipeCommandtoRecipe recipeCommandtoRecipe;
    private final RecipetoRecipeCommand recipetoRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandtoRecipe recipeCommandtoRecipe, RecipetoRecipeCommand recipetoRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandtoRecipe = recipeCommandtoRecipe;
        this.recipetoRecipeCommand = recipetoRecipeCommand;
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

    @Override
    @Transactional
    public RecipeCommand saverRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandtoRecipe.convert(command);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved RecipeId: "+savedRecipe.getId());
        return recipetoRecipeCommand.convert(savedRecipe);
    }
}
