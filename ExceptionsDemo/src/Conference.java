public class Conference {

    private String title;
    private String organizer;
    private Workshop workshops;
    private Talk talks;

    @Override
    public String toString() {
        return this.title;
    }

    public Conference(String title, String organizer) {
        this.title = title;
        this.organizer = organizer;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Workshop getWorkshops() {
        return this.workshops;
    }

    public void setWorkshops(Workshop workshops) {
        this.workshops = workshops;
    }

    public Talk getTalks() {
        return this.talks;
    }

    public void setTalks(Talk talks) {
        this.talks = talks;
    }

    public int[] pickGivewayTicketsWinners() {
        int[] winnersNumbers = new int[5]; // TODO: move to constant
        // pseudo-random numbers will be generated here
        // TODO: ArrayIndexOutOfBoundsException, NullPointerException could happen here
        return winnersNumbers;
    }



}
