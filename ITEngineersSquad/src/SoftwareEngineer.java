import java.time.LocalDate;

public class SoftwareEngineer extends Engineer {

    private String selfEsteemLevel;  // TODO: make it Enum

    public SoftwareEngineer(
            String id,
            String name,
            String surname,
            LocalDate careerStartDate,
            String softSkillsLevel,
            String englishLevel,
            float remunerationValue,
            String selfEsteemLevel) {
        super(id, name, surname, careerStartDate, softSkillsLevel, englishLevel, remunerationValue);
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

    public void provideTaskETA(Task task, float estimationHours) {
        if (!task.getReqsQuality().equals("High") && !task.getReqsQuality().equals("Low")) { // "Medium"?
            System.out.println("Well, the requirements are not so good, but I'll estimate the task nevertheless...");
            super.provideTaskETA(task, estimationHours);
        } else if (task.getReqsQuality().equals("Low")) {
            if (this.getSelfEsteemLevel().equals("Low")) {
                System.out.println("Well, it's no good to work with such poor reqs... But what can I do... OK, will " +
                        "talk to the customer... Even though we have a BA... Should I take overtime?.. ");
                super.provideTaskETA(task, estimationHours);
            } else {
                System.out.println("Hey, go and talk to the Business Analyst! Let them clarify the requirements first! "
                        + "I'm not Business Analyst, for God's sake! No ETA from me can you get!");
            }
        }
        super.provideTaskETA(task, estimationHours);
    }
}
