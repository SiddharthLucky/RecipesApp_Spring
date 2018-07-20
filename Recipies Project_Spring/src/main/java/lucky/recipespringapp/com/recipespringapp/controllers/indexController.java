package lucky.recipespringapp.com.recipespringapp.controllers;

import lucky.recipespringapp.com.recipespringapp.models.Category;
import lucky.recipespringapp.com.recipespringapp.models.UOM;
import lucky.recipespringapp.com.recipespringapp.repositories.CategoryRepository;
import lucky.recipespringapp.com.recipespringapp.repositories.UOMRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class indexController
{
    private CategoryRepository categoryRepository;
    private UOMRepository uomRepository;

    public indexController(CategoryRepository categoryRepository, UOMRepository uomRepository)
    {
        this.categoryRepository = categoryRepository;
        this.uomRepository = uomRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getindex()
    {
        Optional<Category> optionalCategory = categoryRepository.findByDescription("American");
        Optional<UOM> optionalUom = uomRepository.findByDescription("Teaspoon");

        System.out.println("The Category Id is: " + optionalCategory.get().getId());
        System.out.println("The UOM id is: " + optionalUom.get().getId());

        return "index";
    }
}
