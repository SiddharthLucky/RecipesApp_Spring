package lucky.recipespringapp.com.recipespringapp.services;

import lombok.extern.slf4j.Slf4j;
import lucky.recipespringapp.com.recipespringapp.commands.IngredientCommand;
import lucky.recipespringapp.com.recipespringapp.converters.IngredienttoIngredientCommand;
import lucky.recipespringapp.com.recipespringapp.models.Ingredient;
import lucky.recipespringapp.com.recipespringapp.models.Recipe;
import lucky.recipespringapp.com.recipespringapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService
{
    private final IngredienttoIngredientCommand ingredienttoIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredienttoIngredientCommand ingredienttoIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredienttoIngredientCommand = ingredienttoIngredientCommand;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public IngredientCommand findRecipeIdAndIngredientId(Long recipeid, Long ingredientsId) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(recipeid);

        if(!optionalRecipe.isPresent())
        {
            //Handle errors
            log.error("Recipe with the Id: "+recipeid+"is not found.");
        }

        Recipe recipe = optionalRecipe.get();

        //Changing optionalrecipe into Command type.
        Optional<IngredientCommand> optionalIngredientCommand = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientsId))
                .map(ingredient -> ingredienttoIngredientCommand.convert(ingredient)).findFirst();

        if(!optionalIngredientCommand.isPresent())
        {
            log.error("Ingredient not found with id: "+ingredientsId);
        }

        return optionalIngredientCommand.get();
    }
}
