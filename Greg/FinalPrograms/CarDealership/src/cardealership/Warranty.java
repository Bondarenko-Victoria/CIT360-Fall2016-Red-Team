package cardealership;

import application.CustomerHandler;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gvh574 on 11/30/2016.
 */
@Entity
public class Warranty implements CustomerHandler {

    private String name;
    private String type;

    @Id
    @Column(name = "warranty_id")
    private int warrantyId;
    public int getWarrantyId() {
        return warrantyId;
    }

    public void setWarrantyId(int warrantyId) {
        this.warrantyId = warrantyId;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void list(EntityManagerFactory emf){
        EntityManager em = emf.createEntityManager();
        //        begin transaction
        em.getTransaction().begin();

        System.out.println("\nOur Vehicle Makes and their Warranties:");

        //        create list of type "CarEntity" and query DB return list of all cars
        List<Warranty> warranties = em.createQuery("from Warranty").getResultList();

        //        iterate through list with foreach loop
        for (Warranty temp : warranties) {
            System.out.println(temp.getVehicleMake().getCarMake() + " \t" + temp.getName() + " \t" + temp.getType());
        }
        System.out.println("");
        //        close transaction
        em.close();

    }

    public String search(Scanner input, EntityManagerFactory emf){
        return "";
    }

    public void search(EntityManagerFactory emf, String make, String model) {

    }
}
