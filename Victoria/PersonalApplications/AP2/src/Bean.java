public class Bean {
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String cellNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    @Override
    public String toString() {
        return "\nBean{" +
                "First name='" + firstName + '\'' +
                ", Last Name=" + lastName +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", cellphone number='" + cellNumber + '\'' +
                '}' +
                "\n";
    }

    public Bean() {
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.address = "";
        this.cellNumber = "";
    }
}