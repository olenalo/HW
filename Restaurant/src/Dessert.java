public class Dessert implements Dish {

    public Dessert() {
        System.out.println("Cooking the dessert!");
    }

    @Override
    public void serve() {
        System.out.println("Serving the dessert!");
    }

}
