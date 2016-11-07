package HibernateExample;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Victoria on 22.10.2016.
 */

public class HibernateMain {
    public static void main(String[] args) {
        EntityManagerFactory managFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        Scanner scanner = new Scanner(System.in);
        String input;

        String command = null;
        while(command != "0") {
            System.out.println("\nType your command:\n" +
                    "1 - Look at list of books\n" +
                    "2 - Look at list of authors\n" +
                    "3 - Look at list of authors and their books\n" +
                    "4 - Add a book\n" +
                    "5 - Add an author\n" +
                    "6 - Add an author to a book\n" +
                    "7 - Remove a book\n" +
                    "8 - Remove an author\n" +
                    "9 - Remove an author from book\n" +
                    "0 - Exit\n");

            // Switch statement for looping
            input = scanner.nextLine();
            switch(input){
                case "1":
                    listBooks(managFactory);
                    break;

                case "2":
                    listAuthors(managFactory);
                    break;

                case "3":
                    listAuthorAndBooks(managFactory);
                    break;

                case "4":
                    addBook(managFactory, scanner);
                    break;

                case "5":
                    addAuthor(managFactory, scanner);
                    break;

                case "6":
                    //addAuthorToBook(managFactory, scanner);
                    break;

                case "7":
                    removeBook(managFactory, scanner);
                    break;

                case "8":
                    removeAuthor(managFactory, scanner);
                    break;

                case "9":
                    removeAuthorFromBook(managFactory, scanner);
                    break;

                case "0":
                    managFactory.close();
                    return;

                default:
                    break;
            }
        }


    }

    public static void listBooks(EntityManagerFactory managFactory){
        // Creates entity manager
        EntityManager em = managFactory.createEntityManager();
        // Begin transaction
        em.getTransaction().begin();

        System.out.println("Here is a list of all books in the database:");

        // Creates a list of "BookEntity"
        // Query database returns a list of all books
        List<BookEntity> be = em.createQuery("from BookEntity ").getResultList();

        System.out.println("Book Key ISBN // Book Title // Book Publisher // Book Year");
        // Iterates through a list (foreach loop)
        for (BookEntity x : be) {
            System.out.println(x.getBookKeyIsbn() + " // " + x.getBookTitle() + " // " + x.getBookPublisher() + " // " + x.getBookYear());
        }

        // Close transaction
        em.close();

    }

    public static void listAuthors(EntityManagerFactory managFactory){
        // Creates entity manager
        EntityManager em = managFactory.createEntityManager();
        // Begin transaction
        em.getTransaction().begin();

        System.out.println("Here is a list of all authors in the database:");

        // Creates a list of "AuthorEntity"
        // Query database returns a list of all authors
        List<AuthorEntity> be = em.createQuery("from AuthorEntity ").getResultList();

        System.out.println("Author Key // Author First Name // Author Last Name");
        // Iterates through a list (foreach loop)
        for (AuthorEntity x : be) {
            System.out.println(x.getAuthorKey() + " // " + x.getAuthorFirstName() + " // " + x.getAuthorLastName());
        }

        // Close transaction
        em.close();

    }


    public static void listAuthorAndBooks(EntityManagerFactory managFactory){
        // Creates entity manager
        EntityManager em = managFactory.createEntityManager();
        // Begin transaction
        em.getTransaction().begin();

        System.out.println("Here is a list of all authors and books in the database:");
        System.out.println("Author Key // Author First Name // Author Last Name //// Book Key ISBN // Book Title // Book Publisher // Book Year");

        // Creates list of BookAuthorEntity
        // to access both tables
        List<BookAuthorEntity> bookAuthor = em.createQuery("from BookAuthorEntity ").getResultList();
        // Loop through list
        for (BookAuthorEntity x: bookAuthor) {
            System.out.println(x.getAuthorEntity().getAuthorKey() + " // " + x.getAuthorEntity().getAuthorFirstName() + " // " + x.getAuthorEntity().getAuthorLastName() + " //// " +
                    + x.getBookEntity().getBookKeyIsbn() + " // " + x.getBookEntity().getBookTitle() + " // " +  x.getBookEntity().getBookPublisher() + " // " +  x.getBookEntity().getBookYear());

        }

        // Close transaction
        em.close();
    }

