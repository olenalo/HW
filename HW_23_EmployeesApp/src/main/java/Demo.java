import employeesApp.EmployeesApp;
import utils.EmployeesPrintUtils;


public class Demo {

    public static void main(String[] args) {
        // Print first `limit` entries TODO consider passing to queries (conditionally)
        int limit = 3;  // Integer.MAX_VALUE;

        /*
        System.out.println("\n------------------------------\nChecking departments...");
        System.out.println("All deps: " + EmployeesApp.getAllDepartments());
        System.out.println("All deps ordered: " + EmployeesApp.getAllOrderedDepartments("dept_name"));
        */

        System.out.println("\n------------------------------\nChecking employees...");
        // System.out.println("All employees: " + EmployeesApp.getAllEmployees());
        // System.out.println("All employees ordered: " + EmployeesApp.getAllOrderedEmployees("last_name"));

        System.out.println("#1. All employees, indicating total salary and title: ");
        EmployeesPrintUtils.printListTotalSalaryTitle(EmployeesApp.getAllEmployeesWithTitleTotalSalary(), limit);

        System.out.println("#2. Employees hired in specific year, indicating department and hire date: ");
        // TODO user input
        int year = 2000;
        EmployeesPrintUtils.printListDeptHiredSpecifiedYear(EmployeesApp.getEmployeesHiredInYear(year), limit);

        System.out.println("#3. Raise current salaries for selected employees and print results: ");
        // TODO user input
        double totalSalaryEarnedThreshold = 1000000;
        double salaryRaise = 1000;

        System.out.println("Current salaries before the raise..."); // debug purposes
        EmployeesPrintUtils.printListCurrentSalaryTitle(EmployeesApp.getAllEmployeesCurrentSalary(), limit);

        System.out.println("Updating selected employees' current salaries...");
        EmployeesApp.updateEmployeesWithSalaryBySpecificValue(totalSalaryEarnedThreshold, salaryRaise);

        System.out.println("Current salaries after the raise..."); // debug purposes
        EmployeesPrintUtils.printListCurrentSalaryTitle(EmployeesApp.getAllEmployeesCurrentSalary(), limit);

        // Print what's required
        System.out.println("Total salaries and titles...");
        EmployeesPrintUtils.printListTotalSalaryTitle(EmployeesApp.getAllEmployeesWithTitleTotalSalary(), limit);
    }
}
