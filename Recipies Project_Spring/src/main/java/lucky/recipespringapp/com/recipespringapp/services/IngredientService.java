package lucky.recipespringapp.com.recipespringapp.services;

import lucky.recipespringapp.com.recipespringapp.commands.IngredientCommand;

public interface IngredientService
{
    IngredientCommand findRecipeIdAndIngredientId(Long recipeid, Long ingredientsId);
}
