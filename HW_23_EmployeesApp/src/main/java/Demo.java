import employeesApp.EmployeesApp;

public class Demo {

    public static void main(String[] args) {
        System.out.println("\n------------------------------\nChecking departments...");
        System.out.println("All deps: " + EmployeesApp.getAllDepartments());
        System.out.println("All deps ordered: " + EmployeesApp.getAllOrderedDepartments("dept_name"));

        System.out.println("\n------------------------------\nChecking employees...");
        System.out.println("All employees: " + EmployeesApp.getAllEmployees());

    }

}
