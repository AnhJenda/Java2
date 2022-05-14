package Day5;

/*
    @author: Dinh Quang Anh
    Date   : 5/12/2022
    Project: Java2
*/
import java.sql.*;
public class JdbcCommitCatchTest {
    public static void main(String[] args) throws SQLException {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:8888/ebookshop", "myuser", "xxxx"); // MySQL
                Statement stmt = conn.createStatement();
        ) {
            try {
                conn.setAutoCommit(false);

// Before Changes
                ResultSet rset = stmt.executeQuery("select id, qty from books where id in (1001, 1002)");
                System.out.println("-- Before UPDATE --");
                while(rset.next()) {
                    System.out.println(rset.getInt("id") + ", " + rset.getInt("qty"));
                }
                conn.commit();     // Commit SELECT

// Issue two UPDATE statements thru executeUpdate()
                stmt.executeUpdate("update books set qty = qty + 1 where id = 1001");
                stmt.executeUpdate("update books set qty = qty + 1 where id = 1002");
                conn.commit();     // Commit UPDATEs

                rset = stmt.executeQuery("select id, qty from books where id in (1001, 1002)");
                System.out.println("-- After UPDATE and Commit --");
                while(rset.next()) {
                    System.out.println(rset.getInt("id") + ", " + rset.getInt("qty"));
                }
                conn.commit();     // Commit SELECT

// Issue two UPDATE statements thru executeUpdate()
                stmt.executeUpdate("update books set qty = qty - 99 where id = 1001");
                stmt.executeUpdate("update books set qty = qty - 99 where id = 1002");
                conn.rollback();   // Discard all changes since the last commit

                rset = stmt.executeQuery("select id, qty from books where id in (1001, 1002)");
                System.out.println("-- After UPDATE and Rollback --");
                while(rset.next()) {
                    System.out.println(rset.getInt("id") + ", " + rset.getInt("qty"));
                }
                conn.commit();     // Commit SELECT

            } catch(SQLException ex) {
                System.out.println("-- Rolling back changes --");
                conn.rollback();   // Rollback to the last commit.
                ex.printStackTrace();
            }
        }
    }
}
