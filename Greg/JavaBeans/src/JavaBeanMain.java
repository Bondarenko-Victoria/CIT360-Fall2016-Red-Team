/**
 * Created by gvh57 on 10/6/2016.
 */
public class JavaBeanMain {

    public static void main(String[] args) {
        JavaBeanSand Test = new JavaBeanSand();

        Test.setAge(25);
        Test.setName("Greg");
        Test.setCity("Rexburg");
        Test.setState("ID");
        Test.setStreetNumber(311);
        Test.setZipCode(83440);
        Test.setStreet("N 1st E");

        System.out.println("Hello, my name is " + Test.getName() + ", and I live at\n" +
        Test.getStreetNumber() + " " + Test.getStreet() + "\n" +
        Test.getCity() + ", " + Test.getState() + " " + Test.getZipCode());

    }

}
