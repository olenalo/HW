import employeesApp.EmployeesApp;
import utils.EmployeesPrintUtils;

public class Demo {

    public static void main(String[] args) {
        /*
        System.out.println("\n------------------------------\nChecking departments...");
        System.out.println("All deps: " + EmployeesApp.getAllDepartments());
        System.out.println("All deps ordered: " + EmployeesApp.getAllOrderedDepartments("dept_name"));
        */

        /*
        System.out.println("\n------------------------------\nChecking employees...");
        System.out.println("All employees: " + EmployeesApp.getAllEmployees());
        System.out.println("All employees ordered: " + EmployeesApp.getAllOrderedEmployees("last_name"));
        */

        System.out.println("#1. All employees, indicating total salary and title: ");
        EmployeesPrintUtils.printListSalaryTitle(EmployeesApp.getAllEmployeesWithTitleTotalSalary());

        System.out.println("#2. Employees hired in specific year, indicating department and hire date: ");
        EmployeesPrintUtils.printListDeptHiredSpecifiedYear(EmployeesApp.getEmployeesHiredInYear(2000)); // TODO user input

    }

}
