package lucky.recipespringapp.com.recipespringapp.converters;

import lombok.Synchronized;
import lucky.recipespringapp.com.recipespringapp.commands.RecipeCommand;
import lucky.recipespringapp.com.recipespringapp.models.Category;
import lucky.recipespringapp.com.recipespringapp.models.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipetoRecipeCommand implements Converter<Recipe, RecipeCommand>
{
    private final CategorytoCategoryCommand categoryConveter;
    private final IngredienttoIngredientCommand ingredientConverter;
    private final NotestoNotesCommand notesConverter;

    public RecipetoRecipeCommand(CategorytoCategoryCommand categoryConveter, IngredienttoIngredientCommand ingredientConverter,
                                 NotestoNotesCommand notesConverter) {
        this.categoryConveter = categoryConveter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        if (source == null) {
            return null;
        }

        final RecipeCommand command = new RecipeCommand();
        command.setId(source.getId());
        command.setCookTime(source.getCookTime());
        command.setPrepTime(source.getPrepTime());
        command.setDescription(source.getDescription());
        command.setDifficulty(source.getDifficulty());
        command.setDirections(source.getDirections());
        command.setServings(source.getServings());
        command.setSource(source.getSource());
        command.setUrl(source.getUrl());
        command.setNotes(notesConverter.convert(source.getNotes()));

        if (source.getCategories() != null && source.getCategories().size() > 0){
            source.getCategories()
                    .forEach((Category category) -> command.getCategories().add(categoryConveter.convert(category)));
        }

        if (source.getIngredients() != null && source.getIngredients().size() > 0){
            source.getIngredients()
                    .forEach(ingredient -> command.getIngredients().add(ingredientConverter.convert(ingredient)));
        }

        return command;
    }
}
