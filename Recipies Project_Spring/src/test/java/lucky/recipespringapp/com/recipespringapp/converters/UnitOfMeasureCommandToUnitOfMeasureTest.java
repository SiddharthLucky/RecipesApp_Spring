package lucky.recipespringapp.com.recipespringapp.converters;

import lucky.recipespringapp.com.recipespringapp.commands.UOMCommand;
import lucky.recipespringapp.com.recipespringapp.models.UOM;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = new Long(1L);

    UOMCommandtoUOM converter;

    @Before
    public void setUp() throws Exception {
        converter = new UOMCommandtoUOM();

    }

    @Test
    public void testNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UOMCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        UOMCommand command = new UOMCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        UOM uom = converter.convert(command);

        //then
        assertNotNull(uom);
        assertEquals(LONG_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());
    }
}