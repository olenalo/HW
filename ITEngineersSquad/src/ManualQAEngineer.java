import java.time.LocalDate;

public class ManualQAEngineer extends QAEngineer {

    public static String role = "Manual QA Engineer";

    public ManualQAEngineer(String id,
                            String name,
                            String surname,
                            LocalDate careerStartDate,
                            String softSkillsLevel,
                            String englishLevel,
                            float remunerationValue) {
        super(id, name, surname, careerStartDate, softSkillsLevel, englishLevel, remunerationValue);
    }

    public String sayHi() {
        return super.sayHi() + " So, I'm mostly focused on manual testing...";
    }

    public String getRoleLevel() {
        return super.getRoleLevel() + " " + role;
    }
}
