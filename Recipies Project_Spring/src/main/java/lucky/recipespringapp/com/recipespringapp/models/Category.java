package lucky.recipespringapp.com.recipespringapp.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"recipes"}) //ignore the name of the variable as it can cause a circular reference in a bi directional mapping.
@Entity
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    //This is mapped from the other side ie categories is the name of the variable defined in the Recipe class
    //When there is a Many to Many Mapping make sure one of the mappings has a @JoinTable and @JoinColumn and the other side has
    //the mapped by with the name of the variable in the other class, Ex: Look at Recipe and Category mapping.
    private Set<Recipe> recipes = new HashSet<>();
}
