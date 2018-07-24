package lucky.recipespringapp.com.recipespringapp.controllers;

import lombok.extern.slf4j.Slf4j;
import lucky.recipespringapp.com.recipespringapp.commands.IngredientCommand;
import lucky.recipespringapp.com.recipespringapp.services.IngredientService;
import lucky.recipespringapp.com.recipespringapp.services.RecipeService;
import lucky.recipespringapp.com.recipespringapp.services.UOMService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class IngredientController
{
    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UOMService uomService;


    public IngredientController(RecipeService recipeService, IngredientService ingredientService, UOMService uomService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.uomService = uomService;
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId, Model model)
    {
        log.debug("Getting ingredients List: "+recipeId);

        //using command object to avoid lazy loading
        model.addAttribute("recipe", recipeService.getRecipeCommandById(Long.valueOf(recipeId)));

        return "recipe/ingredients/ingredientsList";
    }

    @GetMapping
    @RequestMapping("recipe/{recipeid}/ingredients/{ingredientsId}/show")
    public String showRecipeIngredient(@PathVariable String recipeid, @PathVariable String ingredientsId, Model model)
    {
        log.debug("Recieved request.");
        model.addAttribute("ingredient", ingredientService.findRecipeIdAndIngredientId(Long.valueOf(recipeid), Long.valueOf(ingredientsId)));
        log.debug("Chekcing Value: "+ingredientService.findRecipeIdAndIngredientId(Long.valueOf(recipeid), Long.valueOf(ingredientsId)).toString());
        return "recipe/ingredients/ingredientsShow";
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredients/{ingredientsId}/update")
    public String updateRecipeIngredient(@PathVariable String recipeId, @PathVariable String ingredientsId, Model model)
    {
        log.debug("recieved the request. - Update RecipeIngredient");
        model.addAttribute("ingredient", ingredientService.findRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(ingredientsId)));

        //Populating the list of UOM objects from the DB
        model.addAttribute("uomList", uomService.listAllUOM());

        return "recipe/ingredients/ingredientsForm";
    }

    @PostMapping("recipe/{recipeId}/ingredients")
    public String saveOrUpdate(@ModelAttribute IngredientCommand command){
        IngredientCommand savedCommand = ingredientService.saveIngredient(command);

        log.debug("saved recipe id:" + savedCommand.getId());
        log.debug("saved ingredient id:" + savedCommand.getId());

        return "redirect:/recipe/" + savedCommand.getId() + "/ingredients/" + savedCommand.getId() + "/ingredientsShow";
    }
}
