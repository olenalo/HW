import java.time.LocalDate;

public class SoftwareDeveloper extends SoftwareEngineer {

    public static String role = "Software Developer";

    private Boolean leadershipAmbitions;

    public SoftwareDeveloper(
            String id,
            String name,
            String surname,
            LocalDate careerStartDate,
            String softSkillsLevel,
            String englishLevel,
            float remunerationValue,
            String selfEsteemLevel,
            boolean leadershipAmbitions) {
        super(id, name, surname, careerStartDate, softSkillsLevel, englishLevel, remunerationValue, selfEsteemLevel);
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
        String helloMessage = super.sayHi() + ", and I'm simply called a developer here. ";
        if (this.getLeadershipAmbitions()) {
            helloMessage += "I want to become a Technical Lead one day";
        } else {
            helloMessage += "Ugh, don't want to manage people... Ever! Programming is my only passion!";
        }
        return helloMessage;
    }

    public String getRoleLevel() {
        return super.getRoleLevel() + " " + role;
    }

    public void provideTaskETA(Task task, float estimationHours) {
        if (this.getLeadershipAmbitions() && task.getReqsQuality().equals("Low")) {
            System.out.println("I'm gonna be a technical lead, and I should talk to the customer myself, " +
                    "I need this experience!");
            task.addEstimationHours(estimationHours);
        }
        super.provideTaskETA(task, estimationHours);
    }

}
