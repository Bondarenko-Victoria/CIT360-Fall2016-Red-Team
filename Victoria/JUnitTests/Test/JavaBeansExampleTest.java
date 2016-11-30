import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by Victoria on 10.11.2016.
 */

public class JavaBeansExampleTest extends JavaBeansExample {
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {

    }

    @BeforeClass
    public static void beforeClass() {
    }

    @AfterClass
    public static void afterClass() {
    }

    @Test
    public void testGetCatName() throws Exception {
        // Creates cat
        JavaBeansExample cat = new JavaBeansExample("Tiger", 5, 6);
        // Compares. Passed because it is true.
        assertEquals("Tiger", cat.getCatName());
    }

    @Test
    public void testSetCatName() throws Exception {
        // Creates cat
        JavaBeansExample cat = new JavaBeansExample();
        // Compares. Passed because it is true.
        cat.setCatName("Tiger");
        assertEquals("Tiger", cat.getCatName());
    }

    @Test
    public void testGetCatAge() throws Exception {
        // Creates cat
        JavaBeansExample cat = new JavaBeansExample("Tiger", 5, 6);
        // Compares. Passed because it is true.
        assertEquals(5, cat.getCatAge());
    }

    @Test
    public void testSetCatAge() throws Exception {
        // Creates cat
        JavaBeansExample cat = new JavaBeansExample();
        // Compares. Passed because it is true.
        cat.setCatAge(5);
        assertEquals(5, cat.getCatAge());
    }

    @Test
    public void testGetCatWeight() throws Exception {
        // Creates cat
        JavaBeansExample cat = new JavaBeansExample("Tiger", 5, 6);
        // Compares. Passed because it is true.
        assertEquals(6, cat.getCatWeight());
    }

    @Test
    public void testSetCatWeight() throws Exception {
        // Creates cat
        JavaBeansExample cat = new JavaBeansExample();
        // Passed because it is true.
        cat.setCatWeight(6);
        assertEquals(6, cat.getCatWeight());
    }

    /*
    // This will fail on purpose because two strings will not match
    @Test
    public void testException() {
        String name = "Tiger";
        String anotherName = "Tyger";
        if (name != anotherName) {
            // Return false if the name field is null.
            fail("Exception not thrown!");
        }
    }
    */
}