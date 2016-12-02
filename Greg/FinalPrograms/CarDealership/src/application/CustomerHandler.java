package application;


import javax.persistence.EntityManagerFactory;
import java.util.Scanner;

/**
 * Created by gvh574 on 11/29/2016.
 */
public interface CustomerHandler {

    void list(EntityManagerFactory emf);

    String search(Scanner input, EntityManagerFactory emf);

    void search(EntityManagerFactory emf, String make, String model);


}
