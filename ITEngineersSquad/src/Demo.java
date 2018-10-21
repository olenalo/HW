import java.time.LocalDate;

public class Demo {

    public static void main(String[] args) {

        OpsEngineer opsEngineer = new OpsEngineer(
                "Serge",
                "Pupsianov",
                LocalDate.of(2005, 5, 17),
                "Medium",
                "Medium",
                3000
                );
        System.out.println(opsEngineer.sayHi());
        System.out.println(opsEngineer.getRoleLevel());
        System.out.println("---------------------");

        SoftwareDeveloper developer = new SoftwareDeveloper(
                "Olesya",
                "Malinkova",
                LocalDate.of(2014, 5, 17),
                "Medium",
                "Medium",
                2000,
                "Pre-Intermediate",
                true
        );
        System.out.println(developer.sayHi());
        System.out.println(developer.getRoleLevel());
        System.out.println("---------------------");

        ManualQAEngineer manualQAEngineer = new ManualQAEngineer(
                "Marilyn",
                "Manson",
                LocalDate.of(2018, 5, 17),
                "High",
                "Medium",
                1500
        );
        System.out.println(manualQAEngineer.sayHi());
        System.out.println(manualQAEngineer.getRoleLevel());
        System.out.println("---------------------");

        AutomatedQAEngineer automatedQAEngineer = new AutomatedQAEngineer(
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
                "Michael",
                "Johnson",
                LocalDate.of(2008, 5, 17),
                "Medium",
                "Medium",
                8000,
                "Advanced"
        );
        System.out.println(techLead.sayHi());
        System.out.println(techLead.getRoleLevel());
        System.out.println("Reconsidering salary for " + automatedQAEngineer + "...");
        techLead.reconsiderRemunerationUSD(automatedQAEngineer, 2700);
        System.out.println("...it's USD " + automatedQAEngineer.getRemunerationValueUSD() + " now.");
        System.out.println("---------------------");

        // TODO: demonstrate `Task`, tasks estimation and approval (`approveTaskETA()`)

    }

}
