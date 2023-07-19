package v2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployee {
    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("Delete from emp where id = ?");
            statement.setInt(1, 5);

            int noOfRowsEffected = statement.executeUpdate();
            System.out.println(noOfRowsEffected);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
