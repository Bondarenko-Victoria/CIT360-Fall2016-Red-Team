/**
 * Created by Brian on 11/05/2016.
 */
package BrianSandbox;
import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;

public class PatientBean implements Serializable{

    /* Private variables for a Patient Bean */
    private String name;
    private String SSN;
    private String birthYear;
    private String age;
    private String phone;

    // Default constructor for a Patient Bean
    public PatientBean() { }

    // Constructor for the a Patient Bean
    public PatientBean(String name, String SSN, String birthYear,
                           String age, String phone) {
            this.name = name;
            this.SSN = SSN;
            this.birthYear = birthYear;
            this.age = age;
            this.phone = phone;
    }

    public PatientBean(HashMap jeffHashMap) throws ParseException {
        this.name = (String)jeffHashMap.get("name");
        this.SSN = (String)jeffHashMap.get("SSN");
        this.birthYear =  (String)jeffHashMap.get("birthYear");
        this.age = (String)jeffHashMap.get("age");
        this.phone = (String)jeffHashMap.get("phone");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PatientBean{" +
                "name='" + name + '\'' +
                ", SSN='" + SSN + '\'' +
                ", birthYear=" + birthYear +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }
}
