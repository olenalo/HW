import dao.DepartmentDao;
import models.Department;

import java.util.List;

/**
 * Employee database CRUD app.
 * <p>
 * DB: https://github.com/datacharmer/test_db
 */
public class App {
    private static DepartmentDao deptDao;

    public static void main(String[] args) {
        deptDao = new DepartmentDao();
        List<Department> orderedDepartments = getAllOrderedDepartments("dept_name");
        System.out.println(orderedDepartments);
    }

    public static List<Department> getAllOrderedDepartments(String orderBy) {
        return deptDao.getAllOrdered(orderBy);
    }

}
