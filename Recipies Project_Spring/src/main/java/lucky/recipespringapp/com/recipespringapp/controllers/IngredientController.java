package lucky.recipespringapp.com.recipespringapp.controllers;

import lombok.extern.slf4j.Slf4j;
import lucky.recipespringapp.com.recipespringapp.services.IngredientService;
import lucky.recipespringapp.com.recipespringapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IngredientController
{
    private final RecipeService recipeService;
    private final IngredientService ingredientService;


    public IngredientController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId, Model model)
    {
        log.debug("Getting ingredients List: "+recipeId);

        //using command object to avoid lazy loading
        model.addAttribute("recipe", recipeService.getRecipeCommandById(Long.valueOf(recipeId)));

        return "recipe/ingredients/list";
    }

    @GetMapping
    @RequestMapping("recipe/{recipeid}/ingredients/{ingredientsId}/show")
    public String showRecipeIngredient(@PathVariable String recipeid, @PathVariable String ingredientsId, Model model)
    {
        log.debug("Recieved request.");
        model.addAttribute("ingredient", ingredientService.findRecipeIdAndIngredientId(Long.valueOf(recipeid), Long.valueOf(ingredientsId)));
        log.debug("Chekcing Value: "+ingredientService.findRecipeIdAndIngredientId(Long.valueOf(recipeid), Long.valueOf(ingredientsId)).toString());
        return "recipe/ingredients/show";
    }
}
