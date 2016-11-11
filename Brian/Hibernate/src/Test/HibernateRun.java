package Test;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Brian on 11/5/16.
 */
public class HibernateRun {

    public static void main(String[] args) {
        EntityManagerFactory myManagerFactory =
                Persistence.createEntityManagerFactory("NewPersistenceUnit");

        // Stores user input
        Scanner input = new Scanner(System.in);

        String userInput;

        System.out.println("\nEnter a number from the list to perform an action: \n");

        // Loops through an option menu for the user to chose from
        String option = "";
        while(option != "0") {
            System.out.println("1 - Display student list\n" +
                    "2 - Add a student\n" +
                    "3 - Add a phone number\n" +
                    "4 - Add a phone number to a student\n" +
                    "5 - Display student list and their phone number\n" +
                    "6 - Remove a phone number from a student\n" +
                    "7 - Remove a phone number\n" +
                    "8 - Remove a student\n" +
                    "9 - Display phone number list\n" +
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
                    addPhoneToStudent(myManagerFactory, input);
                    break;
                case "5":
                    showStudentsWithPhones(myManagerFactory);
                    break;
                case "6":
                    removePhoneFromStudent(myManagerFactory, input);
                    break;
                case "7":
                    removePhone(myManagerFactory, input);
                    break;
                case "8":
                    removeStudent(myManagerFactory, input);
                    break;
                case "9":
                    showPhoneNumbers(myManagerFactory);
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

        // Creates a list of type "StudentEntity", queries the student table and
        // returns a list of all students
        List<StudentEntity> studentEntities =
                myEntityManager.createQuery("from StudentEntity").getResultList();

        System.out.println("\nList of students in the database:");
        System.out.println("\nID  |  Student Name" + "\n" + "----|---------------------");

        // Loops through each of the students found in the student table
        for (StudentEntity temp : studentEntities) {
            // Prints the names of all the students found in the student table
            System.out.println(temp.getStudent_id() + "   |  " + temp.getFirstName()
                                + " " + temp.getLastName());
        }

        System.out.println("\n");
        // Closes the transaction
        myEntityManager.close();
    }

    public static void addStudent(EntityManagerFactory myManagerFactory, Scanner input){
        // Creates an entity manager
        EntityManager myEntityManager = myManagerFactory.createEntityManager();
        // Begins a transaction
        myEntityManager.getTransaction().begin();

        System.out.println("First Name | Last Name");

        // Splits the first name and last name string by space
        String[] userInput = input.nextLine().split(" ");

        // Creates a new student.
        StudentEntity newStudent = new StudentEntity();

        // Set the first name and last name attributes from the user input
        newStudent.setFirstName(userInput[0]);
        newStudent.setLastName(userInput[1]);
        //newStudent.setStudentId(Integer.parseInt(userInput[2]));

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

    // Adds a phone record to the phone table.
    public static void addPhone(EntityManagerFactory myManagerFactory, Scanner input){
        // Creates an entity manager
        EntityManager myEntityManager = myManagerFactory.createEntityManager();
        // Begins a transaction
        myEntityManager.getTransaction().begin();

        // Prompts the user to type the phone number to add as new record in the database.
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

        // Prints a message that tells the user that the phone number was successfully added
        // to the database
        System.out.println("Phone number was successfully added");

        // Close transaction
        myEntityManager.close();
    }

    // Updates an existing phone number record to an existing student record
    // It creates a record where it relates a phone number to a student
    public static void addPhoneToStudent(EntityManagerFactory myManagerFactory, Scanner input){
        // Creates an entity manager
        EntityManager myEntityManager = myManagerFactory.createEntityManager();
        // Begins a transaction
        myEntityManager.getTransaction().begin();

        // Creates a list of students and stores the returned result from a query to get all the
        // student names from the student table
        List<StudentEntity> studentList =
                myEntityManager.createQuery("from StudentEntity").getResultList();

        // Prompts the user to type a number to select a student from the list displayed above.
        System.out.println("Select a student from the list:");
        // Prints a header for the student list to make it user friendly/readable
        System.out.println("\nNumber  |  Student Name" + "\n" + "--------|---------------------");

        // Creates a counter for the loop below
        int count = 0;

        // Loop through the student list
        for (StudentEntity temp : studentList) {
            System.out.println(count + "       |  " +temp.getFirstName() + " " + temp.getLastName());
            count++;
        }

        // Stores the user input of student selected that the
        // user wants to add the phone number to
        int studentSelected = input.nextInt();

        // Creates a new student
        StudentEntity aStudent;

        // Assigns the student selected from list to the new created student
        aStudent = studentList.get(studentSelected);

        // Creates a list of phone numbers and stores the returned result from a query to get all the
        // phone numbers from the phone table
        List<PhoneEntity> phoneList = myEntityManager.createQuery("from PhoneEntity ").getResultList();

        // Promtps the user to type a number to select which phone number will be added a the student
        System.out.println("Select the phone number to add to the student:");
        // Prints a header for the phone list to make it user friendly/readable
        System.out.println("\nID  |  Phone Number" + "\n" + "----|---------------------");
        // Reset counter to 0
        count = 0;

        // Loops through the phone list
        for (PhoneEntity temp : phoneList) {
            // Prints the counter and the phone rows from the phone list
            System.out.println(count + "   |  " + temp.getPhone());
            count++;
        }

        // Stores the user input selection of the
        // phone number to add to the student selected
        int phoneSelected = input.nextInt();

        // Creates a new phone number
        PhoneEntity aPhone;

        // Assigns the phone number selected from list to the new phone number
        aPhone = phoneList.get(phoneSelected);

        // Creates a new record.
        // Many to one table relationship
        RecordEntity aRecordEntity = new RecordEntity();

        // Adds new student to the many to one relationship
        aRecordEntity.setStudentEntity(aStudent);
        // Adds new phone to the many to one relationship
        aRecordEntity.setPhoneEntity(aPhone);

        // Adds the new student record to the database
        myEntityManager.persist(aRecordEntity);
        // Clears objects from the queue
        myEntityManager.flush();
        // Stores the changes to the database
        myEntityManager.getTransaction().commit();

        System.out.println("The phone number was successfully added to the student.");
        // Close transaction
        myEntityManager.close();
    }

    // Reads all the records from the name column in the student table
    public static void showStudentsWithPhones(EntityManagerFactory myManagerFactory){
        // Creates an entity manager
        EntityManager myEntityManager = myManagerFactory.createEntityManager();
        // Begins a transaction
        myEntityManager.getTransaction().begin();


        // Creates a list of type "StudentEntity", queries the student table and
        // returns a list of all students
        List<RecordEntity> recordEntities = myEntityManager.createQuery("from RecordEntity").getResultList();


        System.out.println("\nList of students in the database:");
        // Prints a header for the student record that contains the student name
        // and phone number associated to make it user-friendly/readable
        System.out.println("\nStudent Name        |  Phone Number" + "\n"
                + "--------------------|---------------");

        // Loops through each of the students found in the student table
        for (RecordEntity temp : recordEntities) {
            // Prints the names of all the students found in the student table
            System.out.println(temp.getStudentEntity().getFirstName() + " " +
                    temp.getStudentEntity().getLastName() + " " + temp.getPhoneEntity().getPhone());
        }

        System.out.println("\n");
        // Closes the transaction
        myEntityManager.close();
    }

    // Updates an existing record where it removes a phone number from a student
    // It disassociates a phone number to a student
    public static void  removePhoneFromStudent(EntityManagerFactory myManagerFactory, Scanner input){
        // Creates an entity manager
        EntityManager myEntityManager = myManagerFactory.createEntityManager();
        // Begins a transaction
        myEntityManager.getTransaction().begin();

        // List that stores the returned result of the student records from the query
        List<StudentEntity> studentList = myEntityManager.createQuery("from StudentEntity").getResultList();

        // Prompts the user to type a number to select a student from the list.
        System.out.println("Please select a student from the list:");

        // set the counter to 0
        int count = 0;

        // Loops through the student list that contains all the rows from the student table
        for (StudentEntity temp : studentList) {
            // Displays the counter, and the first name and last name values found in the student list.
            System.out.println(count + " " + temp.getFirstName() + " " + temp.getLastName());
            count++;
        }

        // Stores the student selected number from the user
        int studentSelected = input.nextInt();

        // Prompts the user to enter a number to selecet a car to be removed
        System.out.println("Please select the student you would like to remove the phone number from:");

        // Resets the counter to 0
        count = 0;

        // Stores all the phone number records found for the selected student from the user input which was returned by the
        // query
        List<RecordEntity> recordList = myEntityManager.createQuery("from RecordEntity WHERE studentEntity.id=:p").setParameter("p",studentList.get(studentSelected).getStudent_id()).getResultList();

        //Loops through the record list that contains all the phone numbers associated with
        // a specific student.
        for (RecordEntity temp : recordList) {
            // Prints the counter and the phone numbers found in the query result.
            System.out.println(count + " " + temp.getPhoneEntity().getPhone() + "\n");
            // Increments the counter.
            count++;
        }

        // Stores the phone selected from the user input
        int phoneSelected = input.nextInt();

        // Creates query to remove the foreign key relationship where the student ID and phone ID are equal to what user selected
        Query deleteQuery = myEntityManager.createQuery("delete RecordEntity where studentEntity.id=:p AND phoneEntity.id=:q").setParameter("p", studentList.get(studentSelected).getStudent_id()).setParameter("q", recordList.get(phoneSelected).getPhoneEntity().getPhone_id());

        // Executes the SQL statement to delete the records
        deleteQuery.executeUpdate();

        // Stores the changes to the database
        myEntityManager.getTransaction().commit();

        // Prints a message that tells the user that the phone number was removed from the student
        // successfully.
        System.out.println("Successfully removed phone from student");

        // Closes the transaction.
        myEntityManager.close();
    }

    // Deletes a phone number row from the phone table.
    public static void  removePhone(EntityManagerFactory myManagerFactory, Scanner input){
        // Creates an entity manager
        EntityManager myEntityManager = myManagerFactory.createEntityManager();
        // Begins a transaction
        myEntityManager.getTransaction().begin();

        // Stores the results returned by the query where it gets all the records from the
        // phone table.
        List<PhoneEntity> phoneList = myEntityManager.createQuery("from PhoneEntity").getResultList();

        // Prompts the user to type a number to select which phone number will be deleted.
        System.out.println("Please select the phone you would like to remove:");

        // Resets the counter to 0
        int count = 0;

        // Loops through the phone list that contains the rows from the phone table.
        for (PhoneEntity temp : phoneList) {
            // Prints a counter and all the rows from the phone table.
            System.out.println(count + " " + temp.getPhone() + "\n");
            // Increments the counter.
            count++;
        }

        // Stores the selected phone number by the user.
        int phoneSelected = input.nextInt();

        // Deletes the foreign key constraint in the many to one table (Phone table)
        Query delFKquery = myEntityManager.createQuery("delete RecordEntity where phoneEntity.id=:p").setParameter("p", phoneList.get(phoneSelected).getPhone_id());

        // Deletes the phone number row from the phone table that matched the phone selected by the user.
        Query deleteQuery = myEntityManager.createQuery(
                "DELETE PhoneEntity c WHERE c.id = :p").setParameter("p", phoneList.get(phoneSelected).getPhone_id());

        // Executes SQL updates statements to the phone table
        delFKquery.executeUpdate();
        deleteQuery.executeUpdate();

        // Stores the changes to the database.
        myEntityManager.getTransaction().commit();

        // Prints a message that tells the user that the phone was deleted successfully.
        System.out.println("Successfully deleted the phone");
    }

    // Deletes a student row from the student table.
    public static void  removeStudent(EntityManagerFactory myManagerFactory, Scanner input){
        // Creates an entity manager
        EntityManager myEntityManager = myManagerFactory.createEntityManager();
        // Begins a transaction
        myEntityManager.getTransaction().begin();

        // Stores the results returned by the query to get all the records from the student table.
        List<StudentEntity> studentList = myEntityManager.createQuery("from StudentEntity ").getResultList();

        // Prompts the user to type a number to select which student will be deleted.
        System.out.println("Please select the student you would like to remove:");

        // Resets the counter to 0
        int count = 0;

        // Loops through the student list that contains the records from the student table.
        for (StudentEntity temp : studentList) {
            // Prints all the rows from the student table.
            System.out.println(count + " " + temp.getFirstName() + " " + temp.getLastName() + "\n");
            // Increments the counter
            count++;
        }

        // Stores the student selected from the user input
        int studentSelected = input.nextInt();

        // Deletes the foreign key constraint in the many to one table (Phone)
        Query delFKquery = myEntityManager.createQuery("delete RecordEntity where studentEntity.id=:p").setParameter("p", studentList.get(studentSelected).getStudent_id());

        // Deletes the row from the student table that matched the student selected by the user.
        Query deleteQuery = myEntityManager.createQuery(
                "DELETE StudentEntity c WHERE c.id = :p").setParameter("p", studentList.get(studentSelected).getStudent_id());

        // Executes the SQL updates statements to the student table
        delFKquery.executeUpdate();
        deleteQuery.executeUpdate();

        // Stores the changes to the database.
        myEntityManager.getTransaction().commit();
        // Prints a message that tells the user that the student was deleted successfully.
        System.out.println("Successfully deleted the student");
    }


    // Reads all the records from the name column in the student table
    public static void showPhoneNumbers(EntityManagerFactory myManagerFactory){
        // Creates an entity manager
        EntityManager myEntityManager = myManagerFactory.createEntityManager();
        // Begins a transaction
        myEntityManager.getTransaction().begin();

        // Creates a list of type "StudentEntity", queries the student table and
        // returns a list of all students
        List<PhoneEntity> phoneEntities =
                myEntityManager.createQuery("from PhoneEntity ").getResultList();

        System.out.println("\nList of phone numbers in the database:");
        // Prints a header for the phone list to make it user-friendly/readable.
        System.out.println("\nID  |  Phone Number" + "\n" + "----|---------------------");

        // Loops through each of the students found in the student table
        for (PhoneEntity temp : phoneEntities) {
            // Prints the names of all the students found in the student table
            System.out.println(temp.getPhone_id() + "   |  " + temp.getPhone()
                    + "\n");
        }

        System.out.println("\n");
        // Closes the transaction
        myEntityManager.close();
    }
}

