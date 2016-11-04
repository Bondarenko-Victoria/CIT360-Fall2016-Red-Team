package test;

import javax.persistence.*;
import java.security.acl.Owner;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

/**
 * Created by gvh57 on 10/24/2016.
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");

        Scanner input = new Scanner(System.in);

        String userInput;


        String action = null;
        while(action != "0") {
            System.out.println("\nWhat is your command?");
            System.out.println("1 - See list of cars\n" +
                                "2 - Add a car\n" +
                                "3 - See list owners and their cars\n" +
                                "4 - Add an owner\n" +
                                "5 - Add an owner to a car\n" +
                                "6 - Remove a car\n" +
                                "7 - Remove an owner\n" +
                                "8 - Remove an owner from a car\n" +
                                "0 - Quit\n");

//SWITCH STATEMENT TO LOOP THROUGH AVAILABLE COMMANDS
            userInput = input.nextLine();
            switch(userInput){
                case "1":
                    selectCars(emf);
                    break;

                case "2":
                    addCar(emf, input);
                    break;

                case "3":
                    listOwnerAndCars(emf);
                    break;

                case "4":
                    addOwner(emf, input);
                    break;

                case "5":
                    addOwnerToCar(emf, input);
                    break;

                case "6":
                    removeCar(emf, input);
                    break;

                case "7":
                    removeOwner(emf, input);
                    break;

                case "8":
                    removeOwnerFromCar(emf, input);
                    break;

                case "0":
                    return;

                default:
                    break;
            }
        }


    }

//    select all cars
    public static void selectCars(EntityManagerFactory emf){
//        create entitymanager
        EntityManager em = emf.createEntityManager();
//        begin transaction
        em.getTransaction().begin();

        System.out.println("All vehicles currently in our database:");

//        create list of type "CarEntity" and query DB return list of all cars
        List<CarEntity> carE = em.createQuery("from CarEntity").getResultList();

//        iterate through list with foreach loop
        for (CarEntity temp : carE) {
            System.out.println(temp.getColor() + " " + temp.getYear() + " " + temp.getMake() + " " + temp.getModel());
        }
//        close transaction
        em.close();

    }

    public static void addCar(EntityManagerFactory emf, Scanner input){
//        create entitymanager
        EntityManager em = emf.createEntityManager();
//        being transaction
        em.getTransaction().begin();

        System.out.println("Please enter vehicle information in this format");
        System.out.println("<color> <year> <make> <model>");

//        take in user input as string and split it at each "space"
        String[]userInput = input.nextLine().split(" ");

//        create new car
        CarEntity newCar = new CarEntity();

//        set its attributes
        newCar.setColor(userInput[0]);
        newCar.setYear(Integer.parseInt(userInput[1]));
        newCar.setMake(userInput[2]);
        newCar.setModel(userInput[3]);

//        add to PersistenceContext
        em.persist(newCar);
//        clear any objects from queue
        em.flush();
//        commit changes to DB
        em.getTransaction().commit();

        System.out.println("Car Successfully Added");

//        close transaction
        em.close();


    }

    public static void listOwnerAndCars(EntityManagerFactory emf){
//        create entity manager
        EntityManager em = emf.createEntityManager();
//        begin transaction
        em.getTransaction().begin();

        System.out.println("Owner \\ Color \\ Year \\ Make \\ Model");

//        create list of carownerentity, we need this to access both tables (car and owner)
        List<CarOwnerEntity> carOwners = em.createQuery("from CarOwnerEntity ").getResultList();

//        loop through list and display
        for (CarOwnerEntity carOwner: carOwners) {
            System.out.println(carOwner.getOwnerEntity().getFirstname() + " " + carOwner.getOwnerEntity().getLastname() + "\t" + carOwner.getCarEntity().getColor() +
                                " " + carOwner.getCarEntity().getYear() + " " + carOwner.getCarEntity().getMake() + " " + carOwner.getCarEntity().getModel());
        }
//        close transaction
        em.close();
    }

    public static void addOwner(EntityManagerFactory emf, Scanner input){
//        create entitymanager
        EntityManager em = emf.createEntityManager();
//        being transaction
        em.getTransaction().begin();


        System.out.println("Please enter the Owner's first and last name:");

//        split input by the "space" and assign it to array
        String[] name = input.nextLine().split(" ");

//        create new owner
        OwnerEntity newOwner = new OwnerEntity();

//        set its attributes
        newOwner.setFirstname(name[0]);
        newOwner.setLastname(name[1]);

//        add to PersistenceContext
        em.persist(newOwner);
//        clear any objects in queue
        em.flush();
//        make changes
        em.getTransaction().commit();

        System.out.println("Owner Successfully Added");

//        close transaction
        em.close();
    }

    public static void addOwnerToCar(EntityManagerFactory emf, Scanner input){
//        create entityManager
        EntityManager em = emf.createEntityManager();
//        begin transaction
        em.getTransaction().begin();

        System.out.println("Please select Owner  from the list");

//        create list of owners
        List<OwnerEntity> ownerList = em.createQuery("from OwnerEntity ").getResultList();

//        create counter
        int count = 0;

//        loop through owner list
        for (OwnerEntity temp : ownerList) {
            System.out.println(count + ". " +temp.getFirstname() + " " + temp.getLastname());
            count++;
        }

//        get input from user, which owner do they want to add to a car
        int ownerNum = input.nextInt();

//        create new owner
        OwnerEntity newOwner = new OwnerEntity();

//        assign owner selected from list to newly created owner
        newOwner = ownerList.get(ownerNum);

//        create list of available cars
        List<CarEntity> carList = em.createQuery("from CarEntity").getResultList();

        System.out.println("Please select the car you would like to add the owner to:");

//        reset counter to 0
        count = 0;

//        loop through and display cars
        for (CarEntity temp : carList) {
            System.out.println(count + ". " + temp.getColor() + " " + temp.getYear() + " " + temp.getMake() + " " + temp.getModel());
            count++;
        }

//        collect input from user on which car they've selected'
        int carNum = input.nextInt();

//        create new car
        CarEntity ownerCar = new CarEntity();

//        assign car from list to new car
        ownerCar = carList.get(carNum);

//        create new CarOwnerEntity, this is the many to one table
        CarOwnerEntity newCarOwnerEntity = new CarOwnerEntity();

//        set attributes
        newCarOwnerEntity.setOwnerEntity(newOwner); // - add new car to the many to one relationship
        newCarOwnerEntity.setCarEntity(ownerCar); // - add new owner to the many to one relationship
        newCarOwnerEntity.setIsCurrentOwner(1);
        Date date = new Date();
        newCarOwnerEntity.setPurchaseDate(date.toString());
        newCarOwnerEntity.setVin("4sad65sa54dsa465da");

//        add to PersistenceContext
        em.persist(newCarOwnerEntity);
//        clear objects from queue
        em.flush();
//        make changes
        em.getTransaction().commit();

        System.out.println("Successfully added new Owner to car");
//        close transaction
        em.close();
    }


    public static void  removeCar(EntityManagerFactory emf, Scanner input){
//        create entity manager
        EntityManager em = emf.createEntityManager();
//        begin transaction
        em.getTransaction().begin();

//        create list of cars
        List<CarEntity> carList = em.createQuery("from CarEntity").getResultList();

        System.out.println("Please select the car you would like to remove:");

        int count = 0;
//        loop through list of cars
        for (CarEntity temp : carList) {
            System.out.println(count + ". " + temp.getColor() + " " + temp.getYear() + " " + temp.getMake() + " " + temp.getModel());
            count++;
        }

//        collect user input
        int carNum = input.nextInt();

//        first delete the foreign key constraint in the many to one table (CarOwner)
        Query q = em.createQuery("delete CarOwnerEntity where carEntity.id=:p").setParameter("p", carList.get(carNum).getId());

//        then delete the actual car
        Query query = em.createQuery(
                "DELETE CarEntity c WHERE c.id = :p").setParameter("p", carList.get(carNum).getId());

//        execute updates to table
        q.executeUpdate();
        query.executeUpdate();

//        make changes
        em.getTransaction().commit();

        System.out.println("Successfully deleted Car");
    }

    public static void  removeOwner(EntityManagerFactory emf, Scanner input){
//        create entity manager
        EntityManager em = emf.createEntityManager();
//        begin transaction
        em.getTransaction().begin();

//        create list of owners
        List<OwnerEntity> ownerList = em.createQuery("from OwnerEntity").getResultList();

        System.out.println("Please select the owner you would like to remove:");

        int count = 0;
//        loop through owner list
        for (OwnerEntity temp : ownerList) {
            System.out.println(count + ". " + temp.getFirstname() + " " + temp.getLastname());
            count++;
        }

//        collect input from user
        int ownerNum = input.nextInt();

//        first delete foreign key constraint from many to one table (CarOwnerEntity)
        Query q = em.createQuery("delete CarOwnerEntity where ownerEntity.id=:p").setParameter("p", ownerList.get(ownerNum).getId());

//        then delete the actual owner
        Query query = em.createQuery(
                "DELETE OwnerEntity c WHERE c.id = :p").setParameter("p", ownerList.get(ownerNum).getId());

//        execute updates to tables
        q.executeUpdate();
        query.executeUpdate();

//        make changes
        em.getTransaction().commit();

        System.out.println("Successfully deleted Owner");

//        close transaction
        em.close();
    }

    public static void  removeOwnerFromCar(EntityManagerFactory emf, Scanner input){
//        create entity manager
        EntityManager em = emf.createEntityManager();
//        begin transaction
        em.getTransaction().begin();

//        query and create list of owners
        List<OwnerEntity> ownerList = em.createQuery("from OwnerEntity").getResultList();

        System.out.println("Please select the owner:");

        int count = 0;

//        loop through list of owners
        for (OwnerEntity temp : ownerList) {
            System.out.println(count + ". " + temp.getFirstname() + " " + temp.getLastname());
            count++;
        }

//        collect input from user
        int ownerNum = input.nextInt();

        System.out.println("Please select the car you would like to remove the owner from:");

//        reset count to 0
        count = 0;

//        query and create list of cars the owner has
        List<CarOwnerEntity> carOwnerList = em.createQuery("from CarOwnerEntity WHERE ownerEntity.id=:p").setParameter("p",ownerList.get(ownerNum).getId()).getResultList();

//        loop through list to get cars owner has
        for (CarOwnerEntity temp : carOwnerList) {
            System.out.println(count + ". " + temp.getCarEntity().getColor() + " " + temp.getCarEntity().getYear() + " " + temp.getCarEntity().getMake() + " " + temp.getCarEntity().getModel());
            count++;
        }

//       collect input from user about car owned and to be remove
        int carNum = input.nextInt();

//        create query to remove foreign key relationship where car_id and owner_id are equal to what user selected
        Query query = em.createQuery("delete CarOwnerEntity where ownerEntity.id=:p AND carEntity.id=:q").setParameter("p", ownerList.get(ownerNum).getId()).setParameter("q", carOwnerList.get(carNum).getCarEntity().getId());

//        execute query
        query.executeUpdate();
//        make changes
        em.getTransaction().commit();

        System.out.println("Successfully remove owner from car");
//        close transaction
        em.close();
    }

}


@JoinTable(
        name="Customer",
        joinColumns =
                @JoinColumn(name="addressId", referencedColumnName = "id"),
        inverseJoinColumns =
                @JoinColumn(name="phoneId", referencedColumnName = "id")
)


//NASTY PATHS

//There are tons of possibilities for Nasty Paths using JPA or hibernate. I encountered many that I imagine are common among new users of the technology.
//
//Foreign Key Constraint Errors
//
//Variable Naming errors | sometimes intelliJ will rename the columns differently. This can create mapping issues.
//
//Initial setup is a pain, and I can understand why so many individuals have a tough time setting it up properly.
//
//Database connection issues
//
//Table Relationship issues | Getting the appropriate relationships down was difficult. My queries were failing for the longest time because I had incorrect
//relationships between my tables.