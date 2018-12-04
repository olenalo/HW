package dao;

import models.Department;
import utils.DBCPDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DepartmentDao implements Dao<Department> {

    public DepartmentDao() {
    }

    @Override
    public Department get(long id) {
        // TODO implement
        // return departments.get((int) id);  // TODO handle null
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Department> getAll() {
        String sql = "select * from departments";
        List<Department> departments = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                departments.add(new Department(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public List<Department> getAllOrdered(String orderBy) {
        String sql = "select * from departments order by ?";
        List<Department> departments = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, orderBy);
            ResultSet rs = statement.executeQuery();
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
