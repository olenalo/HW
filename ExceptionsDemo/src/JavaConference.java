public class JavaConference extends Conference {

    // Inspired by https://jeeconf.com/

    private String techPuzzle;

    public JavaConference(String title, String organizer, String techPuzzle, double price) {
        super(title, organizer, price);
        this.techPuzzle = techPuzzle;
    }

    public String getTechPuzzle() {
        return this.techPuzzle;
    }

    public void setTechPuzzle(String techPuzzle) {
        this.techPuzzle = techPuzzle;
    }

    public String showTechPuzzle() {
        return getTechPuzzle();
    }
}
