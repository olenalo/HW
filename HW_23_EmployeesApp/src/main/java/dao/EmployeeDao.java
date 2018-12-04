package dao;

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
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Employee employee = new Employee(rs.getString(3), rs.getString(4));
                employee.setBirthDate(rs.getDate(2));
                employee.setId(rs.getString(1));
                employee.setGender(rs.getString(5));
                employee.setHireDate(rs.getDate(6));
                employees.add(employee);
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
                Employee employee = new Employee(rs.getString(3), rs.getString(4));
                employee.setBirthDate(rs.getDate(2));
                employee.setId(rs.getString(1));
                employee.setGender(rs.getString(5));
                employee.setHireDate(rs.getDate(6));
                employees.add(employee);
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
                Employee employee = new Employee(rs.getString(1), rs.getString(2));
                employee.setTitle(rs.getString(3));
                employee.setTotalSalaryEarned(rs.getDouble(4));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public List<Employee> getEmployeesHiredInYear(int year) {
        String sql = "select first_name, last_name, dept_name, hire_date from employees.employees\n" +
                "inner join employees.dept_emp on employees.employees.emp_no=employees.dept_emp.emp_no\n" +
                "inner join employees.departments on employees.departments.dept_no=employees.dept_emp.dept_no\n" +
                "where YEAR(employees.hire_date)=?";
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, year);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee(rs.getString(1), rs.getString(2));
                employee.setDepartment(rs.getString(3));
                employee.setHireDate(rs.getDate(4));
                employees.add(employee);
            }
            if (employees.isEmpty()) {
                System.out.println("No such employees found in the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public void updateEmployeesWithSalaryBySpecificValue(double filterTotalSalaryEarned,
                                                                   double salaryRaiseValue) {
        // Note: in the query below we use PK to avoid 1175 error, ref.: https://stackoverflow.com/a/28316067
        String sql = "update employees.salaries\n" +
                "inner join employees.employees on employees.salaries.emp_no=employees.employees.emp_no\n" +
                "set employees.salaries.salary=employees.salaries.salary+? \n" +
                "where employees.salaries.salary >= ? and employees.salaries.to_date='9999-01-01' \n" +
                "and employees.salaries.emp_no <> 0; ";  // FIXME fix the query (one gets a raise and the next one gets reduction)
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, salaryRaiseValue);
            statement.setDouble(2, filterTotalSalaryEarned);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
