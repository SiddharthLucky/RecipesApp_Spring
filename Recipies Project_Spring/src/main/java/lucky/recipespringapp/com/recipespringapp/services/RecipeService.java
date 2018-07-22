package lucky.recipespringapp.com.recipespringapp.services;

import lucky.recipespringapp.com.recipespringapp.models.Recipe;

import java.util.Set;

public interface RecipeService
{
    Set<Recipe> getRecipes();
    Recipe getRecipeById(Long l);
}
