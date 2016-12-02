package cardealership;

import application.CustomerHandler;
import application.ManagerHandler;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gvh574 on 11/30/2016.
 */
@Entity
@Table(name = "make", schema = "cardealership", catalog = "")
public class Make implements CustomerHandler, ManagerHandler{
    private int makeId;
    private String carMake;

    @Id
    @Column(name = "make_id")
    public int getMakeId() {
        return makeId;
    }

    public void setMakeId(int makeId) {
        this.makeId = makeId;
    }

    @OneToMany(orphanRemoval = true, mappedBy = "vehicleMake")
    List<Model> modelList;

    @Basic
    @Column(name = "carMake")
    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public void list(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        //        begin transaction
        em.getTransaction().begin();

        System.out.println("\nAll vehicle brands currently at our dealership:");

        //        create list of type "CarEntity" and query DB return list of all cars
        List<Make> make = em.createQuery("from Make").getResultList();

        //        iterate through list with foreach loop
        for (Make temp : make) {
            System.out.println(temp.getCarMake());
        }
        //        close transaction
        em.close();
    }

    public String search(Scanner input, EntityManagerFactory emf) {
        System.out.println("What is the make of the car");
        String makeOfCar = input.nextLine();
//        Capitalize the first letter of the carMake
        makeOfCar = makeOfCar.toLowerCase();
        String firstLetter = makeOfCar.substring(0, 1).toUpperCase();
        makeOfCar = firstLetter + makeOfCar.substring(1);


        EntityManager em = emf.createEntityManager();
        //        begin transaction
        em.getTransaction().begin();

        List<Make> makeList = em.createQuery("from Make m where m.carMake=:p").setParameter("p", makeOfCar).getResultList();
        int count = makeList.size();
        em.close();

        if(count != 0){
            return makeOfCar;
        }else{
            System.out.println("We do not carry that make of vehicle.");
            return "";
        }
    }

    public void search(EntityManagerFactory emf, String make, String model) {

    }

    public void add(Scanner input, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        //        begin transaction
        em.getTransaction().begin();

        System.out.println("\nWhat is the Make of the vehicle you would like to add?");

        Make newMake = new Make();
        newMake.setCarMake(input.nextLine());

        //        add to PersistenceContext
        em.persist(newMake);
//        clear any objects from queue
        em.flush();
//        commit changes to DB
        em.getTransaction().commit();

        System.out.println("Vehicle Make Successfully Added");

//        close transaction
        em.close();
    }

    public void update(Scanner input, EntityManagerFactory emf) {

    } // dont need it

    public void remove(Scanner input, EntityManagerFactory emf) {
        //        create entity manager
        EntityManager em = emf.createEntityManager();
//        begin transaction
        em.getTransaction().begin();

//        create list of cars
        List<Make> makeList = em.createQuery("from Make").getResultList();

        System.out.println("****************************************WARNING*********************************************");
        System.out.println("If you delete a vehicle make, all models and vehicles associate with it will also be deleted");
        System.out.println("\nPlease select the Vehicle Make you would like to remove:");


//        loop through list of cars
        for (Make temp : makeList) {
            System.out.println(makeList.indexOf(temp) + ". " + temp.getCarMake());
        }

//        collect user input
        int makeNum = Integer.parseInt(input.nextLine());

//        first delete the foreign key constraint in the many to one table (CarOwner)
        Query q = em.createQuery("delete Make m where m.carMake=:p").setParameter("p", makeList.get(makeNum).getCarMake());

//        execute updates to table
        q.executeUpdate();

//        make changes
        em.getTransaction().commit();

        System.out.println("Successfully deleted Vehicle Make");

    }
}
