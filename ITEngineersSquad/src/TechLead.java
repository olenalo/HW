import java.time.LocalDate;

public class TechLead extends SoftwareEngineer implements Manager {
    public static String role = "Technical Lead";

    public TechLead(
            String name,
            String surname,
            LocalDate careerStartDate,
            String softSkillsLevel,
            String englishLevel,
            float remunerationValue,
            String selfEsteemLevel) {
        super(name, surname, careerStartDate, softSkillsLevel, englishLevel, remunerationValue, selfEsteemLevel);
    }

    @Override
    public String toString() {
        return super.toString() + ", a " + role;
    }

    public String sayHi() {
        return super.sayHi() + ", and yeah, I need to manage people :(";
    }

    public String getRoleLevel() {
        return super.getRoleLevel() + " " + role;
    }

    @Override
    public Boolean approveTaskETA(Task task) {
        // TODO: implement
        return false;
    }

    @Override
    public void reconsiderRemunerationUSD(Engineer engineer, float newRemunerationUSD) {
        engineer.setRemunerationValueUSD(newRemunerationUSD);
    }
}
