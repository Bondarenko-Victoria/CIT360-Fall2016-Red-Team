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
@Table(name = "model", schema = "cardealership", catalog = "")
public class Model implements CustomerHandler, ManagerHandler {

    private String carModel;

    @Id
    @Column(name = "model_id")
    private int modelId;
    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "make_id")
    private Make vehicleMake;

    public Make getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(Make vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    @Basic
    @Column(name = "carModel")
    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void list(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        //        begin transaction
        em.getTransaction().begin();

        System.out.println("\nAll vehicle brands currently at our dealership:");

        //        create list of type "CarEntity" and query DB return list of all cars
        List<Model> models = em.createQuery("from Model").getResultList();

        //        iterate through list with foreach loop
        for (Model temp : models) {
            System.out.println(temp.getVehicleMake().getCarMake() +" "+ temp.getCarModel());
        }
        System.out.println("");
        //        close transaction
        em.close();
    }

    public String search(Scanner input, EntityManagerFactory emf) {
        System.out.println("What model are you looking for?");
        String modelOfCar = input.nextLine();
//        Capitalize the first letter of the carMake
        modelOfCar = modelOfCar.toLowerCase();
        String firstLetter = modelOfCar.substring(0, 1).toUpperCase();
        modelOfCar = firstLetter + modelOfCar.substring(1);


        EntityManager em = emf.createEntityManager();
        //        begin transaction
        em.getTransaction().begin();

        List<Make> makeList = em.createQuery("from Model m where m.carModel=:p").setParameter("p", modelOfCar).getResultList();
        int count = makeList.size();
        em.close();

        if(count != 0){
            return modelOfCar;
        }else{
            System.out.println("We do not carry that model of vehicle.");
            return "";
        }
    }

    public void search(EntityManagerFactory emf, String make, String model) {

    }

    public void add(Scanner input, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        //        begin transaction
        em.getTransaction().begin();

        System.out.println("\nWhat is the Make of the vehicle you would like to add a model to?");
        List<Make> makeList = em.createQuery("from Make ").getResultList();

        int count = 0;
        for (Make temp : makeList) {
            System.out.println(count + " " + temp.getCarMake());
            count++;
        }

        int makeNum = input.nextInt();

        if(makeNum > makeList.size()){
            System.out.println("No such Make Menu Item");
            return;
        }

        Make menuMake = new Make();
        menuMake = makeList.get(makeNum);

        System.out.println("\nPlease type the name of the model you would like to add to "+ menuMake.getCarMake());

        input.nextLine(); // Blank next line to address nextInt skipping
        String modelStr = input.nextLine();

        //        Capitalize the first letter of the carMake
        modelStr = modelStr.toLowerCase();
        String firstLetter = modelStr.substring(0, 1).toUpperCase();
        modelStr = firstLetter + modelStr.substring(1);

        List<Model> modelList = em.createQuery("from Model m where m.carModel=:p").setParameter("p", modelStr).getResultList();
        int exists = modelList.size();

        if(exists != 0){
            System.out.println("That model already exists");
            return;
        }


        Model newModel = new Model();

        newModel.setVehicleMake(menuMake);
        newModel.setCarModel(modelStr);

        //        add to PersistenceContext
        em.persist(newModel);
//        clear any objects from queue
        em.flush();
//        commit changes to DB
        em.getTransaction().commit();

        System.out.println("Vehicle Model Successfully Added");

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
        List<Model> modelList = em.createQuery("from Model").getResultList();

        System.out.println("****************************************WARNING*********************************************");
        System.out.println("If you delete a vehicle model, any vehicles associated with it will also be deleted");
        System.out.println("\nPlease select the Vehicle Model you would like to remove:");


//        loop through list of cars
        for (Model temp : modelList) {
            System.out.println(modelList.indexOf(temp) + ". " + temp.getVehicleMake().getCarMake() + " " + temp.getCarModel());
        }

//        collect user input
        int makeNum = Integer.parseInt(input.nextLine());

//        first delete the foreign key constraint in the many to one table (CarOwner)
        Query q = em.createQuery("delete Model m where m.carModel=:p").setParameter("p", modelList.get(makeNum).getCarModel());

//        execute updates to table
        q.executeUpdate();

//        make changes
        em.getTransaction().commit();

        System.out.println("Successfully deleted Vehicle Model");

    }
}
