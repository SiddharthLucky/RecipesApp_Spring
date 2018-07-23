package lucky.recipespringapp.com.recipespringapp.converters;

import lucky.recipespringapp.com.recipespringapp.commands.IngredientCommand;
import lucky.recipespringapp.com.recipespringapp.models.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandtoIngredient implements Converter<IngredientCommand, Ingredient>
{
    public final UOMCommandtoUOM uomConverter;

    public IngredientCommandtoIngredient(UOMCommandtoUOM uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source)
    {
        if(source == null)
        {
            return null;
        }
        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setDescription(source.getDescription());
        ingredient.setQuantity(source.getQuantity());
        ingredient.setUom(uomConverter.convert(source.getUom()));
        return ingredient;
    }
}
