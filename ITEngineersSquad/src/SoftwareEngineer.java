import java.time.LocalDate;

public class SoftwareEngineer extends Engineer {

    private String selfEsteemLevel;  // TODO: make it Enum

    public SoftwareEngineer(
            String name,
            String surname,
            LocalDate careerStartDate,
            String softSkillsLevel,
            String englishLevel,
            float remunerationValue,
            String selfEsteemLevel) {
        super(name, surname, careerStartDate, softSkillsLevel, englishLevel, remunerationValue);
        this.selfEsteemLevel = selfEsteemLevel;
    }

    public void setSelfEsteemLevel(String selfEsteemLevel) {
        this.selfEsteemLevel = selfEsteemLevel;
    }

    public String getSelfEsteemLevel() {
        return this.selfEsteemLevel;
    }

    public String sayHi() {
        return super.sayHi() + ", I am passionate about Software Engineering";
    }

}
