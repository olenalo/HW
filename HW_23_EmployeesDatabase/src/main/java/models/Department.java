package models;

public class Department {
    String id;

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Department(String id, String name) {

        this.id = id;
        this.name = name;
    }

    String name;
}
