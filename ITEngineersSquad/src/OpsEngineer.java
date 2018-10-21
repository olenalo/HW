import java.time.LocalDate;

public class OpsEngineer extends Engineer {
    public static String role = "DevOps Engineer";

    public OpsEngineer(
            String name,
            String surname,
            LocalDate careerStartDate,
            String softSkillsLevel,
            String englishLevel,
            float remunerationValue) {
        super(name, surname, careerStartDate, softSkillsLevel, englishLevel, remunerationValue);
    }

    @Override
    public String toString() {
        return super.toString() + ", a " + role;
    }

    public String sayHi() {
        return super.sayHi() + ", and I truly love Ops!";
    }

    public String getRoleLevel() {
        return super.getRoleLevel() + " " + role;
    }


}
