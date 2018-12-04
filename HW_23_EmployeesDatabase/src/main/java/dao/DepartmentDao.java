package dao;

import models.Department;
import utils.MySQLProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DepartmentDao implements Dao<Department> {
    private List<Department> departments = new ArrayList<>();
    private MySQLProperties mySqlProps;

    public DepartmentDao() {
        mySqlProps = MySQLProperties.getInstance();
    }

    @Override
    public Department get(long id) {
        // TODO implement
        // return departments.get((int) id);  // TODO handle null
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Department> getAll() {
        // TODO implement
        // return departments;
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Department> getAllOrdered(String orderBy) {
        // TODO consider adding checks of `orderBy`
        // TODO use prepared statement here
        String sql = "select * from departments order by " + orderBy;
        try (Connection connection = DriverManager.getConnection(
                mySqlProps.getUrl(),
                mySqlProps.getUser(),
                mySqlProps.getPassword());
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)
        ) {
            while (rs.next()) {
                departments.add(new Department(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public void save(Department department) {
        // TODO implement
        // departments.add(department);
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Department department, String[] params) {
        // TODO implement
        /*
        department.setName(Objects.requireNonNull(
                params[0], "Name cannot be null"));
        departments.add(department);
        */
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Department department) {
        // TODO implement
        // departments.remove(department);
        throw new UnsupportedOperationException();
    }
}
