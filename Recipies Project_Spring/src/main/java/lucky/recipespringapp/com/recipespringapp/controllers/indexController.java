package lucky.recipespringapp.com.recipespringapp.controllers;

import lucky.recipespringapp.com.recipespringapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController
{
    private RecipeService recipeService;

    public indexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getindex(Model model)
    {
        model.addAttribute("AllRecipes", recipeService.getRecipes());
        return "index";
    }
}
