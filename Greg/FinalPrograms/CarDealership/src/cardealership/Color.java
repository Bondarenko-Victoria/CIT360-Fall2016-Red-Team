package cardealership;

import application.ManagerHandler;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gvh574 on 11/30/2016.
 */
@Entity
public class Color implements ManagerHandler {
    private int colorId;
    private String color;

    @Id
    @Column(name = "color_id")
    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void add(Scanner input, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        //        begin transaction
        em.getTransaction().begin();

        System.out.println("\nWhat color would you like to add?");

        Color newColor = new Color();
        newColor.setColor(input.nextLine());

        //        add to PersistenceContext
        em.persist(newColor);
//        clear any objects from queue
        em.flush();
//        commit changes to DB
        em.getTransaction().commit();

        System.out.println("Vehicle Color Successfully Added");

//        close transaction
        em.close();

    }

    public void update(Scanner input, EntityManagerFactory emf) {

    } // dont need it

    public void remove(Scanner input, EntityManagerFactory emf) {
//        //        create entity manager
//        EntityManager em = emf.createEntityManager();
////        begin transaction
//        em.getTransaction().begin();
//
////        create list of cars
//        List<Color> colorList = em.createQuery("from Color").getResultList();
//
//        System.out.println("****************************************WARNING*********************************************");
//        System.out.println("If you delete a vehicle color, any vehicles associated with it will have no color");
//        System.out.println("\nPlease select the Vehicle Color you would like to remove:");
//
//
////        loop through list of cars
//        for (Color temp : colorList) {
//            System.out.println(colorList.indexOf(temp) + ". " + temp.getColor());
//        }
//
////        collect user input
//        int makeNum = Integer.parseInt(input.nextLine());
//
////        first delete the foreign key constraint in the many to one table (CarOwner)
//        Query q = em.createQuery("delete Color m where m.color=:p").setParameter("p", colorList.get(makeNum).getColor());
//
////        execute updates to table
//        q.executeUpdate();
//
////        make changes
//        em.getTransaction().commit();
//
//        System.out.println("Successfully deleted Vehicle Color");
//
    }


}
