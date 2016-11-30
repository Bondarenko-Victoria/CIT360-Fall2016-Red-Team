/**
 * Created by Victoria on 04.10.2016.
 */

import java.io.Serializable;

// implements Serializable interface
public class JavaBeansExample implements Serializable {

    // Private attributes
    private String catName;
    private int catAge;
    private int catWeight;

    // Public Constructor (without parameters or in other words empty)
    public JavaBeansExample() {
    }

    public JavaBeansExample(String catName, int catAge, int catWeight) {
        this.catName = catName;
        this.catAge = catAge;
        this.catWeight = catWeight;
    }


    // Accessors:
    // Getter for catName
    public String getCatName() {
        return this.catName;
    }

    // Setter for catName
    public void setCatName(String catName) {
        this.catName = catName;
    }

    // Getter for catAge
    public int getCatAge() {
        return this.catAge;
    }

    // Setter for catAge
    public void setCatAge(int catAge) {
        this.catAge = catAge;
    }

    // Getter for catWeight
    public int getCatWeight() {
        return this.catWeight;
    }

    // Setter for catWeight
    public void setCatWeight(int catWeight) {
        this.catWeight = catWeight;
    }

}