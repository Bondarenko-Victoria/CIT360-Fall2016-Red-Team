import org.junit.Ignore;
import org.junit.Test;
import java.lang.reflect.Field;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by gvh574 on 11/14/2016.
 */
public class PersonTest {

//    Asserts that two strings are equal.
    @Test
    public void checkEquals() throws Exception {
        Person Greg = new Person();
        Greg.setName("Greg");
        assertEquals("Greg", Greg.getName());
    }

//    Asserts that two arrays are equal
    @Test
    public void checkArrayEquals() throws Exception {
        int[] test = {5, 4, 3, 2, 1};
        int[] test2 = {5, 4, 3, 2, 1};
        assertArrayEquals(test, test2);
    }

//    Asserts that two objects are not the same
    @Test
    public void checkNotSame() throws Exception {
        Person Trump = new Person();
        Person Clinton = new Person();
        assertNotSame(Trump, Clinton);
    }

//    Asserts that two objects are the same
    @Test
    public void checkSame() throws Exception {
        Person Greg = new Person();
        Person Awesome = Greg;
        assertSame(Greg, Awesome);
    }

//    Asserts that something is something
    @Test
    public void checkThat() throws Exception {
        assertThat(0, is(0));
    }

//    Asserts that something is false
    @Test
    public void checkFalse() throws Exception {
        Person Tim = new Person();
        Tim.setDead(false);
        assertFalse(Tim.isDead());
    }

//    Asserts that something is not null
    @Test
    public void notNotNull() throws Exception {
        Person dude = new Person();
        dude.setAge(24);
        assertNotNull(dude);
    }

//    Asserts that something is null
    @Test
    public void checkNull() throws Exception {
        Person dudett = new Person();
        dudett = null;
        assertNull(dudett);
    }

//    Asserts that something is True
    @Test
    public void checkTrue() throws Exception {
        Person Ben = new Person();
        Ben.setDead(true);
        assertTrue(Ben.isDead());
    }

//    Asserts that something will fail
    @Test
    public void checkFail() {
        String name = "Greg";
        String anotherName = "Grog";
        if (name != anotherName) {
            fail("FAAAAIIILL!");
        }
    }

//    This will be ignored
    @Ignore
    public void checkIgnore() {
        String name = "Greg";
        String anotherName = "Grog";
        if (name != anotherName) {
            fail("FAAAAIIILL!");
        }
    }

//    private property example
    @Test
    public void checkPrivateProperty() throws Exception {
        // Create a person
        Person Greg = new Person();
        Greg.setName("Greg");
        // Set the name field to empty
        Field name = null;

        try {
            // Store the string from the Person name field to Field name field.
            name = Person.class.getDeclaredField("name");
        }
        catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        // Temporarily set the private variable to public.
        name.setAccessible(true);

        // Create a null string variable
        String aName = null;

        try {
            // Store the string value from the name field from the patient bean to a variable.
            aName = (String)name.get(Greg);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // Check if the name is null
        assertNotNull(aName);

        // Check if the name is equals to Isaiah
        assertEquals("Greg", aName);
    }





}