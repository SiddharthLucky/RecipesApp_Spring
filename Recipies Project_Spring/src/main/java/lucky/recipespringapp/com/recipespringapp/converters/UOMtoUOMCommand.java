package lucky.recipespringapp.com.recipespringapp.converters;

import lombok.Synchronized;
import lucky.recipespringapp.com.recipespringapp.commands.UOMCommand;
import lucky.recipespringapp.com.recipespringapp.models.UOM;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UOMtoUOMCommand implements Converter<UOM, UOMCommand>
{
    @Synchronized
    @Nullable
    @Override
    public UOMCommand convert(UOM unitOfMeasure) {

        if (unitOfMeasure != null) {
            final UOMCommand uomc = new UOMCommand();
            uomc.setId(unitOfMeasure.getId());
            uomc.setDescription(unitOfMeasure.getDescription());
            return uomc;
        }
        return null;
    }
}
