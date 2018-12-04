package utils;

import configs.Configs;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class MySQLProperties {

    private static MySQLProperties instance;
    private String user;
    private String url;
    private String password;

    private MySQLProperties() {
        setPropValues();
    }

    public static MySQLProperties getInstance() {
        if (instance == null) {
            instance = new MySQLProperties();
        }
        return instance;
    }

    private void setPropValues() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(Configs.mySqlPropFileName)) {
            Properties properties = new Properties();
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("Property file '" + Configs.mySqlPropFileName + "' is not found.");
            }
            this.user = properties.getProperty("user");
            this.url = properties.getProperty("url");
            this.password = properties.getProperty("password");
            System.out.println("MySQL Properties = " + user + ", " + url + ", " + password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUser() {
        return user;
    }

    public String getUrl() {
        return url;
    }

    public String getPassword() {
        return password;
    }
}
