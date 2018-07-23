package lucky.recipespringapp.com.recipespringapp.commands;

import lombok.Data;
import lombok.NoArgsConstructor;
import lucky.recipespringapp.com.recipespringapp.models.Difficulty;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class RecipeCommand
{
    private Long id;
    private String description;
    private int cookTime;
    private int prepTime;
    private int servings;
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;
    private NotesCommand notes;
    private Set<CategoryCommand> categories = new HashSet<>();
    private Set<IngredientCommand> ingredients = new HashSet<>();
}
