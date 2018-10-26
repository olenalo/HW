public class JavaConference extends Conference {

    // Inspired by https://jeeconf.com/

    // e.g. https://pic.twitter.com/IHev4MuW0l
    private String techPuzzle;  // TODO could be numerous

    public JavaConference(String title, String organizer, String techPuzzle) {
        super(title, organizer);
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
