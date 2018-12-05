import static employeesApp.EmployeesApp.getAllEmployeesWithTitleTotalSalary;
import static employeesApp.EmployeesApp.getEmployeesHiredInYear;
import static employeesApp.EmployeesApp.getAllEmployeesCurrentSalary;
import static employeesApp.EmployeesApp.updateEmployeesWithSalaryBySpecificValue;
import static utils.EmployeesPrintUtils.printListCurrentSalaryTitle;
import static utils.EmployeesPrintUtils.printListDeptHiredSpecifiedYear;
import static utils.EmployeesPrintUtils.printListTotalSalaryTitle;
import static utils.IOUtils.getHireYear;

public class Demo {

    public static void main(String[] args) {
        // Print first `limit` entries TODO consider passing to queries (conditionally)
        int limit = 3;  // Integer.MAX_VALUE;

        // System.out.println("\n------------------------------\nChecking departments...");
        // System.out.println("All deps: " + getAllDepartments());
        // System.out.println("All deps ordered: " + getAllOrderedDepartments("dept_name"));

        System.out.println("\n------------------------------\nChecking employees...");
        // System.out.println("All employees: " + getAllEmployees());
        // System.out.println("All employees ordered: " + getAllOrderedEmployees("last_name"));

        System.out.println("#1. All employees, indicating total salary and title: ");
        printListTotalSalaryTitle(getAllEmployeesWithTitleTotalSalary(), limit);

        System.out.println("#2. Employees hired in specific year, indicating department and hire date: ");
        int year = getHireYear();  // 2000
        printListDeptHiredSpecifiedYear(getEmployeesHiredInYear(year), limit);

        System.out.println("#3. Raise current salaries for selected employees and print results: ");
        double totalSalaryEarnedThreshold = 1000000;
        double salaryRaise = 1000;

        System.out.println("Current salaries before the raise..."); // debug purposes
        printListCurrentSalaryTitle(getAllEmployeesCurrentSalary(), limit);

        System.out.println("Updating selected employees' current salaries...");
        updateEmployeesWithSalaryBySpecificValue(totalSalaryEarnedThreshold, salaryRaise);

        System.out.println("Current salaries after the raise..."); // debug purposes
        printListCurrentSalaryTitle(getAllEmployeesCurrentSalary(), limit);

        // Print what's required
        System.out.println("Total salaries and titles...");
        printListTotalSalaryTitle(getAllEmployeesWithTitleTotalSalary(), limit);
    }
}
