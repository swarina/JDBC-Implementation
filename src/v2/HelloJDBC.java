package v2;

import java.sql.*;

public class HelloJDBC {
    public static void main(String[] args) {
        // Connect Database
        try {
            Connection connection = ConnectionFactory.getConnection();

            PreparedStatement statement = connection.prepareStatement("Select * from emp");
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getDouble(3));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
