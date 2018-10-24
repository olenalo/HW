import java.time.LocalDate;

public class OpsEngineer extends Engineer {
    public static String role = "DevOps Engineer";

    public OpsEngineer(
            String id,
            String name,
            String surname,
            LocalDate careerStartDate,
            String softSkillsLevel,
            String englishLevel,
            float remunerationValue) {
        super(id, name, surname, careerStartDate, softSkillsLevel, englishLevel, remunerationValue);
    }

    @Override
    public String toString() {
        return super.toString() + ", a " + role;
    }

    public String sayHi() {
        return super.sayHi() + ", and I truly love Ops!";
    }

    public String sayHi(OpsEngineer opsEngineer) {
        return super.sayHi() + ", my fellow " + opsEngineer.role + "! Nice to meet you, " + opsEngineer.getName();
    }

    public String sayHi(SoftwareDeveloper softwareDeveloper) {
        return super.sayHi() + ", and you are a " + softwareDeveloper.role +
                ", I see... OK, I will explain to you how it works, " + softwareDeveloper.getName();
    }

    public String sayHi(QAEngineer qaEngineer) {
        return super.sayHi() + ", and you are a " + qaEngineer.role +
                ", I see... I'm just doing Ops, you should probably talk to a developer, " + qaEngineer.getName();
    }

    public String getRoleLevel() {
        return super.getRoleLevel() + " " + role;
    }

}
