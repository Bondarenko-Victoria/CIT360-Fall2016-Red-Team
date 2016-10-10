package MVC;

/**
 * Created by gvh57 on 10/7/2016.
 */
public class PalindromeController {

    public PalindromeController(PalindromeView view, PalindromeModel model) {

//        pass return value of the view into the model
        model.isPal(view.getUserString());

//        logic to display whether string was palindrome or not
        if(model.isPalindrome()){
            view.isPalindrome();
        }else{
            view.notPalindrome();
        }

    }

}
