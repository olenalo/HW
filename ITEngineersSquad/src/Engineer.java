import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Engineer {
    private String name;
    private String surname;
    private String softSkillsLevel; // TODO: make it Enum
    private String englishLevel;  // TODO: make it Enum
    private float remunerationValueUSD;
    private final LocalDate careerStartDate;

    public Engineer(
            String name,
            String surname,
            LocalDate careerStartDate,
            String softSkillsLevel,
            String englishLevel,
            float remunerationValueUSD) {
        this.name = name;
        this.surname = surname;
        this.careerStartDate = careerStartDate; // Ever, i.e. not only related to the current squad
        this.softSkillsLevel = softSkillsLevel;
        this.englishLevel = englishLevel;
        this.remunerationValueUSD = remunerationValueUSD;
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSoftSkillsLevel(String softSkillsLevel) {
        this.softSkillsLevel = softSkillsLevel;
    }

    public void setEnglishLevel(String englishLevel) {
        this.englishLevel = englishLevel;
    }

    public void setRemunerationValueUSD(float remunerationValueUSD) {
        this.remunerationValueUSD = remunerationValueUSD;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public LocalDate getCareerStartDate() {
        return this.careerStartDate;
    }

    public String getSoftSkillsLevel() {
        return this.softSkillsLevel;
    }

    public String getEnglishLevel() {
        return this.englishLevel;
    }

    public float getRemunerationValueUSD() {
        return this.remunerationValueUSD;
    }

    public String sayHi() {
        return "Hi, I'm " + this;
    }

    public int getExperienceMonths() {

        // Ref.: https://stackoverflow.com/a/21242111
        Date input = new Date();
        LocalDate now = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        if ((this.careerStartDate != null) && (now != null)) {
            return Period.between(this.careerStartDate, now).getYears() * 12 +
                    Period.between(this.careerStartDate, now).getMonths();
        } else {
            return 0;
        }
    }

    public String getRoleLevel() {
        String level = "Junior";
        int experienceMonths = this.getExperienceMonths();
        if (experienceMonths >= 24 && experienceMonths < 96) {
            level = "Middle";
        } else if (experienceMonths >= 96) {  // It takes 8 years :)
            level = "Senior";
        }
        return level;
    }


    public void assignTask(Task task, Engineer engineer) {

    }

    public void provideTaskETA(Task task, int estimation) {

    }
}
