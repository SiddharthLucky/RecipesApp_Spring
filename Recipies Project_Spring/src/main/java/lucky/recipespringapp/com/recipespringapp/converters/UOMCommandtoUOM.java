package lucky.recipespringapp.com.recipespringapp.converters;

import lombok.Synchronized;
import lucky.recipespringapp.com.recipespringapp.commands.UOMCommand;
import lucky.recipespringapp.com.recipespringapp.models.UOM;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UOMCommandtoUOM implements Converter<UOMCommand, UOM>
{
    @Synchronized
    @Nullable
    @Override
    public UOM convert(UOMCommand source) {
        if (source == null) {
            return null;
        }

        final UOM uom = new UOM();
        uom.setId(source.getId());
        uom.setDescription(source.getDescription());
        return uom;
    }
}
