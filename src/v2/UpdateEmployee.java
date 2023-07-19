package v2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployee {
    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("Update emp set salary = ? where id = ?");
            statement.setDouble(1, 100000);
            statement.setInt(2, 2);

            int noOfRowsEffected = statement.executeUpdate();
            System.out.println(noOfRowsEffected);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
