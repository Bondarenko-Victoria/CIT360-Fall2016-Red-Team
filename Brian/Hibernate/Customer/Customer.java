package Customer; /**
 * Created by Brian on 11/01/2016.
 */
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private int phoneId;
    private int addressId;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name="customer",
            joinColumns = { @JoinColumn( name="phone_id") },
            inverseJoinColumns = @JoinColumn( name="address_id")
    )

    private List<CustomerPhone> customerPhone;
    private List<CustomerAddress> customerAddress;

    public Customer() {

    }

    @Override
    public String toString() {
        return "Customer.Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumbers=" + customerPhone +
                ", customerAddresses=" + customerAddress +
                '}';
    }

    @Column(name="id")
    public int getId() {
        return id;
    }

    @Column(name="first_name")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="last_name")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<CustomerPhone> getCustomerPhone() {
        return customerPhone;
    }

    public List<CustomerAddress> getCustomerAddress() {
        return customerAddress;
    }
}
