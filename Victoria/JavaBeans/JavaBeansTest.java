package JavaBeans;

/**
 * Created by Victoria on 04.10.2016.
 */

public class JavaBeansTest {
    // Tester method
    public static void main(String[] args) {
        JavaBeansExample cat = new JavaBeansExample();

        cat.setCatName("Tiger");
        cat.setCatAge(5);
        cat.setCatWeight(6);

        // Output:
        System.out.println("Cat's name is " + cat.getCatName());
        System.out.println("Cat's age is " + cat.getCatAge());
        System.out.println("Cat's weight is " + cat.getCatWeight());
    }
}