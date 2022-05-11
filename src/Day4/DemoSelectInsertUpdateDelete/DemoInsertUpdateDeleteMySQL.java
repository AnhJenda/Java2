package Day4.DemoSelectInsertUpdateDelete;

import java.sql.*;
import java.util.Scanner;

/*
    @author: Dinh Quang Anh
    Date   : 5/10/2022
    Project: Java2
*/
public class DemoInsertUpdateDeleteMySQL {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore",
                        "root", "");
                Statement stmt = conn.createStatement();
                ){
            // Đầu tiên in ra bảng category ban đầu
            String strSelect = "select * from category";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println("The records selected are:");
            int rowCount = 0;
            while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                int catID = rset.getInt("catID");
                String catName = rset.getString("catName");
                System.out.println(catID + "," + catName);
                ++rowCount;
            }

            // Demo Insert
            System.out.println("Demo Insert multiple record");
            String stmInsert = "insert into category values" + "('4', 'Loai 4')" + "('5', 'Loai 5')";
            System.out.println("The SQL statement is: " + stmInsert + "\n");
            int countInserted = stmt.executeUpdate(stmInsert);
            System.out.println(countInserted + " records inserted.\n");
            // In ra bảng category sau khi nhập thêm 2 dòng
            strSelect = "select * from category";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            rset = stmt.executeQuery(strSelect);
            System.out.println("The records selected are:");
            rowCount = 0;
            while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                int catID = rset.getInt("catID");
                String catName = rset.getString("catName");
                System.out.println(catID + "," + catName);
                ++rowCount;
            }

            // Đầu tiên in ra bảng book ban đầu
            strSelect = "select bookID, bookName, author from book";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            rset = stmt.executeQuery(strSelect);
            System.out.println("The records selected are:");
            rowCount = 0;
            while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                int catID = rset.getInt("catID");
                String catName = rset.getString("catName");
                System.out.println(catID + "," + catName);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);
            // Demo Insert partial record
            System.out.println("Demo Insert partial record");
            stmInsert = "insert into books (bookID, bookName, author) values ('4', 'Sach 4', 'Tac gia 4')";
            countInserted = stmt.executeUpdate(stmInsert);
            System.out.println(countInserted + " records inserted.\n");
            // in ra bảng book sau khi thêm một dòng nữa
            strSelect = "select bookID, bookName, author from book";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            rset = stmt.executeQuery(strSelect);
            System.out.println("The records selected are:");
            rowCount = 0;
            while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                int catID = rset.getInt("catID");
                String catName = rset.getString("catName");
                System.out.println(catID + "," + catName);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);

            // Demo Scanner Insert
            System.out.println("Demo Scanner Insert");
            Scanner in = new Scanner(System.in);
            System.out.println("Nhap bookId");
            int id = in.nextInt();
            in.nextLine();
            System.out.println("Nhap bookName");
            String bookName = in.nextLine();
            System.out.println("Nhap author");
            String author = in.nextLine();
            stmInsert = "insert  into books(bookID,bookName,author) values ('" + id + "','" + bookName +"','" + author + "')";
            countInserted =  stmt.executeUpdate(stmInsert);
            System.out.println(countInserted + " records inserted.\n");

            // Demo Delete
            String stmDelete = "delete from category where catID = 1";
            int countDeleted = stmt.executeUpdate(stmDelete);
            System.out.println(countInserted + " records deleted.\n");
            // select lại bảng category để check
            strSelect = "select * from category";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            rset = stmt.executeQuery(strSelect);
            System.out.println("The records selected are:");
            rowCount = 0;
            while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                int catID = rset.getInt("catID");
                String catName = rset.getString("catName");
                System.out.println(catID + "," + catName);
                ++rowCount;
            }

            // Demo Update
            String stmUpdate = "update category" + "set catID = 1" +  "where catID = 2";
            int countUpdated = stmt.executeUpdate(stmUpdate);
            System.out.println(countInserted + " records updated.\n");
            // In lại bảng category để check lại
            strSelect = "select * from category";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            rset = stmt.executeQuery(strSelect);
            System.out.println("The records selected are:");
            rowCount = 0;
            while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                int catID = rset.getInt("catID");
                String catName = rset.getString("catName");
                System.out.println(catID + "," + catName);
                ++rowCount;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
