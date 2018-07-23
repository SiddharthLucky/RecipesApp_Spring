package lucky.recipespringapp.com.recipespringapp.converters;

import lucky.recipespringapp.com.recipespringapp.commands.NotesCommand;
import lucky.recipespringapp.com.recipespringapp.models.Note;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jt on 6/21/17.
 */
public class NotesToNotesCommandTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String RECIPE_NOTES = "Notes";
    NotestoNotesCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotestoNotesCommand();
    }

    @Test
    public void convert() throws Exception {
        //given
        Note notes = new Note();
        notes.setId(ID_VALUE);
        notes.setRecipeNotes(RECIPE_NOTES);

        //when
        NotesCommand notesCommand = converter.convert(notes);

        //then
        assertEquals(ID_VALUE, notesCommand.getId());
        assertEquals(RECIPE_NOTES, notesCommand.getRecipeNotes());
    }

    @Test
    public void testNull() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Note()));
    }
}