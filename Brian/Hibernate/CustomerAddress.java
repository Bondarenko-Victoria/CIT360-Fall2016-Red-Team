package Customer; /**
 * Created by Brian on 11/01/2016.
 */
import javax.persistence.*;

@Entity
@Table(name = "address")
public class CustomerAddress {
    @Id
    @GeneratedValue
    private int addressId;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;

    @Column(name="address_id")
    public int getAddressId() { return addressId; }

    @Column(name="street_address")
    public String getStreetAddress() {
        return streetAddress;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @Column(name="city")
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Column(name="state")
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    @Column(name="zipcode")
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
