import employeesApp.EmployeesApp;

public class Demo {

    public static void main(String[] args) {
        System.out.println("All deps: " + EmployeesApp.getAllDepartments());
        System.out.println("All deps ordered: " + EmployeesApp.getAllOrderedDepartments("dept_name"));
    }

}
