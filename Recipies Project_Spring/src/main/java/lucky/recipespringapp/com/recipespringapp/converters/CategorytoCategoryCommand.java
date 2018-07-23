package lucky.recipespringapp.com.recipespringapp.converters;

import lombok.Synchronized;
import lucky.recipespringapp.com.recipespringapp.commands.CategoryCommand;
import lucky.recipespringapp.com.recipespringapp.models.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

//This can be used to type convert the domain object to the Command object
@Component
public class CategorytoCategoryCommand implements Converter<Category, CategoryCommand>
{
    @Synchronized
    //Since spring does not guarentee thread safety.
    @Nullable
    @Override
    public CategoryCommand convert(Category source)
    {
        if(source == null) {
            return null;
        }
        final CategoryCommand categoryCommand = new CategoryCommand();

        categoryCommand.setId(source.getId());
        categoryCommand.setDescription(source.getDescription());
        return categoryCommand;
    }
}
