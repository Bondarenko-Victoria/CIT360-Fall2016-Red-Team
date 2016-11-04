package Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class HibernateRunner {
    private List<Customer> customers;
    private List<CustomerPhone> phoneNumbers;
    private List<CustomerAddress> addresses;

    private HibernateConfig theHibernateUtility;

    public HibernateRunner(){
        theHibernateUtility = new HibernateConfig();
    }

    public static void main(String[] args){

        HibernateRunner hibernateTest = new HibernateRunner();

        Scanner input = new Scanner(System.in);
        String command = "";

        while(command != "0") {
            System.out.println("1 - Display customer list\n" +
                    "2 - Add new customer\n" +
                    "3 - Modify customer\n" +
                    "4 - Add shared phone number\n" +
                    "5 - Delete all customers\n" +
                    "6 - Delete all phone numbers\n" +
                    "7 - Delete a customer\n" +
                    "0 - Quit");

            String userInput = input.nextLine();

            switch (userInput) {
                case "1":
                    hibernateTest.showAllCustomers();
                    break;
                case "2":
                    hibernateTest.addNewCustomer();
                    break;
                case "3":
                    hibernateTest.modifyCustomer();
                    break;
                case "4":
                    hibernateTest.addSharedPhoneNumber();
                    break;
                case "5":
                    hibernateTest.deleteAddedCustomers();
                    break;
                case "6":
                    hibernateTest.deleteAllPhoneNumbers();
                    break;
                case "7":
                    hibernateTest.deleteACustomer();
                case "0":
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    // Add new customer records to the database.
    private void addNewCustomer() {
        Session session = theHibernateUtility.getCurrentSession();

        // Creates and starts a new transaction.
        Transaction transaction = session.beginTransaction();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first name: ");
        String fName = input.nextLine();
        System.out.println("Enter the last name: ");
        String lName = input.nextLine();
        System.out.println("Enter the phone number without dash lines: ");
        String cPhone = input.nextLine();
        System.out.println("Enter an address: ");
        String cAddress = input.nextLine();
        System.out.println("Enter a city: ");
        String cCity = input.nextLine();
        System.out.println("Enter a state: ");
        String cState = input.nextLine();
        System.out.println("Enter a zip code: ");
        String cZipCode = input.nextLine();

        // Create customer instances.
        Customer aCustomer = new Customer();
        aCustomer.setFirstName(fName);
        aCustomer.setLastName(lName);

        CustomerPhone aCustomerNumber = new CustomerPhone();
        aCustomerNumber.setPhone(cPhone);

        CustomerAddress aCustomerAddress = new CustomerAddress();
        aCustomerAddress.setStreetAddress(cAddress);
        aCustomerAddress.setCity(cCity);
        aCustomerAddress.setState(cState);
        aCustomerAddress.setZipCode(cZipCode);

        // Saves instances as records in the database
        session.save(aCustomer);
        session.save(aCustomerNumber);
        session.save(aCustomerAddress);
        transaction.commit();

        // Displays the new records added to the database and make sure they have a generated id
        System.out.println(aCustomer.getFirstName() + aCustomer.getLastName()
                +" generated ID: " + aCustomer.getId() + aCustomer.getCustomerPhone()
                + aCustomer.getCustomerAddress());
    }

    // Shows all records in the database
    private void showAllCustomers() {
        Session session = theHibernateUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        // Queries all the customers from the database
        Query allCustomersQuery = session.createQuery("from Customer");
        // Stores the result returned by the query
        customers = allCustomersQuery.list();
        // Displays the number of customers found in the database.
        System.out.println("Number of customers: " + customers.size());

        // Iterates over each customer record found in the database
        Iterator<Customer> customerIterator = customers.iterator();;
        while(customerIterator.hasNext()) {
            // Stores all the customers found
            Customer element = customerIterator.next();
            // Displays the customers found in Java String
            System.out.println(element.toString());
            // Displays the number of found numbers found
            System.out.println("Number of phone numbers: "
                    + element.getCustomerPhone().size());
        }
        // Stores the changes
        transaction.commit();
    }

    // Updates records
    private void modifyCustomer() {

        Session session = theHibernateUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Enter the first name");
        // Queries a single customer that matches the last name "Potter"
        Query singleCustomerQuery = session.createQuery("select c from Customer as c where c.lastName='Potter'");
        // Stores the result returned by the query
        Customer potterCustomer = (Customer)singleCustomerQuery.uniqueResult();
        // Changes the first name of the customer returned by the query from "Harry" to "Joshua"
        potterCustomer.setFirstName("Joshua");
        // Changes are ready to be stored
        session.merge(potterCustomer);
        // Stores the changes to the database
        transaction.commit();
        // Calls the showAllCustomers method to get all the customers to make sure the customer name was
        // updated
        showAllCustomers();
    }

    // Adds a share phone number to more than one customer
    private void addSharedPhoneNumber() {
        Session session = theHibernateUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        // Queries a customer that matches the first name "Joshua"
        Query joshuaQuery = session.createQuery("select c from Customer as c where c.firstName='Joshua'");
        // Stores the result returned by the query
        Customer joshuaCustomer = (Customer)joshuaQuery.uniqueResult();
        // Queries a customer that matches the first name "Brian"
        Query brianQuery = session.createQuery("select c from Customer as c where c.firstName='Brian'");
        // Stores the result returned by the query
        Customer brianCustomer = (Customer)brianQuery.uniqueResult();

        // Creates a shared phone number instance
        CustomerPhone sharedPhoneNumber = new CustomerPhone();
        // Adds a phone number to the instance
        sharedPhoneNumber.setPhone("(546)222-9898");

        // Stores all the phone numbers that belong to Joshua
        List<CustomerPhone> joshuaPhoneNumbers = joshuaCustomer.getCustomerPhone();
        // Adds a shared phone number to Joshua
        joshuaPhoneNumbers.add(sharedPhoneNumber);

        // Stores all the phone numbers that belong to Brian
        List<CustomerPhone> brianPhoneNumbers = brianCustomer.getCustomerPhone();
        // Adds a shared phone number to Brian
        brianPhoneNumbers.add(sharedPhoneNumber);

        // Tell the database that the changes are ready to be stored
        session.save(sharedPhoneNumber);

        // Tells the databse that the updated record instances are ready to be stored
        session.merge(joshuaCustomer);
        session.merge(brianCustomer);

        // Stores all the changes
        transaction.commit();
        // Calls the showAllCustomers method to make sure that the records were updated.
        showAllCustomers();
    }

    // Deletes records from the database
    private void deleteAddedCustomers() {
        Session session = theHibernateUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        // Stores the number of customer records found
        int numCustomers = customers.size();
        // Displays the number of customer records found
        System.out.println("Number of customers found: " + numCustomers);
        // Loops through each of the customer records found
        for(int i = 0; i < numCustomers; i++){
            // deletes all customers
            session.delete(customers.get(i));
        }
        // Stores the changes
        transaction.commit();

        // Makes sure there are no records found
        System.out.println(customers);
        // Clears all the instances
        customers.clear();
        // Makes sure all the instances and records were completely removed from the database.
        System.out.println(customers);
    }

    // Deletes records from the database
    private void deleteAllPhoneNumbers() {
        Session session = theHibernateUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        // Stores the number of customer records found
        int numPhoneNumbers = phoneNumbers.size();

        // Loops through each of the customer records found
        for(int i = 0; i < numPhoneNumbers; i++){
            session.delete(phoneNumbers.get(i));
        }
        // Stores the changes
        transaction.commit();

        // Makes sure there are no records found
        System.out.println(phoneNumbers);
        // Clears all the instances
        phoneNumbers.clear();
        // Makes sure all the instances and records were completely removed from the database.
        System.out.println(phoneNumbers);
    }

    private void deleteACustomer() {
        Session session = theHibernateUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        // Queries all the customers from the database
        Query allCustomersQuery = session.createQuery("from Customer");
        // Stores the result returned by the query
        customers = allCustomersQuery.list();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a customer name to delete: ");
        String customerToDelete = input.next();

        int numCustomers = customers.size();
        for(int i = 0; i < numCustomers; i++){
            //session.delete(customers.contains(customerToDelete));
            System.out.println(customers.get(i));
        }

        System.out.println(customers);
        // Stores the changes
        transaction.commit();

    }
}
