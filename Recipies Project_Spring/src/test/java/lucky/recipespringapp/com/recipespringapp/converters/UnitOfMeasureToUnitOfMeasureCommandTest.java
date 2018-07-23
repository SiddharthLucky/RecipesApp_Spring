package lucky.recipespringapp.com.recipespringapp.converters;

import lucky.recipespringapp.com.recipespringapp.commands.UOMCommand;
import lucky.recipespringapp.com.recipespringapp.models.UOM;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jt on 6/21/17.
 */
public class UnitOfMeasureToUnitOfMeasureCommandTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = new Long(1L);

    UOMtoUOMCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new UOMtoUOMCommand();
    }

    @Test
    public void testNullObjectConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObj() throws Exception {
        assertNotNull(converter.convert(new UOM()));
    }

    @Test
    public void convert() throws Exception {
        //given
        UOM uom = new UOM();
        uom.setId(LONG_VALUE);
        uom.setDescription(DESCRIPTION);
        //when
        UOMCommand uomc = converter.convert(uom);

        //then
        assertEquals(LONG_VALUE, uomc.getId());
        assertEquals(DESCRIPTION, uomc.getDescription());
    }

}