package homework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String url = "jdbc:mysql://localhost:3306/employees";
    private static final String user = "root";
    private static final String password = "123";

    public static void main(String[] args) {

        List<Department> departments = new ArrayList<>();
        final String sql = "select * from departments order by dept_name";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql);
        ) {
            while(rs.next()){
                departments.add(new Department(rs.getString(1), rs.getString(2)));
            }
            System.out.println(departments);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
