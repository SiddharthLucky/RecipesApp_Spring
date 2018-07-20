package lucky.recipespringapp.com.recipespringapp.models;

import javax.persistence.*;

@Entity
public class Note
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne //No cascade as we dont want to delete the recipe if Note is deleted
    private Recipe recipe;

    @Lob //CLOB field Indicating to hibernate it is a large char object.
    private String recipeNotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
