package lucky.recipespringapp.com.recipespringapp.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String description;
    private BigDecimal quantity;

    @ManyToOne
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UOM uom;

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UOM uom, Recipe recipe) {
        this.description = description;
        this.quantity = amount;
        this.uom = uom;
        this.recipe = recipe;
    }

}
