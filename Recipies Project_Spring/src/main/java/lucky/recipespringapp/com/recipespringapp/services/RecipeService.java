package lucky.recipespringapp.com.recipespringapp.services;

import lucky.recipespringapp.com.recipespringapp.commands.RecipeCommand;
import lucky.recipespringapp.com.recipespringapp.models.Recipe;

import java.util.Set;

public interface RecipeService
{
    Set<Recipe> getRecipes();
    Recipe getRecipeById(Long l);
    RecipeCommand getRecipeCommandById(Long l);
    RecipeCommand saverRecipeCommand(RecipeCommand command);
    void deleteById(Long idToDelete);
}
