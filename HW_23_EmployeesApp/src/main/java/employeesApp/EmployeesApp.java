package employeesApp;

import dao.DepartmentDao;
import dao.EmployeeDao;
import models.Department;
import models.Employee;

import java.util.List;

/**
 * Employee database CRUD app.
 * <p>
 * DB: https://github.com/datacharmer/test_db
 */
public class EmployeesApp {
    private static DepartmentDao deptDao = new DepartmentDao();
    private static EmployeeDao emplDao = new EmployeeDao();

    public static List<Department> getAllDepartments() {
        return deptDao.getAll();
    }

    public static List<Department> getAllOrderedDepartments(String orderBy) {
        return deptDao.getAllOrdered(orderBy);
    }

    public static List<Employee> getAllEmployees() {
        return emplDao.getAll();
    }

    public static List<Employee> getAllOrderedEmployees(String orderBy) {
        return emplDao.getAllOrdered(orderBy);
    }

    public static List<Employee> getAllEmployeesWithTitleTotalSalary() {
        return emplDao.getAllWithTitleTotalSalary();
    }

    public static List<Employee> getEmployeesHiredInYear(int year) {
        return emplDao.getEmployeesHiredInYear(year);
    }


    public static List<Employee> get() {
        return emplDao.getAllWithTitleTotalSalary();
    }

}
