public enum DishPreparationStep {

    ENVIRONMENT("Setting up the environment, heating the stove..."),
    INGREDIENTS("Preparing the ingredients, washing and slicing them..."),
    TECHNOLOGY("Preparing the dish with respect to the technology..."),
    UTENSIL("Putting the dish to plates, serving other utensil..."),
    DESIGN("Working on the dish design before to serve it to a customer...");

    String description;

    DishPreparationStep(String description) {
        this.description = description;
    }

}
