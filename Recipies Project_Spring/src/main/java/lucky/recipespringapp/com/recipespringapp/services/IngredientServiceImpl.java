package lucky.recipespringapp.com.recipespringapp.services;

import lombok.extern.slf4j.Slf4j;
import lucky.recipespringapp.com.recipespringapp.commands.IngredientCommand;
import lucky.recipespringapp.com.recipespringapp.converters.IngredientCommandtoIngredient;
import lucky.recipespringapp.com.recipespringapp.converters.IngredienttoIngredientCommand;
import lucky.recipespringapp.com.recipespringapp.models.Ingredient;
import lucky.recipespringapp.com.recipespringapp.models.Recipe;
import lucky.recipespringapp.com.recipespringapp.repositories.RecipeRepository;
import lucky.recipespringapp.com.recipespringapp.repositories.UOMRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService
{
    private final IngredienttoIngredientCommand ingredienttoIngredientCommand;
    private final RecipeRepository recipeRepository;
    private final UOMRepository uomRepository;
    private final IngredientCommandtoIngredient ingredientCommandtoIngredient;

    public IngredientServiceImpl(IngredienttoIngredientCommand ingredienttoIngredientCommand, RecipeRepository recipeRepository, UOMRepository uomRepository, IngredientCommandtoIngredient ingredientCommandtoIngredient) {
        this.ingredienttoIngredientCommand = ingredienttoIngredientCommand;
        this.recipeRepository = recipeRepository;
        this.uomRepository = uomRepository;
        this.ingredientCommandtoIngredient = ingredientCommandtoIngredient;
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

    @Override
    @Transactional
    public IngredientCommand saveIngredient(IngredientCommand command)
    {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(command.getRecipeId());

        if(!optionalRecipe.isPresent())
        {
            log.error("No recipe with this id is found."+command.getRecipeId());
            return new IngredientCommand();
            //Throw an error if not found.
        }
        else
        {
            Recipe recipe = optionalRecipe.get();

            Optional<Ingredient> ingredientOptional = recipe
                    .getIngredients()
                    .stream()
                    .filter(ingredient -> ingredient.getId().equals(command.getId()))
                    .findFirst();

            if(ingredientOptional.isPresent())
            {
                Ingredient ingredientFound = ingredientOptional.get();
                ingredientFound.setDescription(command.getDescription());
                ingredientFound.setQuantity(command.getQuantity());
                ingredientFound.setUom(uomRepository
                        .findById(command.getUom().getId())
                        .orElseThrow(() -> new RuntimeException("UOM not found")));
            }
            else
            {
                /*
                * You can use this code to do the same function as below.
                * Set<Ingredient> ingredients = new HashSet<>();
                  ingredients.add(ingredientCommandtoIngredient.convert(command));
                  recipe.setIngredients(ingredients);*/

                recipe.addIngredient(ingredientCommandtoIngredient.convert(command));
            }
            Recipe savedRecipe = recipeRepository.save(recipe);

            log.debug("returning form Ingredient Service Implementation.");
            //to do check for fail
            return ingredienttoIngredientCommand.convert(savedRecipe.getIngredients().stream()
            .filter(recipeIngredients -> recipeIngredients.getId().equals(command.getId()))
            .findFirst()
            .get());
        }
    }
}
