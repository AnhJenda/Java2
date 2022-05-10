package Day2.Task06;

/*
    @author: Dinh Quang Anh
    Date   : 5/5/2022
    Project: Java2
*/
import java.sql.*;
public class eBookStore {
    public static void main(String[] args) {
        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "");
            Statement stmt = conn.createStatement();
        ) {
            String strSelect = "select * from book where price > 50000";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println("The records selected are:");
            int rowCount = 0;
            while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                int bookID = rset.getInt("bookID");
                double price = rset.getDouble("price");
                String    bookName   = rset.getString("bookName");
                System.out.println(bookName + "," + bookID + "," + price);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
