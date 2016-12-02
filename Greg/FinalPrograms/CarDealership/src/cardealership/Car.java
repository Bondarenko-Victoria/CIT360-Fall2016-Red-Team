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
public class Car implements CustomerHandler, ManagerHandler {

    private int year;
    private int price;

    @Id
    @Column(name = "vin")
    private String vin;
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

//    relationships
    //make
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "make_id")
    private Make vehicleMake;

    public Make getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(Make vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    //model
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "model_id")
    private Model vehicleModel;

    public Model getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(Model vehicleModel) {
        this.vehicleModel = vehicleModel;
    }


    //color
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "color_id")
    private Color vehicleColor;

    public Color getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(Color vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    //warranty
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "warranty_id")
    private Warranty vehicleWarranty;

    public Warranty getVehicleWarranty() {
        return vehicleWarranty;
    }

    public void setVehicleWarranty(Warranty vehicleWarranty) {
        this.vehicleWarranty = vehicleWarranty;
    }

    @Basic
    @Column(name = "year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void list(EntityManagerFactory emf){
        System.out.println("Here are all of the vehicles at this dealership:");

        EntityManager em = emf.createEntityManager();
        //        begin transaction
        em.getTransaction().begin();

        List<Car> carList = em.createQuery("from Car" ).getResultList();

        for (Car temp : carList) {
            System.out.println(temp.getVehicleMake().getCarMake() + " " + temp.getVehicleModel().getCarModel() + " " + temp.getVehicleColor().getColor() + " " + temp.getYear());
        }

        System.out.println("");
        em.close();

    }

    public void search(EntityManagerFactory emf, String make, String model){
        System.out.println("Here is a list of cars that match that criteria:");

        EntityManager em = emf.createEntityManager();
        //        begin transaction
        em.getTransaction().begin();

        List<Car> carList = em.createQuery("from Car c where c.vehicleMake.carMake=:p AND c.vehicleModel.carModel=:m").setParameter("p", make).setParameter("m", model).getResultList();

        for (Car temp : carList) {
            System.out.println(temp.getVehicleMake().getCarMake() + " " + temp.getVehicleModel().getCarModel() + " " + temp.getVehicleColor().getColor() + " " + temp.getYear());
        }

        System.out.println("");
        em.close();
    }

    public String search(Scanner input, EntityManagerFactory emf) {
        return null;
    }

    public void add(Scanner input, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        //        begin transaction
        em.getTransaction().begin();

        System.out.println("\nWhat is the Make of the vehicle you would like to add?");
        List<Make> makeList = em.createQuery("from Make ").getResultList();

        int count = 0;
        for (Make temp : makeList) {
            System.out.println(count + " " + temp.getCarMake());
            count++;
        }

        int makeNum = Integer.parseInt(input.nextLine());

        if(makeNum > makeList.size()){
            System.out.println("No such Make Menu Item");
            return;
        }

        Make menuMake = new Make();
        menuMake = makeList.get(makeNum);




        System.out.println("\nWhat is the Model of vehicle you would like to add?");

        List<Model> modelList = em.createQuery("from Model ").getResultList();

        count = 0;
        for (Model temp : modelList) {
            System.out.println(count + " " + temp.getCarModel());
            count++;
        }

        int modelNum = Integer.parseInt(input.nextLine());

        if(modelNum > modelList.size()){
            System.out.println("No such Model Menu Item");
            return;
        }

        Model menuModel = new Model();
        menuModel = modelList.get(modelNum);


        System.out.println("What is the Color of the vehicle you would like to add?");
        List<Color> colorList = em.createQuery("from Color ").getResultList();

        count = 0;
        for (Color temp : colorList) {
            System.out.println(count + " " + temp.getColor());
            count++;
        }

        int colorNum = Integer.parseInt(input.nextLine());

        if(colorNum > colorList.size()){
            System.out.println("No such Color Menu Item");
            return;
        }

        Color menuColor = new Color();
        menuColor = colorList.get(colorNum);


        System.out.println("What is the Year of the vehicle?");
        int carYear = Integer.parseInt(input.nextLine());

        System.out.println("What is the MSRP of the vehicle?");
        String tempPrice = input.nextLine();
        tempPrice = tempPrice.replace(",", "");
        int carPrice = Integer.parseInt(tempPrice);

        System.out.println("What is the VIN of the vehicle? - Must be 17 Characters");
        String carVIN = input.nextLine();
        if (!(carVIN.length() == 17)){
            System.out.println("Invalid VIN: too few characters");
            return;
        }

        //set warranty type
        List<Warranty> warr = em.createQuery("from Warranty w WHERE w.vehicleMake.carMake=:p").setParameter("p", menuMake.getCarMake()).getResultList();
        Warranty warranty = warr.get(0);

        Car newCar = new Car();
        newCar.setVehicleMake(menuMake);
        newCar.setVehicleModel(menuModel);
        newCar.setVehicleColor(menuColor);
        newCar.setYear(carYear);
        newCar.setPrice(carPrice);
        newCar.setVin(carVIN);
        newCar.setVehicleWarranty(warranty);


        //        add to PersistenceContext
        em.persist(newCar);
//        clear any objects from queue
        em.flush();
//        commit changes to DB
        em.getTransaction().commit();

        System.out.println("Vehicle Successfully Added");

//        close transaction
        em.close();

    }

    public void update(Scanner input, EntityManagerFactory emf) {
        //        create entity manager
        EntityManager em = emf.createEntityManager();
//        begin transaction
        em.getTransaction().begin();

//        create list of cars
        List<Car> carList = em.createQuery("from Car").getResultList();

        System.out.println("Please select the car you would like to update:");

        int count = 0;
//        loop through list of cars
        for (Car temp : carList) {
            System.out.println(count + ". " + temp.getVehicleMake().getCarMake() + " " + temp.getVehicleModel().getCarModel() + " " + temp.getVehicleColor().getColor() + " "
                    + temp.getYear());
            count++;
        }

//        collect user input
        int carNum = Integer.parseInt(input.nextLine());


//        first delete the foreign key constraint in the many to one table (CarOwner)
        Car updateCar = (Car) em.createQuery("from Car where vin=:p").setParameter("p", carList.get(carNum).getVin()).getSingleResult();

        System.out.println("What would you like to change?");
        System.out.println("1. Year: " + updateCar.getYear() + "\n"
                         + "2. Price: " + updateCar.getPrice() +"\n");
        int numChange = Integer.parseInt(input.nextLine());

        Query query;

        if(numChange == 1){
            System.out.println("Enter in new year:");
            numChange = Integer.parseInt(input.nextLine());
            updateCar.setYear(numChange);
            //        then update the actual car
            query = em.createQuery(
                    "UPDATE Car c SET c.year=:year WHERE c.vin = :p").setParameter("p", updateCar.getVin()).setParameter("year", updateCar.getYear());
        }else{
            System.out.println("Enter in new price:");
            String tempPrice = input.nextLine();
            tempPrice = tempPrice.replace(",", "");
            numChange = Integer.parseInt(tempPrice);
            updateCar.setPrice(numChange);
            //        then update the actual car
            query = em.createQuery(
                    "UPDATE Car c SET c.price=:price WHERE c.vin = :p").setParameter("p", updateCar.getVin()).setParameter("price", updateCar.getPrice());
        }


//        execute update to table
        query.executeUpdate();

//        make changes
        em.getTransaction().commit();

        System.out.println("Successfully Update Car");

    }

    public void remove(Scanner input, EntityManagerFactory emf) {
        //        create entity manager
        EntityManager em = emf.createEntityManager();
//        begin transaction
        em.getTransaction().begin();

//        create list of cars
        List<Car> carList = em.createQuery("from Car").getResultList();


        System.out.println("\nPlease select the Vehicle you would like to remove:");


//        loop through list of cars
        for (Car temp : carList) {
            System.out.println(carList.indexOf(temp) + ". " + temp.getVehicleMake().getCarMake() + " " + temp.getVehicleModel().getCarModel() +
                    " " + temp.getVehicleColor().getColor() + " "+ temp.getYear());
        }

//        collect user input
        int carNum = Integer.parseInt(input.nextLine());

//        first delete the foreign key constraint in the many to one table (CarOwner)
        Query q = em.createQuery("delete Car m where m=:p").setParameter("p", carList.get(carNum));

//        execute updates to table
        q.executeUpdate();

//        make changes
        em.getTransaction().commit();

        System.out.println("Successfully deleted Vehicle");

    }
}


