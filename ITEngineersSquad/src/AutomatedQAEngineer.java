import java.time.LocalDate;

public class AutomatedQAEngineer extends QAEngineer {

    public static String role = "Automated QA Engineer";

    public AutomatedQAEngineer(String id,
                               String name,
                               String surname,
                               LocalDate careerStartDate,
                               String softSkillsLevel,
                               String englishLevel,
                               float remunerationValue) {
        super(id, name, surname, careerStartDate, softSkillsLevel, englishLevel, remunerationValue);
    }

    public String sayHi() {
        return super.sayHi() + " So, I'm mostly focused on automated testing...";
    }

    public String getRoleLevel() {
        return super.getRoleLevel() + " " + role;
    }
}
