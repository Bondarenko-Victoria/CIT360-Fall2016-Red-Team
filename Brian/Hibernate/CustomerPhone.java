package Customer;
import javax.persistence.*;

@Entity
@Table(name = "phone")
public class CustomerPhone {
    
    @Id
    @GeneratedValue
    private int phoneId;
    private String phoneNumber;

    @Column(name="phone_id")
    public int getPhoneId() {
        return phoneId;
    }

    @Column(name="phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}