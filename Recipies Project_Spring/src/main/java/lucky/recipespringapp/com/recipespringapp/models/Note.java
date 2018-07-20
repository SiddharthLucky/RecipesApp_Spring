package lucky.recipespringapp.com.recipespringapp.models;

import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
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

}
