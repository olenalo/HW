public class Soup implements Dish {

    public Soup() {
        System.out.println("Cooking the soup!");
    }

    @Override
    public void serve() {
        System.out.println("Serving the soup!");
    }

}
