package qcJSON;

import java.io.Serializable;


public class Person implements Serializable {

    private int age;
    private String phone;
    private String firstName;
    private String lastName;

    public Person(){}

    public Person(int age, String phone, String fName, String lName)
    {
        this.age = age;
        this.phone = phone;
        this.firstName = fName;
        this.lastName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
