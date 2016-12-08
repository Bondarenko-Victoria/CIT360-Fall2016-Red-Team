package folder;

import javax.persistence.*;

// product class was created for java objects to be used in the DB
@Entity
public class product {

    // "key" will be the Primary key of the object
    @Id
    @Column(name = "key")
    public int key;

    @Column(name="item")
    public String item;

    @Column(name="description")
    public String description;

    @Column(name="quantity")
    public int quantity;



    public int getKey(){
        return key;
    }

    public void setKey(int key){
        this.key = key;
    }

    public String getItem(){
        return item;
    }

    public void setItem(String item){
        this.item = item;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getQuantity(int quantity){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "Product [Key=" + key + ", Item="
                + item + ", Description=" + description
                + ", Quantity=" + quantity + "]";
    }
}