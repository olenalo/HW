import java.util.Random;

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

    public static Boolean checkArrayContains(String[] array, String value) {
        for (String v: array) {
            // FIXME: NullPointerException could occur here
            // because `v` can be null, after being assigned during array initialization
            if (v.equals(value)) {
                return true;
            }
        }
        return false;
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

    public String[] pickFreeTicketsWinners(String[] candidates, int winnersNumber) throws IllegalArgumentException {
        if (winnersNumber > candidates.length) {
            throw new IllegalArgumentException("Winners number should be smaller than candidates'");
        }
        String[] winners = new String[winnersNumber];
        Random random = new Random();
        for (int i = 0; i < winnersNumber; i++) {
            int n = random.nextInt(candidates.length);
            // Exclude a candidate who already won
            if (!checkArrayContains(winners, candidates[n])) {
                // FIXME: ArrayIndexOutOfBoundsException occurs here
                // because we continue iterating even when `i` is bigger than `winner`'s length
                // FIXME: also, prevent possible NullPointerException (no value should be `null`)
                winners[i] = candidates[n];
            }
        }

        return winners;
    }



}
