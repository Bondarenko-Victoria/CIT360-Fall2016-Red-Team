package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

/**
 * Created by gvh57 on 10/24/2016.
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        Scanner input = new Scanner(System.in);

        em.getTransaction().begin();
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
                                "0 - Quit\n");


            userInput = input.nextLine();
            switch(userInput){
                case "1":
                    selectCars(em);
                    break;

                case "2":
                    addCar(em, input);
                    break;

                case "3":
                    listOwnerAndCars(em);
                    break;

                case "4":
                    addOwner(em, input);
                    break;

                case "5":
                    addOwnerToCar(em, input);
                    break;

                case "6":
//                    removeCar(em, input);
                    break;

                case "7":
                    System.out.println("bahhh");
                    break;

                case "0":
                    em.close();
                    return;

                default:
                    break;
            }
        }


    }

    public static void selectCars(EntityManager em){

        System.out.println("All vehicles currently in our database:");

//        create list of type "CarEntity" and query DB return list of all cars
        List<CarEntity> carE = em.createQuery("from CarEntity").getResultList();

//        iterate through list with foreach loop
        for (CarEntity temp : carE) {
            System.out.println(temp.getColor() + " " + temp.getYear() + " " + temp.getMake() + " " + temp.getModel());
        }

    }

    public static void addCar(EntityManager em, Scanner input){
        System.out.println("Please enter vehicle information in this format --- *is optional");
        System.out.println("<color> <year> <make> <model> <vin*>");

        String[]userInput = input.nextLine().split(" ");

        CarEntity newCar = new CarEntity();


        newCar.setColor(userInput[0]);
        newCar.setYear(Integer.parseInt(userInput[1]));
        newCar.setMake(userInput[2]);
        newCar.setModel(userInput[3]);
//        if(!userInput[4].isEmpty()){
//            newCar.setVin(userInput[4]);
//        }

        em.persist(newCar);
        em.flush();
        em.getTransaction().commit();

        System.out.println("Car Successfully Added");


//        for (int i = 0; i < userInput.length ; i++) {
//            System.out.println(userInput[i]);
//        }

    }

    public static void listOwnerAndCars(EntityManager em){
        System.out.println("Owner \\ Color \\ Year \\ Make \\ Model");

        List<CarOwnerEntity> carOwners = em.createQuery("from CarOwnerEntity ").getResultList();
        for (CarOwnerEntity carOwner: carOwners) {
            System.out.println(carOwner.getOwnerEntity().getFirstname() + " " + carOwner.getOwnerEntity().getLastname() + "\t" + carOwner.getCarEntity().getColor() +
                                " " + carOwner.getCarEntity().getYear() + " " + carOwner.getCarEntity().getMake() + " " + carOwner.getCarEntity().getModel());

        }
    }

    public static void addOwner(EntityManager em, Scanner input){
        System.out.println("Please enter the Owner's first and last name:");
        String[] name = input.nextLine().split(" ");

        OwnerEntity newOwner = new OwnerEntity();
        newOwner.setFirstname(name[0]);
        newOwner.setLastname(name[1]);

        em.persist(newOwner);
        em.flush();
        em.getTransaction().commit();

        System.out.println("Owner Successfully Added");
    }

    public static void addOwnerToCar(EntityManager em, Scanner input){
        System.out.println("Please select Owner  from the list");

        List<OwnerEntity> ownerList = em.createQuery("from OwnerEntity ").getResultList();
        int count = 0;
        for (OwnerEntity temp : ownerList) {
            System.out.println(count + ". " +temp.getFirstname() + " " + temp.getLastname());
            count++;
        }

        int ownerNum = input.nextInt();

        OwnerEntity newOwner = new OwnerEntity();
        newOwner = ownerList.get(ownerNum);



        List<CarEntity> carList = em.createQuery("from CarEntity").getResultList();
        System.out.println("Please select the car you would like to add the owner to:");
        count = 0;
        for (CarEntity temp : carList) {
            System.out.println(count + ". " + temp.getColor() + " " + temp.getYear() + " " + temp.getMake() + " " + temp.getModel());
            count++;
        }

        int carNum = input.nextInt();

        CarEntity ownerCar = new CarEntity();
        ownerCar = carList.get(carNum);

        CarOwnerEntity newCarOwnerEntity = new CarOwnerEntity();
        newCarOwnerEntity.setOwnerEntity(newOwner);
        newCarOwnerEntity.setCarEntity(ownerCar);
        newCarOwnerEntity.setIsCurrentOwner(1);
        Date date = new Date();
        newCarOwnerEntity.setPurchaseDate(date.toString());
        newCarOwnerEntity.setVin("4sad65sa54dsa465da");

        em.persist(newCarOwnerEntity);
        em.flush();
        em.getTransaction().commit();
        System.out.println("Successfully added new Owner to car");
    }


//    public static void  removeCar(EntityManager em, Scanner input){
//
//        List<CarEntity> carList = em.createQuery("from CarEntity").getResultList();
//        System.out.println("Please select the car you would like to remove:");
//        int count = 0;
//        for (CarEntity temp : carList) {
//            System.out.println(count + ". " + temp.getColor() + " " + temp.getYear() + " " + temp.getMake() + " " + temp.getModel());
//            count++;
//        }
//
//        int carNum = input.nextInt();
//
//        Query query = em.createQuery(
//                "DELETE CarEntity c WHERE c.id = :p").setParameter("p", carList.get(carNum).getId());
//        query.executeUpdate();
//
//        em.getTransaction().commit();
//
//        System.out.println("Successfully deleted Car");
//    }

}
