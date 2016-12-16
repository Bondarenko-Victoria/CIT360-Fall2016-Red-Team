import java.util.*;

public class Control {
    private Model model;
    private View view;

    public Control(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public Bean getBean(String firstName) {
        return model.getPersonsByFirstName(firstName);
    }

    public void setBean(Bean bean, String firstName, String lastName, int age,
                        String address, String cellNumber) {
        bean.setFirstName(firstName);
        bean.setLastName(lastName);
        bean.setAge(age);
        bean.setAddress(address);
        bean.setCellNumber(cellNumber);
    }

    public void display() {
        view.show(model.getAllPersons());
    }

    public void addPerson(Bean person) {
        model.addPerson(person.getFirstName(), person);
        view.show(model.getAllPersons());
    }
}