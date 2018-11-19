package BackToSchool.constants;

public enum Major {
    ELECTRICAL_ENGINEERING("Electrical Engineering"),
    COMMUNICATIONS("Communications"),
    UNDECLAREDFD("Undeclared");

    private String name;

    public String getName() {
        return name;
    }

    Major(String name) {
    }
}