    public static void addBook(EntityManagerFactory managFactory, Scanner scanner){
        // Creates entity manager
        EntityManager em = managFactory.createEntityManager();
        // Begin transaction
        em.getTransaction().begin();

        System.out.println("Enter your information in this format:");
        System.out.println("Book Key ISBN // Book Title // Book Publisher // Book Year");
        // Takes input from user as string and split it at each "space"
        String[]input = scanner.nextLine().split(" ");
        // Creates new book
        BookEntity boen = new BookEntity();

        // Sets its attributes
        boen.setBookKeyIsbn(Integer.parseInt(input[0]));
        boen.setBookTitle(input[1]);
        boen.setBookPublisher(input[2]);
        boen.setBookYear(Integer.parseInt(input[3]));

        // Adds to PersistenceContext
        em.persist(boen);
        // Clears any objects from queue
        em.flush();
        // Commits changes to database
        em.getTransaction().commit();

        System.out.println("Your book was successfully added!");

        // Close transaction
        em.close();

    }

    public static void addAuthor(EntityManagerFactory managFactory, Scanner scanner){
        // Creates entity manager
        EntityManager em = managFactory.createEntityManager();
        // Begin transaction
        em.getTransaction().begin();

        System.out.println("Enter your information in this format:");
        System.out.println("Author Key // Author First Name // Author Last Name");
        // Takes input from user as string and split it at each "space"
        String[] authorName = scanner.nextLine().split(" ");
        // Creates new author
        AuthorEntity ae = new AuthorEntity();

        // Sets its attributes
        ae.setAuthorKey(Integer.parseInt(authorName[0]));
        ae.setAuthorFirstName(authorName[1]);
        ae.setAuthorLastName(authorName[2]);

        // Adds to PersistenceContext
        em.persist(ae);
        // Clears any objects from queue
        em.flush();
        // Commits changes to database
        em.getTransaction().commit();

        System.out.println("Your author was successfully added!");

        // Close transaction
        em.close();
    }

    /*
    public static void addAuthorToBook(EntityManagerFactory managFactory, Scanner scanner){
        // Creates entity Manager
        EntityManager em = managFactory.createEntityManager();
        // Begin transaction
        em.getTransaction().begin();

        System.out.println("Select author from the list:");

        // Creates list
        List<AuthorEntity> auen = em.createQuery("from AuthorEntity ").getResultList();

        // Creates counter
        int number = 0;

        // For each loop
        for (AuthorEntity x : auen) {
            System.out.println(number + " - " + x.getAuthorKey() + " " + x.getAuthorFirstName() + " " + x.getAuthorLastName());
            number++;
        }

        // Gets input
        int authorKey = scanner.nextInt();

        // Creates author
        AuthorEntity autent = new AuthorEntity();

        // Assign
        autent = auen.get(authorKey);


        // Creates list
        List<BookEntity> ben = em.createQuery("from BookEntity ").getResultList();

        System.out.println("Select book you want to add to your author:");

        number = 0;

        // For each loop
        for (BookEntity x : ben) {
            System.out.println(number + " - " + x.getBookKeyIsbn() + " " + x.getBookTitle() + " " + x.getBookPublisher() + " " + x.getBookYear());
            number++;
        }

        // Collect
        int bookKey = scanner.nextInt();

        // Creates
        BookEntity bookAuth = new BookEntity();

        // Assign
        bookAuth = ben.get(bookKey);


        // Creates
        BookAuthorEntity bae = new BookAuthorEntity();

        // Set attributes
        //System.out.println("Type an ID of your author:");
        //int id = scanner.nextInt();
        //bae.setId(id);
        bae.setAuthorEntity(autent);
        bae.setBookEntity(bookAuth);

        // Adds to PersistenceContext
        em.persist(bae);
        // Clears any objects from queue
        em.flush();
        // Commits changes to database
        em.getTransaction().commit();

        System.out.println("Author successfully added to a book!");

        // Close transaction
        em.close();
    }
    */

