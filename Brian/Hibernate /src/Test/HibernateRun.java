package Test;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Brian on 11/5/16.
 */
public class HibernateRun {

    public static void main(String[] args) {
        EntityManagerFactory myManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");

        // Stores user input
        Scanner input = new Scanner(System.in);

        String userInput;

        // Loops through an option menu for the user to chose from
        String option = "";
        while(option != "0") {
            System.out.println("1 - Display student list\n" +
                    "2 - Add a student\n" +
                    "3 - Add a phone number\n" +
                    "4 - Add a phone number to a student\n" +
                    "5 - Display student list and their phone number\n" +
                    "6 - Remove a student\n" +
                    "7 - Remove a phone number\n" +
                    "8 - Remove a phone number from a student\n" +
                    "0 - Quit\n");

            // Assigns the user input stored to use for as commands
            userInput = input.nextLine();

            // Switch statement to loop for command given by the user to call a method
            switch(userInput){
                case "1":
                    showStudents(myManagerFactory);
                    break;
                case "2":
                    addStudent(myManagerFactory, input);
                    break;
                case "3":
                    addPhone(myManagerFactory, input);
                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":

                    break;
                case "8":

                    break;
                case "0":
                    System.exit(0);
                default:
                    break;
            }
        }

    }

    // Reads all the records from the name column in the student table
    public static void showStudents(EntityManagerFactory myManagerFactory){
        // Creates an entity manager
        EntityManager myEntityManager = myManagerFactory.createEntityManager();
        // Begins a transaction
        myEntityManager.getTransaction().begin();

        System.out.println("List of students in the database:");

        // Creates a list of type "StudentEntity", queries the student table and
        // returns a list of all students
        List<StudentEntity> studentEntities =
                myEntityManager.createQuery("from StudentEntity").getResultList();

        // Loops through each of the students found in the student table
        for (StudentEntity temp : studentEntities) {
            // Prints the names of all the students found in the student table
            System.out.println(temp.getFirstName() + " " + temp.getLastName());
        }
        // Closes the transaction
        myEntityManager.close();
    }

    public static void addStudent(EntityManagerFactory myManagerFactory, Scanner input){
        // Creates an entity manager
        EntityManager myEntityManager = myManagerFactory.createEntityManager();
        // Begins a transaction
        myEntityManager.getTransaction().begin();

        System.out.println("First Name | Last Name | Student ID");

        // Splits the first name and last name string by space
        String[] userInput = input.nextLine().split(" ");

        // Creates a new student.
        StudentEntity newStudent = new StudentEntity();

        // Set the first name, last name, and student ID attributes from the user input
        newStudent.setFirstName(userInput[0]);
        newStudent.setLastName(userInput[1]);
        newStudent.setStudentId(Integer.parseInt(userInput[2]));

        // Adds new student to the student table
        myEntityManager.persist(newStudent);
        // Clears any objects from the queue
        myEntityManager.flush();
        // Stores the changes to the student database
        myEntityManager.getTransaction().commit();

        System.out.println("Student was successfully added");

        // Close transaction
        myEntityManager.close();
    }

    public static void addPhone(EntityManagerFactory myManagerFactory, Scanner input){
        // Creates an entity manager
        EntityManager myEntityManager = myManagerFactory.createEntityManager();
        // Begins a transaction
        myEntityManager.getTransaction().begin();

        System.out.println("Enter a phone number using this format (xxx)xxx-xxxx or xxx-xxx-xxxx: ");

        // Stores the phone number from the user input
        String phone = input.nextLine();

        // Creates a new phone number
        PhoneEntity newPhone = new PhoneEntity();

        // Set the phone number from the user input
        newPhone.setPhone(phone);

        // Adds new phone number to the phone table
        myEntityManager.persist(newPhone);
        // Clears any objects from the queue
        myEntityManager.flush();
        // Stores the changes to the student database
        myEntityManager.getTransaction().commit();

        System.out.println("Phone number was successfully added");

        // Close transaction
        myEntityManager.close();
    }

    public static void addPhoneToStudent(EntityManagerFactory myManagerFactory, Scanner input){
        // Creates an entity manager
        EntityManager myEntityManager = myManagerFactory.createEntityManager();
        // Begins a transaction
        myEntityManager.getTransaction().begin();

        System.out.println("Select a student from the list");

        // Creates a list of students and stores the returned result from a query to get all the
        // student names from the student table
        List<StudentEntity> studentList =
                myEntityManager.createQuery("from StudentEntity").getResultList();

        // Creates a counter for the loop below
        int count = 0;

        // Loop through the student list
        for (StudentEntity temp : studentList) {
            System.out.println(count + ". " +temp.getFirstName() + " " + temp.getLastName());
            count++;
        }

        // Stores the user input of student selected that the
        // user wants to add the phone number to
        int numStudents = input.nextInt();

        // Creates a new student
        StudentEntity newStudent = new StudentEntity();

        // Assigns the student selected from list to the new created student
        newStudent = studentList.get(numStudents);

        // Creates a list of phone numbers and stores the returned result from a query to get all the
        // phone numbers from the phone table
        List<PhoneEntity> phoneList = myEntityManager.createQuery("from PhoneEntity ").getResultList();

        System.out.println("Select the phone number to add to the student");

        // Reset counter to 0
        count = 0;

        // Loops through the phone list
        for (PhoneEntity temp : phoneList) {
            System.out.println(count + ". " + temp.getPhone());
            count++;
        }

        // Stores the user input selection of the
        // phone number to add to the student selected
        int numPhones = input.nextInt();

        // Creates a new phone number
        PhoneEntity newPhone = new PhoneEntity();

        // Assigns the phone number selected from list to the new phone number
        newPhone = phoneList.get(numPhones);

        // Creates a new record.
        // Many to one table relationship
        RecordEntity newRecordEntity = new RecordEntity();
        // Sets attributes to the new record
        newRecordEntity.setStudentEntity(newStudent); // Adds new student to the many to one relationship
        newRecordEntity.setPhoneEntity(newPhone); // - Adds new phone to the many to one relationship

        // Adds the new student record to the database
        myEntityManager.persist(newRecordEntity);
        // Clears objects from the queue
        myEntityManager.flush();
        // Stores the changes to the database
        myEntityManager.getTransaction().commit();

        System.out.println("The phone number was successfully added to the student.");
        // Close transaction
        myEntityManager.close();
    }

}
