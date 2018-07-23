package lucky.recipespringapp.com.recipespringapp.converters;

import lombok.Synchronized;
import lucky.recipespringapp.com.recipespringapp.commands.NotesCommand;
import lucky.recipespringapp.com.recipespringapp.models.Note;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandtoNotes implements Converter<NotesCommand, Note>
{
    @Synchronized
    @Nullable
    @Override
    public Note convert(NotesCommand source) {
        if(source == null) {
            return null;
        }

        final Note notes = new Note();
        notes.setId(source.getId());
        notes.setRecipeNotes(source.getRecipeNotes());
        return notes;
    }
}
