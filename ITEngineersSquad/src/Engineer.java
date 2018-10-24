import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class Engineer {
    private String id;
    private String name;
    private String surname;
    private String softSkillsLevel; // TODO: make it Enum
    private String englishLevel;  // TODO: make it Enum
    private float remunerationValueUSD;
    private final LocalDate careerStartDate;

    public Engineer(
            String id,
            String name,
            String surname,
            LocalDate careerStartDate,
            String softSkillsLevel,
            String englishLevel,
            float remunerationValueUSD) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        // Excluded "soft" attributes like remuneration or English level
        // (which also tend to change more often)
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engineer engineer = (Engineer) o;
        return Objects.equals(this.id, engineer.id) &&
                Objects.equals(this.name, engineer.name) &&
                Objects.equals(this.surname, engineer.surname) &&
                Objects.equals(this.careerStartDate, engineer.careerStartDate);
    }

    @Override
    public int hashCode() {
        // Excluded "soft" attributes like remuneration or English level
        // (which also tend to change more often)
        return Objects.hash(this.id, this.name, this.surname, this.careerStartDate);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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
        // TODO: make it Enum
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
        task.setAssignee(engineer);
    }

    public void provideTaskETA(Task task, float estimationHours) {
        task.addEstimationHours(estimationHours);
    }
}
