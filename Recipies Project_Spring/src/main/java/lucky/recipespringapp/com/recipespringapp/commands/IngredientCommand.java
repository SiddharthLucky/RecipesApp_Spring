package lucky.recipespringapp.com.recipespringapp.commands;

import lombok.Data;
import lombok.NoArgsConstructor;
import lucky.recipespringapp.com.recipespringapp.models.UOM;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class IngredientCommand
{
    private Long id;
    private String description;
    private BigDecimal quantity;
    private UOM uom;
}
