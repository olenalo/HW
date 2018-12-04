package dao;

import models.Department;
import models.Employee;
import utils.DBCPDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeDao implements Dao<Employee> {

    public EmployeeDao() {
    }

    @Override
    public Employee get(long id) {
        // TODO implement
        // return departments.get((int) id);  // TODO handle null
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Employee> getAll() {
        String sql = "select * from employees";  // TODO fetch other data (title, salary)
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)
        ) {
            while (rs.next()) {
                employees.add(new Employee(
                        rs.getString(1),
                        rs.getDate(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public List<Employee> getAllOrdered(String orderBy) {
        // TODO consider adding checks of `orderBy`
        // TODO use prepared statement here
        String sql = "select * from employees order by " + orderBy;
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)
        ) {
            while (rs.next()) {
                employees.add(new Employee(
                        rs.getString(1),
                        rs.getDate(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void save(Employee employee) {
        // TODO implement
        // employees.add(employee);
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Employee employee, String[] params) {
        // TODO implement
        /*
        employee.getFirstName(Objects.requireNonNull(
                params[0], "First name cannot be null"));
        employee.add(department);
        */
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Employee employee) {
        // TODO implement
        // employees.remove(employee);
        throw new UnsupportedOperationException();
    }
}
