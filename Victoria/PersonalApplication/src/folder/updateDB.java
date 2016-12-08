package folder;

import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class updateDB {

    // Results of the query will store in this list of product objects
    public static List<product> items;

    // **** Query entire table ****
    public static void queryDB(){
        // Creates SessionFactory
        SessionFactory session =
                new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(product.class).buildSessionFactory();

        // Opens new session
        Session newSession = session.getCurrentSession();
        newSession = session.getCurrentSession();
        newSession.beginTransaction();

        // each row it is some object, that's how stores each row/object into list
        //Query all object (everything from this table) in DB
        items = newSession.createQuery("from product").list();

        // Displays all objects
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Prints query contents...");
        // Loop that prints all rows in DB
        for (product result : items){
            System.out.println("Object: " + result);
        }

    }

    // **** Delete from product table ****
    // Passes id of the row that will be deleted
    public static void deleteDB(int deleteID){
        // Creates SessionFactory
        SessionFactory session =
                new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(product.class).buildSessionFactory();

        // Opens new session
        Session newSession = session.getCurrentSession();
        newSession = session.getCurrentSession();
        newSession.beginTransaction();

        // Deletes in the table the id that the user specified
        // one row
        newSession.createQuery("delete from product where key = " + deleteID).executeUpdate();

        // Commits deletion
        newSession.getTransaction().commit();

    }

    // **** Delete entire table ****
    // Passes id of the row that will be deleted
    public static void deleteTable(){
        // Creates SessionFactory
        SessionFactory session =
                new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(product.class).buildSessionFactory();

        // Opens new session
        Session newSession = session.getCurrentSession();
        newSession = session.getCurrentSession();
        newSession.beginTransaction();

        // Deletes in the table the id that the user specified
        newSession.createQuery("delete from product").executeUpdate();

        // Commits deletion
        newSession.getTransaction().commit();

    }


    // ***** Set up DB to use and add to DB ****
    public static void useDB(int key, String item, String description, int quantity){

        // CreateS SessionFactory
        SessionFactory session =
                new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(product.class).buildSessionFactory();

        // Opens new session
        Session newSession = session.getCurrentSession();
        newSession = session.getCurrentSession();
        // Begin transaction
        newSession.beginTransaction();

        // From product class
        // Creates object and sets its attributes/values
        product inventory = new product();
        inventory.setKey(key);
        inventory.setItem(item);
        inventory.setDescription(description);
        inventory.setQuantity(quantity);

        // Saves the object to DB
        newSession.save(inventory);

        // Commits and closes transaction
        newSession.getTransaction().commit();
    }
}