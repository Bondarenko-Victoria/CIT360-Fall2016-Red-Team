package JSON_QCJSON.src.json;

/**
 * Created by Victoria on 10.10.2016.
 */

import java.io.Serializable;

// Implements Serializable
public class JSONBankExample implements Serializable {

    // Private attributes
    private String firstName;
    private String lastName;
    private String cardNumber;
    private String expiredDate;

    // Empty constructor
    public JSONBankExample(){}


    // Constructor with all parameters
    public JSONBankExample(String firstName, String lastName, String cardNumber, String expiredDate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardNumber = cardNumber;
        this.expiredDate = expiredDate;
    }

    // All getters and setters
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

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }
}