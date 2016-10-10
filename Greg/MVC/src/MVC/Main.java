package MVC;

public class Main {

    public static void main(String[] args) {
//        create view
        PalindromeView view = new PalindromeView();
//        create model
        PalindromeModel model = new PalindromeModel();

//        create controller and pass view and model into constructor
        PalindromeController controller = new PalindromeController(view, model);
    }
}
