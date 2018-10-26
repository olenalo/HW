public class DataScienceConference extends Conference {

    // Inspired by https://octopusai.com.ua/

    // Exhibition area with innovative developments
    private String exhibitionArea;

    public DataScienceConference(String title, String organizer, String exhibitionArea) {
        super(title, organizer);
        this.exhibitionArea = exhibitionArea;
    }

    public String getExhibitionArea() {
        return this.exhibitionArea;
    }

    public void setExhibitionArea(String exhibitionArea) {
        this.exhibitionArea = exhibitionArea;
    }

}
