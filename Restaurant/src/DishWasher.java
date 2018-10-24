public class DishWasher extends Employee {

    public static final String position = "Dishwasher";

    public DishWasher(String name, String surname) {
        super(name, surname);
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname + ", the " + position;
    }

}
