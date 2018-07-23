package lucky.recipespringapp.com.recipespringapp.commands;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class IngredientCommand
{
    private Long id;
    private String description;
    private BigDecimal quantity;
    private UOMCommand uom;
}
