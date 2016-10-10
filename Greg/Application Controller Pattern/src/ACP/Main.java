package ACP;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String type;

//        Create application controller
        AppController controller = new AppController();
        Scanner input = new Scanner(System.in);

        System.out.println("*****Welcome to Aptive Environmental*****");

        System.out.println("Are you a Customer, or a Sales Representative?");
        System.out.println("C = Customer");
        System.out.println("S = Sales Representative");

//        take input from user
        type = input.nextLine();

//        send it to controller
        controller.determineType(type);



    }
}
