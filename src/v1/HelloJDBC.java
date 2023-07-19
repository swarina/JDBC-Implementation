package v1;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;

public class HelloJDBC {
    public static void main(String[] args) {
        // Load driver
//        try {
//            Class.forName("org.postgresql.Driver");
//            System.out.println("Driver is Loaded");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        // Create Database
//        try {
//            Connection connection = DriverManager.getConnection("", "", "");
//            System.out.println("Connection is done");
//
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("Select * from emp");
//            while(rs.next()) {
//                System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getDouble(3));
//            }
//
//        } catch(SQLException ex) {
//            ex.printStackTrace();
//        }
    }
}
