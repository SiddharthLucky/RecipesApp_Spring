package lucky.recipespringapp.com.recipespringapp.controllers;

import lombok.extern.slf4j.Slf4j;
import lucky.recipespringapp.com.recipespringapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{urlId}") //Making a variable to hold the ID
    public String getRecipeById(@PathVariable String urlId, Model model)
    {
        model.addAttribute("RecipeById", recipeService.getRecipeById(new Long(urlId)));
        return "recipe/show";
    }
}
