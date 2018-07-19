package lucky.recipespringapp.com.recipespringapp.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    //This is mapped from the other side ie categories is the name of the variable defined in the Recipe class
    //When there is a Many to Many Mapping make sure one of the mappings has a @JoinTable and @JoinColumn and the other side has
    //the mapped by with the name of the variable in the other class, Ex: Look at Recipe and Category mapping.
    private Set<Recipe> recipes = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
