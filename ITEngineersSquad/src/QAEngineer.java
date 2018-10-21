import java.time.LocalDate;

public class QAEngineer extends Engineer {

    public static String role = "QA Engineer";

    public QAEngineer(
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
        return super.sayHi() + ". Please don't call me Tester! " +
                "And also, each QA engineer should be able to do both manual and automated testing! " +
                "But we still distinguish one from another here :(";
    }

}
