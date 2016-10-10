package MVC;

import java.util.Scanner;

/**
 * Created by gvh57 on 10/7/2016.
 */
public class PalindromeView {
//    make scanner for input
    Scanner input = new Scanner(System.in);
//    store user input
    String userString;

//    print palindrome checker intro upon instance creation
    public PalindromeView() {
        System.out.println("**********************************");
        System.out.println("*******Palindrome Checker*********");
        System.out.println("Please enter in a word of your choice:");
        userString = input.nextLine();
    }

//    returns userString
    public String getUserString() {
        return userString;
    }


    public void isPalindrome(){
        System.out.println("Yes! This is a Palindrome.");
    }

    public void notPalindrome(){
        System.out.println("No! This is not a Palindrome.");
    }

}
