package utils;

import configs.Configs;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * MySQL connection pooling.
 */
public class DBCPDataSource {
    private static DBCPDataSource instance;
    private static BasicDataSource ds = new BasicDataSource();
    private static MySQLProperties mySqlProps = MySQLProperties.getInstance();

    static {
        ds.setUrl(mySqlProps.getUrl());
        ds.setUsername(mySqlProps.getUser());
        ds.setPassword(mySqlProps.getPassword());
        ds.setMinIdle(Configs.MIN_IDLE);
        ds.setMaxIdle(Configs.MAX_IDLE);
        ds.setMaxOpenPreparedStatements(Configs.MAX_OPEN_STATEMENTS);
    }

    public static DBCPDataSource getInstance() {
        if (instance == null) {
            instance = new DBCPDataSource();
        }
        return instance;
    }

    private DBCPDataSource() {
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
