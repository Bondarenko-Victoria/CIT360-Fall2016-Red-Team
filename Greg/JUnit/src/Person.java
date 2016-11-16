import java.io.Serializable;

/**
 * Created by gvh57 on 10/6/2016.
 */
public class Person implements Serializable {
    private String name;
    private int age;
    private int streetNumber;
    boolean isDead;
    private int zipCode;

    Person(){
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

}
