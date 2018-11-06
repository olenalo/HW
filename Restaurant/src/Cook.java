public class Cook extends Employee {

    public static final String position = "Cook";

    public Cook(String name, String surname) {
        super(name, surname);
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname + ", the " + position;
    }

}
