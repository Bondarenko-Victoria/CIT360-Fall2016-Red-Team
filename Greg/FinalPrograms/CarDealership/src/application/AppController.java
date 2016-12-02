package application;

import cardealership.*;

import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by gvh574 on 11/30/2016.
 */
public class AppController {

    public static HashMap<String, CustomerHandler> customerRequest = new HashMap<String, CustomerHandler>();
    public static HashMap<String, ManagerHandler> managerRequest = new HashMap<String, ManagerHandler>();

    public AppController(){

        //I know this is hideous, any suggestions on how to improve this?
        customerRequest.put("1", new Make());
        customerRequest.put("5", new Model());
        customerRequest.put("4", new Warranty());
        customerRequest.put("2", new Car());
        managerRequest.put("10", new Make());
        managerRequest.put("11", new Model());
        managerRequest.put("12", new Color());
        managerRequest.put("13", new Car());
        managerRequest.put("14", new Car());
        managerRequest.put("15", new Make());
        managerRequest.put("16", new Model());
        managerRequest.put("17", new Car());
        managerRequest.put("18", new Color());
    }

    public String processRequest(String userInput, EntityManagerFactory emf, Scanner input){

        //I know this is hideous, any suggestions on how to improve this?
        if(!userInput.equals("0")) {
            CustomerHandler custRequest = customerRequest.get(userInput);
            ManagerHandler manRequest = managerRequest.get(userInput);
            switch(userInput){
                case "1":
                case "2":
                case "4":
                    custRequest.list(emf);
                    break;
                case "3":
                    processSearch(input, emf);
                    break;
                case "10":
                case "11":
                case "12":
                case "13":
                    manRequest.add(input, emf);
                    break;
                case "14":
                    manRequest.update(input, emf);
                    break;
                case "15":
                case "16":
                case "17":
                    manRequest.remove(input, emf);
                    break;
                default: break;

            } // end of switch statement
        }
        // end of if statement
        return userInput;
    } // end of processRequest function


    public void processSearch(Scanner input, EntityManagerFactory emf) {
        String make = "";
        String model = "";
        String car = "";

        make = customerRequest.get("1").search(input, emf);
        if (!make.equals("")){
            model = customerRequest.get("5").search(input, emf);
        }

        if (!model.equals("")){
            customerRequest.get("2").search(emf, make, model);
        }

        return;
    } // end of processSearch function






} // end of Application Controller
