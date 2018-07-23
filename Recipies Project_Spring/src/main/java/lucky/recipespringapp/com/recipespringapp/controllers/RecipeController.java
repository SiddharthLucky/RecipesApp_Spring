package lucky.recipespringapp.com.recipespringapp.controllers;

import lombok.extern.slf4j.Slf4j;
import lucky.recipespringapp.com.recipespringapp.commands.RecipeCommand;
import lucky.recipespringapp.com.recipespringapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/{urlId}/show") //Making a variable to hold the ID
    public String getRecipeById(@PathVariable String urlId, Model model)
    {
        model.addAttribute("RecipeById", recipeService.getRecipeById(new Long(urlId)));
        return "recipe/show";
    }

    //Adding a new Recipe to the DB
    @RequestMapping("/recipe/new")
    public String newRecipe(Model model)
    {
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeForm";
    }

    //Updating the information in the DB.
    @RequestMapping("recipe/{urlid}/update")
    public String updateRecipe(@PathVariable String urlid, Model model)
    {
        model.addAttribute("recipe", recipeService.getRecipeCommandById(Long.valueOf(urlid)));
        return "recipe/recipeForm";
    }

    //@RequestMapping(name = "recipe", method = RequestMethod.POST)
    //This is an older method, you can use @PostMapping and pass the object name directly as if u use name there is a bug and wont submit properly.
    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command)
            //Using @ModelAttribute means that we are telling spring to bind the form post parameters to the RecipeCommand object
    {
        RecipeCommand savedCommand = recipeService.saverRecipeCommand(command);

        return "redirect:/recipe/"+savedCommand.getId()+"/show/";

    }
}
