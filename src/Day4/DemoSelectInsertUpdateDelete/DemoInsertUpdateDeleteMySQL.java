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
            // Demo Insert
            System.out.println("Demo Insert nhieu ban ghi");
            String stmMultipleInsert = "insert into category values" + "('10', 'Loai 10')," + "('11', 'Loai 11')";
            System.out.println("The SQL statement is: " + stmMultipleInsert + "\n");
            int countMultipleInsert = stmt.executeUpdate(stmMultipleInsert);
            System.out.println(countMultipleInsert + " ban ghi da insert.\n");
            // Demo Insert 1 phan cua ban ghi
            System.out.println("Demo Insert 1 phan cua ban ghi");
            String stmParticalInsert = "insert into book(bookID, bookName, author) values ('1', 'Sach 1', 'Tac gia 1')";
            int countParticalInserted = stmt.executeUpdate(stmParticalInsert);
            System.out.println(countParticalInserted + " ban ghi da insert.\n");
            // Demo Scanner Insert
            System.out.println("Demo Scanner Insert");
            Scanner in = new Scanner(System.in);
            System.out.println("Nhap bookId");
            Integer id = in.nextInt();
            in.nextLine();
            System.out.println("Nhap bookName");
            String bookName = in.nextLine();
            System.out.println("Nhap author");
            String author = in.nextLine();
            String stmScannerInsert = "insert  into book(bookID,bookName,author) values ('" + id + "','" + bookName +"','" + author + "')";
            int countScannerInserted =  stmt.executeUpdate(stmScannerInsert);
            System.out.println(countScannerInserted + " ban ghi da insert.\n");

            // Demo Delete
            String stmDelete = "delete from category where catID = 4";
            int countDeleted = stmt.executeUpdate(stmDelete);
            System.out.println(countDeleted + " records deleted.\n");

            // Demo Update
            String stmUpdate = "update category" + "set catID = 1" +  "where catID = 5";
            int countUpdated = stmt.executeUpdate(stmUpdate);
            System.out.println(countUpdated + " records updated.\n");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
