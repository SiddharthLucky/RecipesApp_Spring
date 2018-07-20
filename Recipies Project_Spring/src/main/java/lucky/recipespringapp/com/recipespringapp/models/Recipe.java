package lucky.recipespringapp.com.recipespringapp.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"categories"})
@Entity
public class Recipe
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private int cookTime;
    private int prepTime;
    private int servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    @Enumerated(EnumType.STRING)
    //Mostly use the string as if we use Ordinal the values are specified as 1, 2.....
    //Make sure u use ordinal only when u know that the number of enums are not going to change
    private Difficulty difficulty;

    @Lob //BLOB field large binary object
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private Note notes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    //Make sure the names of tables and columns are small in Mappedby and @JoinColumn name
    //The mapped by name is same as the variable name in recipe.
    private Set<Ingredient> ingredients = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    //If we only leave it at Many to Many - Hibernate creates 2 tables with mapped columns.
    //But we need One table with a mapping of recipe_id and category_id.
    private Set<Category> categories = new HashSet<>();

    public void setNotes(Note notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }
}
