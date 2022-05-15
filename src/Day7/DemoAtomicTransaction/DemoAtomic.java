package Day7.DemoAtomicTransaction;

import java.sql.*;

/*
    @author: Dinh Quang Anh
    Date   : 5/15/2022
    Project: Java2
*/
public class DemoAtomic {
    public static void main(String[] args) throws SQLException {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/music", "root", "");
                ) {
            try {
                conn.setAutoCommit(false);
                String StmSelect = "select * from music";
                String StmUpdate = "update music set songID = ?, songName = ? where songID = ?";
                String StmDelete = "delete from music where songID = ?";
                PreparedStatement prpStmSelect = conn.prepareStatement(StmSelect);
                PreparedStatement prpStmUpdate = conn.prepareStatement(StmUpdate);
                PreparedStatement prpStmDelete = conn.prepareStatement(StmDelete);

                ResultSet rset = prpStmSelect.executeQuery();
                while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                    int songID = rset.getInt("songID");
                    String songName = rset.getString("songName");
                    String author = rset.getString("author");
                    int    releaseYear   = rset.getInt("releaseYear");
                    System.out.println(songID + ", " + songName + ", " + author + ", " + releaseYear);
                }
                conn.commit();
                prpStmUpdate.setInt(1, 2);
                prpStmUpdate.setString(2, "Bai hat 4");
                prpStmUpdate.setInt(3, 2);
                prpStmUpdate.executeUpdate();
                prpStmDelete.setInt(1, 1);
                prpStmDelete.executeUpdate();
                conn.commit();
            }catch (SQLException e){
                conn.rollback();
                e.printStackTrace();
            }
        }
    }
}
