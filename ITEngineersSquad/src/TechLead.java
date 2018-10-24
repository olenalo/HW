import java.time.LocalDate;

public class TechLead extends SoftwareEngineer implements Manager {
    public static String role = "Technical Lead";

    public TechLead(
            String id,
            String name,
            String surname,
            LocalDate careerStartDate,
            String softSkillsLevel,
            String englishLevel,
            float remunerationValue,
            String selfEsteemLevel) {
        super(id, name, surname, careerStartDate, softSkillsLevel, englishLevel, remunerationValue, selfEsteemLevel);
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
        if (task.getTotalEstimationHours() > 0) {
            System.out.printf("OK, I approve the task '%s' ETA which is %f hours",
                    task, task.getTotalEstimationHours());
            return true;
        }
        System.out.printf("I do not approve the task's '%s' ETA which is %f hours, notifying the assignee %s...",
                task, task.getTotalEstimationHours(), task.getAssignee());
        return false;
    }

    @Override
    public void reconsiderRemunerationUSD(Engineer engineer, float newRemunerationUSD) {
        engineer.setRemunerationValueUSD(newRemunerationUSD);
    }
}
