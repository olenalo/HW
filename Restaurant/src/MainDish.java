public class MainDish implements Dish {

    public MainDish() {
        System.out.println("Cooking the main dish!");
    }

    @Override
    public void serve() {
        System.out.println("Serving the main dish!");
    }

}
