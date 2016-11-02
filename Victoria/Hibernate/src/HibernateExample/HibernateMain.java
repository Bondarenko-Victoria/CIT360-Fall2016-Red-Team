package HibernateExample;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Victoria on 22.10.2016.
 */

public class HibernateMain {
    public static void main(String[] args) {
        EntityManagerFactory managFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entManag = managFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        entManag.getTransaction().begin();
        String input;


        String command = null;
        while(command != "0") {
            System.out.println("\nType your command?");
            System.out.println("1 - Look at list of books\n" +
                    "2 - Add a book\n" +
                    "3 - Look at list of authors and their books\n" +
                    "4 - Add an author\n" +
                    "5 - Add an author to a book\n" +
                    "6 - Remove a book\n" +
                    "7 - Remove an author\n" +
                    "0 - Exit\n");


            input = scanner.nextLine();
            switch(input){
                case "1":
                    selectBooks(entManag);
                    break;

                case "2":
                    addBook(entManag, scanner);
                    break;

                case "3":
                    listAuthorAndBooks(entManag);
                    break;

                case "4":
                    addAuthor(entManag, scanner);
                    break;

                case "5":
                    addAuthorToBook(entManag, scanner);
                    break;

                case "6":
//                    removeBook(entManag, scanner);
                    break;

                case "7":
//                    removeAuthor(entManag, scanner);
                    break;

                case "0":
                    entManag.close();
                    return;

                default:
                    break;
            }
        }


    }

    public static void selectBooks(EntityManager entManag){

        System.out.println("Here is a list of all books in the database:");

        // Creates a list of "BookEntity"
        // Query database returns a list of all books
        List<BookEntity> be = entManag.createQuery("from BookEntity ").getResultList();

        // Iterates through a list (foreach loop)
        for (BookEntity x : be) {
            System.out.println(x.getBookKeyIsbn() + " " + x.getBookPublisher() + " " + x.getBookTitle() + " " + x.getBookYear());
        }

    }

    public static void addBook(EntityManager entManag, Scanner scanner){
        System.out.println("Enter your information in this format");
        System.out.println("bookKeyIsbn // bookPublisher // bookTitle // bookYear");

        String[]input = scanner.nextLine().split(" ");

        BookEntity boen = new BookEntity();

        boen.setBookKeyIsbn(Integer.parseInt(input[0]));
        boen.setBookPublisher(input[1]);
        boen.setBookTitle(input[2]);
        boen.setBookYear(Integer.parseInt(input[3]));

        entManag.persist(boen);
        entManag.flush();
        entManag.getTransaction().commit();

        System.out.println("Your book was successfully added");

    }

    public static void listAuthorAndBooks(EntityManager entManag){
        System.out.println("authorKey // authorFirstName // authorLastName // bookKeyIsbn // bookPublisher // bookTitle // bookYear");

        List<BookAuthorEntity> bookAuthor = entManag.createQuery("from BookAuthorEntity ").getResultList();
        for (BookAuthorEntity x: bookAuthor) {
            System.out.println(x.getAuthorEntity().getAuthorKey() + " " + x.getAuthorEntity().getAuthorFirstName() + " " + x.getAuthorEntity().getAuthorLastName() + " " +
                    " " + x.getBookEntity().getBookKeyIsbn() + " " + x.getBookEntity().getBookPublisher() + " " + x.getBookEntity().getBookTitle() + " " +  x.getBookEntity().getBookYear());

        }
    }

    public static void addAuthor(EntityManager entManag, Scanner scanner){
        System.out.println("Enter your author's first and last name:");
        String[] authorName = scanner.nextLine().split(" ");

        AuthorEntity ae = new AuthorEntity();
        ae.setAuthorFirstName(authorName[0]);
        ae.setAuthorLastName(authorName[1]);

        entManag.persist(ae);
        entManag.flush();
        entManag.getTransaction().commit();

        System.out.println("Your author was successfully added");
    }

    public static void addAuthorToBook(EntityManager entManag, Scanner scanner){
        System.out.println("Select author from the list");

        List<AuthorEntity> auen = entManag.createQuery("from AuthorEntity ").getResultList();
        int number = 0;
        for (AuthorEntity x : auen) {
            System.out.println(number + ". " + x.getAuthorKey() + " " + x.getAuthorFirstName() + " " + x.getAuthorLastName());
            number++;
        }

        int authorNum = scanner.nextInt();

        AuthorEntity autent = new AuthorEntity();
        autent = auen.get(authorNum);



        List<BookEntity> ben = entManag.createQuery("from BookEntity ").getResultList();
        System.out.println("Select a book you want to add to an author:");
        number = 0;
        for (BookEntity x : ben) {
            System.out.println(number + ". " + x.getBookKeyIsbn() + " " + x.getBookPublisher() + " " + x.getBookTitle() + " " + x.getBookYear());
            number++;
        }

        int bookNum = scanner.nextInt();

        BookEntity bookAuth = new BookEntity();
        bookAuth = ben.get(bookNum);

        BookAuthorEntity bae = new BookAuthorEntity();
        bae.setAuthorEntity(autent);
        bae.setBookEntity(bookAuth);

        entManag.persist(bae);
        entManag.flush();
        entManag.getTransaction().commit();
        System.out.println("New author successfully added to a book");
    }


//    public static void  removeBook(EntityManager entManag, Scanner scanner){
//
//    }

//    public static void  removeAuthor(EntityManager entManag, Scanner scanner){
//
//    }

}