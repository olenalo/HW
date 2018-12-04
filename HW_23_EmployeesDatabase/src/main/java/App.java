import models.Department;
import utils.MySQLProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Employees database CRUD app.
 * <p>
 * DB: https://github.com/datacharmer/test_db
 */
public class App {

    public static void main(String[] args) {
        MySQLProperties mySqlProps = MySQLProperties.getInstance();

        List<Department> departments = new ArrayList<>();
        final String sql = "select * from departments order by dept_name";
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
            System.out.println(departments);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
