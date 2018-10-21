import java.time.LocalDate;

public class SoftwareDeveloper extends SoftwareEngineer {

    public static String role = "Software Developer";

    private Boolean leadershipAmbitions;

    public SoftwareDeveloper(
            String name,
            String surname,
            LocalDate careerStartDate,
            String softSkillsLevel,
            String englishLevel,
            float remunerationValue,
            String selfEsteemLevel,
            boolean leadershipAmbitions) {
        super(name, surname, careerStartDate, softSkillsLevel, englishLevel, remunerationValue, selfEsteemLevel);
        this.leadershipAmbitions = leadershipAmbitions;
    }

    @Override
    public String toString() {
        return super.toString() + ", a " + role;
    }

    public Boolean getLeadershipAmbitions() {
        return this.leadershipAmbitions;
    }

    public void setLeadershipAmbitions(Boolean leadershipAmbitions) {
        this.leadershipAmbitions = leadershipAmbitions;
    }

    public String sayHi() {
        return super.sayHi() + ", and I'm simply called a developer here.";
    }

    public String getRoleLevel() {
        return super.getRoleLevel() + " " + role;
    }

}
