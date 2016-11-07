package JavaBeans;

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

    // Adds hashCode and equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JavaBeansExample)) return false;

        JavaBeansExample that = (JavaBeansExample) o;

        if (getCatAge() != that.getCatAge()) return false;
        if (getCatWeight() != that.getCatWeight()) return false;
        return getCatName() != null ? getCatName().equals(that.getCatName()) : that.getCatName() == null;

    }

    @Override
    public int hashCode() {
        int result = getCatName() != null ? getCatName().hashCode() : 0;
        result = 31 * result + getCatAge();
        result = 31 * result + getCatWeight();
        return result;
    }
}