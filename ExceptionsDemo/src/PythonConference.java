public class PythonConference extends Conference {

    // Inspired by https://2018.uapycon.org/

    public PythonConference(String title, String organizer, double price) {
        super(title, organizer, price);
        this.setWorkshops(new String[] {"Django Girls"});
    }

}
