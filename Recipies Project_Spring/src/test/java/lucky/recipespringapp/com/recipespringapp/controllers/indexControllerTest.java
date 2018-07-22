package lucky.recipespringapp.com.recipespringapp.controllers;

import lucky.recipespringapp.com.recipespringapp.models.Recipe;
import lucky.recipespringapp.com.recipespringapp.services.RecipeService;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class indexControllerTest {

    @Mock
    RecipeService recipeService;
    indexController controller;
    Model model;

    @Test
    public void getindex()
    {
        //Given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());

        Recipe recipe = new Recipe();
        recipe.setId(1L);

        recipes.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        //When
        String viewName = controller.getindex(model);

        //then
        assertEquals("", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("AllRecipes"), argumentCaptor.capture());
        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }
}