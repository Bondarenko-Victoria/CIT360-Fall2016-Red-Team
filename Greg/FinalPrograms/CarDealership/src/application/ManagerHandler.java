package application;

import javax.persistence.EntityManagerFactory;
import java.util.Scanner;

/**
 * Created by gvh574 on 11/30/2016.
 */
public interface ManagerHandler {

    void add(Scanner input, EntityManagerFactory emf);

    void update(Scanner input, EntityManagerFactory emf);

    void remove(Scanner input, EntityManagerFactory emf);

}
