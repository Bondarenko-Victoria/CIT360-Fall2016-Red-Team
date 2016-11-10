/**
 * Created by Brian on 11/05/2016.
 */

package BrianSandbox.JUTests;
import BrianSandbox.PatientBean;
import org.junit.*;
import java.lang.reflect.Field;
import static org.junit.Assert.*;

public class PatientBeanTest {

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

    /*  Method: getName() */
    @Test
    public void testGetName() throws Exception {
        // Create a patient bean
        PatientBean aPatient = new PatientBean("Isaiah", "111-11-1111",
                "1978", "37", "123-456-7890" );
        // Set the name field to empty
        Field nameField = null;

        try {
            // Store the string from the name field to the field nameField.
            nameField = PatientBean.class.getDeclaredField("name");
        }
        catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        // Temporarily set the private variable to public.
        nameField.setAccessible(true);

        // Create a null string variable
        String aName = null;

        try {
            // Store the string value from the name field from the patient bean to a variable.
            aName = (String)nameField.get(aPatient);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // Check if the name is null
        // Passed because it is not null.
        assertNotNull(aName);

        // Check if the name is equals to Isaiah
        // Passed because they are equal.
        assertEquals("Isaiah", aName);
    }


    /* Method: setName(String name) */
    @Test
    public void testSetName() throws Exception {
        // Create a patient bean
        PatientBean aPatient = new PatientBean("Isaiah", "111-11-1111",
                "1978", "37", "123-456-7890" );

        // Create a name field and store the SSN string value into the name field.
        Field nameField = PatientBean.class.getDeclaredField("name");
        // Set the name private variable to public access temporarily.
        nameField.setAccessible(true);
        // Store the string value from the name in a temp variable.
        String aName = (String)nameField.get(aPatient);
        // Check if the name value is false if the name is not equal
        // to the same name with alternating cases.
        // Passed because it is false.
        assertFalse(aName == "IsAiaH");
    }

    /* Method: getSSN()*/
    @Test
    public void testGetSSN() throws Exception {
        // Create a patient bean
        PatientBean aPatient = new PatientBean("Isaiah", "111-11-1111",
                "1978", "37", "123-456-7890" );

        // Create a SSN field and store the SSN string value into the SSN field.
        Field SSNField = PatientBean.class.getDeclaredField("SSN");
        // Set the SSN private variable to public access temporarily.
        SSNField.setAccessible(true);
        // Store the string value from the SSN in a temp variable.
        String aSSN = (String)SSNField.get(aPatient);
        // Check if the SSN value is true if the SSN is not equal to a SSN without dashes.
        // Passed because it is true.
        assertTrue(aSSN != "111 11 1111");
    }

    /* Method: setSSN(String SSN)*/
    @Test
    public void testSetSSN() throws Exception {
        // Create a patient bean
        PatientBean aPatient = new PatientBean("Isaiah", "111-11-1111",
                "1978", "37", "123-456-7890" );

        // Create a SSN field and store the SSN string value into the SSN field.
        Field SSNField = PatientBean.class.getDeclaredField("SSN");
        // Set the SSN private variable to public access temporarily.
        SSNField.setAccessible(true);
        // Store the string value from the SSN in a temp variable.
        String aSSN = (String)SSNField.get(aPatient);
        // Check if the SSN value is not the same if the SSN is not equal to a SSN without spaces.
        // Passed because they are not the same.
        assertNotSame(aSSN, "111111111");
    }

    /* Method: getBirthYear()*/
    @Test
    public void testGetBirthYear() throws Exception {
        // Create a patient bean
        PatientBean aPatient = new PatientBean("Isaiah", "111-11-1111",
                null, "37", "123-456-7890" );
        // Create a BirthYear field and store the BirthYear string value into the BirthYear field.
        Field birthYearField = PatientBean.class.getDeclaredField("birthYear");
        // Set the BirthYear private variable to public access temporarily.
        birthYearField.setAccessible(true);
        // Store the string value from the BirthYear in a temp variable.
        String aBirthYear = (String)birthYearField.get(aPatient);
        // Check if the birth year is null
        // Passed because birth year is null
        assertNull(aBirthYear);
    }

    /* Method: setBirthYear(String birthYear) */
    @Test
    public void testSetBirthYear() throws Exception {
        // Create a patient bean
        PatientBean aPatient = new PatientBean("Isaiah", "111-11-1111",
                "1978", "37", "123-456-7890" );

        // Create a BirthYear field and store the BirthYear string value into the BirthYear field.
        Field birthYearField = PatientBean.class.getDeclaredField("birthYear");
        // Set the BirthYear private variable to public access temporarily.
        birthYearField.setAccessible(true);
        // Store the string value from the BirthYear in a temp variable.
        String aBirthYear = (String)birthYearField.get(aPatient);
        // Parse the birthYear into an integer
        Integer birthYearNum = Integer.parseInt(aBirthYear);
        // Return true if the birth year is less than a greater year.
        assertTrue(birthYearNum < 1980);
    }

    /* Method: getAge()*/
    @Test
    public void testGetAge() throws Exception {
        // Create a patient bean
        PatientBean aPatient = new PatientBean("Isaiah", "111-11-1111",
                "1978", "37", "123-456-7890" );
        // Create a age field and store the age string value into the age field.
        Field ageField = PatientBean.class.getDeclaredField("age");
        // Set the age private variable to public access temporarily.
        ageField.setAccessible(true);
        // Store the string value from the age in a temp variable.
        String anAge = (String)ageField.get(aPatient);
        // Parse the age into an integer
        Integer ageNum = Integer.parseInt(anAge);
        // Return true if the age is greater than 0 and less than 100 years.
        assertTrue(ageNum > 0 & ageNum < 100);
    }

    /* Method: setAge(String age) */
    @Test
    public void testSetAge() throws Exception {
        // Create a patient bean
        PatientBean aPatient = new PatientBean("Isaiah", "111-11-1111",
                "1978", "37", "123-456-7890" );
        // Create a age field and store the age string value into the age field.
        Field ageField = PatientBean.class.getDeclaredField("age");
        // Set the age private variable to public access temporarily.
        ageField.setAccessible(true);
        // Store the string value from the age in a temp variable.
        String anAge = (String)ageField.get(aPatient);
        // Parse the age into an integer
        Integer ageNum = Integer.parseInt(anAge);
        // Return false if the age is than 0 and greater than 100 years.
        assertFalse(ageNum < 0 & ageNum > 100);
    }

    /* Method: getPhone()*/
    @Test
    public void testGetPhone() throws Exception {
        // Create a patient bean
        PatientBean aPatient = new PatientBean("Isaiah", "111-11-1111",
                "1978", "37", "123-456-7890" );
        // Create a phone field and store the phone string value into the phone field.
        Field phoneField = PatientBean.class.getDeclaredField("phone");
        // Set the phone private variable to public access temporarily.
        phoneField.setAccessible(true);
        // Store the string value from the phone in a temp variable.
        String aPhone = (String)phoneField.get(aPatient);
        // Return true if the phone number is not an empty string.
        assertTrue(aPhone != "");
    }

    // This is ignored and never executed.
    @Ignore
    public void testGetPhoneIgnore() throws Exception {
        // Create a patient bean
        PatientBean aPatient = new PatientBean("Isaiah", "111-11-1111",
                "1978", "37", "123-456-7890" );
        // Create a phone field and store the phone string value into the phone field.
        Field phoneField = PatientBean.class.getDeclaredField("phone");
        // Set the phone private variable to public access temporarily.
        phoneField.setAccessible(true);
        // Store the string value from the phone in a temp variable.
        String aPhone = (String)phoneField.get(aPatient);
        // Return true if the phone number is null.
        assertTrue(aPhone == null);
    }

    /* Method: setPhone(String phone)*/
    @Test
    public void testSetPhone() throws Exception {
        // Create a patient bean
        PatientBean aPatient = new PatientBean("Isaiah", "111-11-1111",
                "1978", "37", "123-456-7890" );
        // Create a phone field and store the phone string value into the phone field.
        Field phoneField = PatientBean.class.getDeclaredField("phone");
        // Set the phone private variable to public access temporarily.
        phoneField.setAccessible(true);
        // Store the string value from the phone in a temp variable.
        String aPhone = (String)phoneField.get(aPatient);
        // Return false if the phone number is null.
        assertFalse(aPhone == null);
    }

    /* Method: toString()*/
    @Test
    public void testToString() throws Exception {
        // Create a patient bean
        PatientBean aPatient = new PatientBean("Isaiah", "111-11-1111",
                "1978", "37", "123-456-7890" );
        // Create a SSN field and store the SSN string value into the SSN field.
        Field nameField = PatientBean.class.getDeclaredField("name");
        // Set the SSN private variable to public access temporarily.
        nameField.setAccessible(true);
        // Store the string value from the SSN in a temp variable.
        String aName = (String)nameField.get(aPatient);
        // Return false if the name field is null.
        assertFalse(aName == "");
    }

    // This will fail on purpose because two strings will not match
    @Test
    public void testException() {
        String name = "Barbara";
        String anotherName = "Barbora";
        if (name != anotherName) {
            // Return false if the name field is null.
            fail("Exception not thrown!");
        }
    }

    @After
    public void testArray() throws Exception {
        // Create an integer array.
        Integer[] numberList = {1,2,5,9,2,8,3,5};
        // Create another integer array.
        Integer[] anotherNumberList = {1,2,5,9,2,8,3,5};
        // Test if both integer arrays are equal to each other.
        assertArrayEquals(numberList, anotherNumberList);
    }
}
