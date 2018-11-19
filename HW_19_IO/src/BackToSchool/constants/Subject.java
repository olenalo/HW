package BackToSchool.constants;

public enum Subject {
    COMPUTER_SCIENCE("Computer Science"),
    CHEMISTRY("Chemistry"),
    ENGLISH("English"),
    FRENCH("French"),
    SPANISH("Spanish"),
    BIOLOGY("Biology"),
    OTHER("Other");

    String name;

    Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                '}';
    }
}