    public static void  removeBook(EntityManagerFactory managFactory, Scanner scanner){
        // Creates entity manager
        EntityManager em = managFactory.createEntityManager();
        // Begin transaction
        em.getTransaction().begin();

        // Creates list of books
        List<BookEntity> bookList = em.createQuery("from BookEntity ").getResultList();

        System.out.println("Please select the book you would like to remove:");

        // Set counter
        int count = 0;
        // Loop through list of books
        for (BookEntity temp : bookList) {
            System.out.println(count + ". " + temp.getBookKeyIsbn() + " " + temp.getBookTitle() + " " + temp.getBookPublisher() + " " + temp.getBookYear());
            count++;
        }

        // Collect user input
        int bookNum = scanner.nextInt();

        // First delete the foreign key constraint in the many to one table (BookAuthor)
        Query q = em.createQuery("delete BookAuthorEntity where bookEntity.id=:p").setParameter("p", bookList.get(bookNum).getBookKeyIsbn());

        // Then delete the actual book
        Query query = em.createQuery(
                "DELETE BookEntity c WHERE c.id = :p").setParameter("p", bookList.get(bookNum).getBookKeyIsbn());

        // Execute updates to table
        q.executeUpdate();
        query.executeUpdate();

        // Make changes
        em.getTransaction().commit();

        System.out.println("Successfully deleted book!");
    }


    public static void  removeAuthor(EntityManagerFactory managFactory, Scanner scanner){
        // Creates entity manager
        EntityManager em = managFactory.createEntityManager();
        // Begin transaction
        em.getTransaction().begin();

        // Creates list of authors
        List<AuthorEntity> authorList = em.createQuery("from AuthorEntity").getResultList();

        System.out.println("Please select the author you would like to remove:");

        // Set counter
        int count = 0;
        // Loop through author list
        for (AuthorEntity temp : authorList) {
            System.out.println(count + ". " + temp.getAuthorKey() + " " + temp.getAuthorFirstName() + " " + temp.getAuthorLastName());
            count++;
        }

        // Collects input from user
        int authorNum = scanner.nextInt();

        // First delete foreign key constraint from many to one table (BookAuthorEntity)
        Query q = em.createQuery("delete BookAuthorEntity where authorEntity.id=:p").setParameter("p", authorList.get(authorNum).getAuthorKey());

        // Then delete the actual author
        Query query = em.createQuery(
                "DELETE AuthorEntity c WHERE c.id = :p").setParameter("p", authorList.get(authorNum).getAuthorKey());

        // Execute updates to tables
        q.executeUpdate();
        query.executeUpdate();

        // Make changes
        em.getTransaction().commit();

        System.out.println("Successfully deleted author!");

        // Close transaction
        em.close();
    }

    public static void  removeAuthorFromBook(EntityManagerFactory managFactory, Scanner scanner){
        // Creates entity manager
        EntityManager em = managFactory.createEntityManager();
        // Begin transaction
        em.getTransaction().begin();

        // Query and create list
        List<AuthorEntity> authorList = em.createQuery("from AuthorEntity").getResultList();

        System.out.println("Please select your author:");

        // Set counter
        int count = 0;

        // Loop through list
        for (AuthorEntity temp : authorList) {
            System.out.println(count + ". " + temp.getAuthorKey() + " " + temp.getAuthorFirstName()  + " " + temp.getAuthorLastName());
            count++;
        }

        // Collect input from user
        int authorNum = scanner.nextInt();

        System.out.println("Please select the book you would like to remove the author from:");

        // Reset count to 0
        count = 0;

        // Query and create list
        List<BookAuthorEntity> bookAuthorList = em.createQuery("from BookAuthorEntity WHERE authorEntity.id=:p").setParameter("p",authorList.get(authorNum).getAuthorKey()).getResultList();

        // Loop through list
        for (BookAuthorEntity temp : bookAuthorList) {
            System.out.println(count + ". " + temp.getBookEntity().getBookKeyIsbn() + " " + temp.getBookEntity().getBookTitle() + " " + temp.getBookEntity().getBookPublisher() + " " + temp.getBookEntity().getBookYear());
            count++;
        }

        // Collect input from user
        int bookNum = scanner.nextInt();

        // Create query to remove foreign key relationship
        Query query = em.createQuery("delete BookAuthorEntity where authorEntity.id=:p AND bookEntity.id=:q").setParameter("p", authorList.get(authorNum).getAuthorKey()).setParameter("q", bookAuthorList.get(bookNum).getBookEntity().getBookKeyIsbn());

        // Execute query
        query.executeUpdate();
        // Makes changes
        em.getTransaction().commit();

        System.out.println("Successfully remove author from book!");
        // Close transaction
        em.close();
    }

}

/* NASTY PATHS */
//Some examples:
//- Foreign Key Constraint Errors
//- Variable Naming errors
//- Initial setup
//- Database connection issues
//- Table Relationship issues