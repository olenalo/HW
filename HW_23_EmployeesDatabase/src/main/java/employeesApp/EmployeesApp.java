package employeesApp;

import dao.DepartmentDao;
import models.Department;

import java.util.List;

/**
 * Employee database CRUD app.
 * <p>
 * DB: https://github.com/datacharmer/test_db
 */
public class EmployeesApp {
    private static DepartmentDao deptDao = new DepartmentDao();

    public static List<Department> getAllDepartments() {
        return deptDao.getAll();
    }

    public static List<Department> getAllOrderedDepartments(String orderBy) {
        return deptDao.getAllOrdered(orderBy);
    }

}
