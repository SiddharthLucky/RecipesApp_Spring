package lucky.recipespringapp.com.recipespringapp.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    //Initialize the properties
    Category category;

    //Use this method to make it more organized
    @Before
    public void setUp()
    {
        //new category object before each test method
        category = new Category();
    }

    @Test
    public void getId()
    {
        long idval = 4L;

        category.setId(idval);
        assertEquals(java.util.Optional.ofNullable(idval), java.util.Optional.ofNullable(category.getId()));
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}