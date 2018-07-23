package lucky.recipespringapp.com.recipespringapp.converters;

import lombok.Synchronized;
import lucky.recipespringapp.com.recipespringapp.commands.NotesCommand;
import lucky.recipespringapp.com.recipespringapp.models.Note;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotestoNotesCommand implements Converter<Note, NotesCommand>
{
    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Note source) {
        if (source == null) {
            return null;
        }

        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(source.getId());
        notesCommand.setRecipeNotes(source.getRecipeNotes());
        return notesCommand;
    }
}
