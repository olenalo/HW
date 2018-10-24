import java.time.LocalDate;

public class Demo {

    public static void main(String[] args) {

        SoftwareDeveloper developer = new SoftwareDeveloper(
                "duckTeamMember001",
                "Olesya",
                "Malinkova",
                LocalDate.of(2014, 5, 17),
                "Medium",
                "Pre-Intermediate",
                2000,
                "Medium",
                true
        );
        System.out.println(developer.sayHi());
        System.out.println(developer.getRoleLevel());
        System.out.println("---------------------");

        SoftwareDeveloper developer2 = new SoftwareDeveloper(
                "duckTeamMember002",
                "Lena",
                "Lenova",
                LocalDate.of(2013, 5, 17),
                "High",
                "Advanced",
                2100,
                "Medium",
                false
        );
        System.out.println(developer2.sayHi());
        System.out.println(developer2.getRoleLevel());
        System.out.println("---------------------");

        ManualQAEngineer manualQAEngineer = new ManualQAEngineer(
                "duckTeamMember003",
                "Marilyn",
                "Manson",
                LocalDate.of(2018, 5, 17),
                "High",
                "Intermediate",
                1500
        );
        System.out.println(manualQAEngineer.sayHi());
        System.out.println(manualQAEngineer.getRoleLevel());
        System.out.println("---------------------");

        AutomatedQAEngineer automatedQAEngineer = new AutomatedQAEngineer(
                "duckTeamMember004",
                "Denis",
                "Denisko",
                LocalDate.of(2017, 5, 17),
                "High",
                "Advanced",
                2500

        );
        System.out.println(automatedQAEngineer.sayHi());
        System.out.println(automatedQAEngineer.getRoleLevel());
        System.out.println("---------------------");

        TechLead techLead = new TechLead(
                "duckTeamMember005",
                "Michael",
                "Johnson",
                LocalDate.of(2008, 5, 17),
                "Medium",
                "Intermediate",
                8000,
                "High"
        );
        System.out.println(techLead.sayHi());
        System.out.println(techLead.getRoleLevel());
        System.out.println("Reconsidering salary for " + automatedQAEngineer + "...");
        techLead.reconsiderRemunerationUSD(automatedQAEngineer, 2700);
        System.out.println("...it's USD " + automatedQAEngineer.getRemunerationValueUSD() + " now.");
        System.out.println("---------------------");

        OpsEngineer opsEngineer = new OpsEngineer(
                "duckTeamMember006",
                "Serge",
                "Pupsianov",
                LocalDate.of(2005, 5, 17),
                "Medium",
                "Intermediate",
                3000
        );
        OpsEngineer opsEngineer2 = new OpsEngineer(
                "duckTeamMember007",
                "Mariam",
                "Bialik",
                LocalDate.of(2010, 5, 17),
                "Low",
                "Advanced",
                2800
        );
        System.out.println(opsEngineer.sayHi());
        System.out.println(opsEngineer.sayHi(opsEngineer2));
        System.out.println(opsEngineer.sayHi(automatedQAEngineer));
        System.out.println(opsEngineer.sayHi(developer));
        System.out.println(opsEngineer.getRoleLevel());
        System.out.println("---------------------");

        System.out.println("Ensure that comparison works; result of comparison of two engineers: " +
                opsEngineer.equals(opsEngineer2));
        System.out.println("---------------------");

        Task task1 = new Task(
                "Implement PushService client API",
                "Implement PushService client API. The DoD is attached,",
                "Backlog",
                "High"
        );
        Task task2 = new Task(
                "Implement Photo Gallery",
                "Implement the standard Photo Gallery.",
                "Backlog",
                "Low"
        );
        task1.setAssignee(developer);
        System.out.printf("Assignee of task '%s' is %s\n", task1, task1.getAssignee());
        developer.provideTaskETA(task1, 6);
        opsEngineer.provideTaskETA(task1, 3);
        developer.assignTask(task1, opsEngineer);
        System.out.println("Total ETA is: " + task1.getTotalEstimationHours() + " hours");
        techLead.approveTaskETA(task1);  // ...and this should be approved
        System.out.println("\n---------------------");

        // Show the case "don't wanna estimate this bullshit"
        task2.setAssignee(developer2);
        System.out.printf("Assignee of task '%s' is %s\n", task2, task2.getAssignee());
        developer2.provideTaskETA(task2, 10);
        // System.out.println(task2.getTotalEstimationHours());
        developer2.assignTask(task2, techLead);
        techLead.approveTaskETA(task2);
        System.out.println("\n---------------------");

    }

}
