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

        // FIXME total salaries, not current!
        System.out.println("#1. All employees, indicating total salary and title: ");
        //EmployeesPrintUtils.printListSalaryTitle(EmployeesApp.getAllEmployeesWithTitleTotalSalary());

        System.out.println("#2. Employees hired in specific year, indicating department and hire date: ");
        // EmployeesPrintUtils.printListDeptHiredSpecifiedYear(EmployeesApp.getEmployeesHiredInYear(2000)); // TODO user input

        System.out.println("#3. Raise salaries for selected employees and print results: ");
        // TODO do with a stored procedure e.g. https://stackoverflow.com/a/24799562
        // TODO user input
        double totalSalaryEarnedBoundary = 80000;  // FIXME select by total salaries, not current!
        double salaryRaise = 1000;
        System.out.println("Current salaries before the raise...");
        EmployeesPrintUtils.printListSalaryTitle(
                EmployeesApp.getSelectedEmployeesWithTitleCurrentSalary(totalSalaryEarnedBoundary)
        );
        EmployeesApp.updateEmployeesWithSalaryBySecificValue(totalSalaryEarnedBoundary, salaryRaise);
        System.out.println("Current salaries after the raise...");
        EmployeesPrintUtils.printListSalaryTitle(
                EmployeesApp.getSelectedEmployeesWithTitleCurrentSalary(totalSalaryEarnedBoundary)
        );
        // Print what's required
        EmployeesPrintUtils.printListSalaryTitle(EmployeesApp.getAllEmployeesWithTitleTotalSalary());

    }

}
