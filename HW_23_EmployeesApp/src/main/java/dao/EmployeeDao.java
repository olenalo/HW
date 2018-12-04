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
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
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
        String sql = "select * from employees order by ?";
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, orderBy);
            ResultSet rs = statement.executeQuery();
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

    public List<Employee> getAllWithTitleTotalSalary() {
        String sql = "select first_name, last_name, title, salary from employees\n" +
                "inner join salaries on employees.emp_no=salaries.emp_no\n" +
                "inner join titles on employees.emp_no=titles.emp_no\n" +
                "group by employees.emp_no";
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                employees.add(new Employee(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4)));
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
