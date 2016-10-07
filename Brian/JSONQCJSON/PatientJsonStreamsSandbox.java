/**
 * Created by Brian on 10/15/2015.
 */
/*
package Sandbox;
import org.quickconnectfamily.json.JSONOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;

public class PatientJsonStreamsSandbox implements Serializable {
    private String firstName;
    private String lastName;
    private String sex;
    private int age;
    private int id;
    private String phone;

    public PatientJsonStreamsSandbox(){};

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.name = firstName;
    }

     public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.name = lastName;
    }

     public String getSex(){
        return this.sex;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

     public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public static void main(String[] args) {

        PatientJsonStreamsSandbox patient1 =
                new PatientJsonStreamsSandbox("Bob", "Wood", "M", 30, 1, "123-456-7890");

        File patientList = new File("Patient.json");
            try {
                FileOutputStream patientListStream = new FileOutputStream(patientList);
                JSONOutputStream jsonOut = new JSONOutputStream(patientListStream);
                jsonOut.writeObject(patient1);
                jsonOut.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
*/