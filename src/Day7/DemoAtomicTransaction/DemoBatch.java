package Day7.DemoAtomicTransaction;

/*
    @author: Dinh Quang Anh
    Date   : 5/15/2022
    Project: Java2
*/
import java.sql.*;
import java.util.Scanner;

public class DemoBatch {
    public static void main(String[] args) throws SQLException {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/music", "root", "");
                ){

            String insertStm = "insert into music(songID, songName) values (?, ?)";
            PreparedStatement prpstmInsert = conn.prepareStatement(insertStm);

            prpstmInsert.setInt(1, 2);
            prpstmInsert.setString(2, "bai hat 8");
            prpstmInsert.executeUpdate();
            prpstmInsert.setInt(1, 10);
            prpstmInsert.setString(2, "bai hat 10");
            prpstmInsert.executeUpdate();

            prpstmInsert.setInt(1, 5);
            prpstmInsert.setString(2, "bai hat 5");
            prpstmInsert.addBatch();
            prpstmInsert.setInt(1, 6);
            prpstmInsert.setString(2, "bai hat 6");
            prpstmInsert.addBatch();
            prpstmInsert.executeBatch();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
