public class Main {
    public static void main(String[] args) throws Exception {
        Model model = new Model();
        View view = new View();
        Control control = new Control(model, view);

        Bean b1 = new Bean();
        Bean b2 = new Bean();

        control.setBean(b1, "Valeria", "Bond", 23, "Right Bank 4/1", "0631234567");
        control.addPerson(b1);

        control.setBean(b2, "Tamara", "Bond", 43, "Right Bank 4/1", "0637654321");
        control.addPerson(b2);


    }
}