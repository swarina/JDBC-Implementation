package v2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddEmployee {
    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("Insert into emp(name, salary) values(?,?)");
            statement.setString(1, "Anil");
            statement.setDouble(2, 67000);

            int noOfRowsEffected = statement.executeUpdate();
            System.out.println(noOfRowsEffected);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
