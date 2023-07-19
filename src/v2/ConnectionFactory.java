package v2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionFactory {
    private static Connection connection;
    private ConnectionFactory(){}

    public static Connection getConnection() {
        // Load Properties
        String driver = null;
        String username = null;
        String url = null;
        String password = null;

        try {
            InputStream is = new FileInputStream("db.propertie");
            Properties props = new Properties();
            props.load(is);

            driver = props.getProperty("jdbc.driver");
            username = props.getProperty("jdbc.username");
            url = props.getProperty("jdbc.url");
            password = props.getProperty("jdbc.password");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Load Driver
        try {
            Class.forName(driver);
            System.out.println("Driver Loaded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Connect Database
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is done");

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("Select * from emp");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getDouble(3));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return connection;
    }
}
