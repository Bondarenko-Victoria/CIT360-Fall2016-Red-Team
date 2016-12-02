package application;

import cardealership.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gvh574 on 11/29/2016.
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        AppController controller = new AppController();
        Scanner input = new Scanner(System.in);

        String userInput = "";

        System.out.println("\nWelcome to the Rexburg Woody Dealership\n" +
                "\nMy name is Jarvis. How may I assist you?\n\n");

        while(!userInput.equals("0")) {
            System.out.println("I want to:\n" +
                    "1 - List all vehicle brands\n" +
                    "2 - List all vehicles\n" +
                    "3 - Search for vehicle\n" +
                    "4 - See brand warranty information\n" +
                    "9 - Manager Menu\n" +
                    "0 - Quit\n");

//SWITCH STATEMENT TO LOOP THROUGH AVAILABLE COMMANDS
            userInput = input.nextLine();

            if(userInput.equals("9")){
                System.out.println("Manager Menu\n" +
                        "I want to:\n" +
                        "10 - Add Make\n" +
                        "11 - Add Model\n" +
                        "12 - Add Color\n" +
                        "13 - Add Car \n" +
                        "14 - Update Car\n" +
                        "15 - Remove Make\n" +
                        "16 - Remove Model\n" +
                        "17 - Remove Car\n" +
                        "0 - Quit\n");
                userInput = input.nextLine();
            }


            userInput = controller.processRequest(userInput, emf, input);

        } //end of large while loop


    } //end of main
    } //end of class
