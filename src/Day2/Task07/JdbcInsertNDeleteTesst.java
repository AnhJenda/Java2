package Day2.Task07;

/*
    @author: Dinh Quang Anh
    Date   : 5/10/2022
    Project: Java2
*/
import java.sql.*;
import java.util.Scanner;

public class JdbcInsertNDeleteTesst {
    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url,user,password);
            System.out.println("Kết nối thành công");

            Statement stmt = conn.createStatement();


            String sqlDelete = "delete from books where id >=8000";
            System.out.println("The SQL statement is: " + sqlDelete + "\n");
            /**
             * countDeleted : trả về số lượng bản ghi bị xóa
             */
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted + " records deleted.\n");

            /**
             * Insert dữ liệu
             */
            String sqlInsert = "insert into books values (3001, 'Gone Fishing', 'Kumar', 11.11, 11)";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            /**
             * countInserted : Trả về số lượng bản ghi được thêm vào bảng
             */
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");

            // INSERT multiple records
            sqlInsert = "insert into books values "
                    + "(8001, 'Java Core', 'Dang Kim Thi', 15.55, 55),"
                    + "(8002, 'Java Advanced', 'James Gosling', 25.55, 55)";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");

            // INSERT a partial record
            sqlInsert = "insert into books (id, title, author) values (2001, 'Java JDBC MySQL', 'ThiDK')";
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");

            //Scaner Insert
            Scanner in = new Scanner(System.in);
            System.out.println("Nhap ID");
            Integer id = in.nextInt();
            in.nextLine();
            System.out.println("Nhập tiêu đề");
            String title = in.nextLine();
            System.out.println("Nhập Tác giả");
            String author = in.nextLine();
            sqlInsert = "insert  into books(id,title,author) values ('" + id + "','" + title +"','" + author + "')";
            countInserted =  stmt.executeUpdate(sqlInsert);


            //Delete
            sqlDelete = "delete from books where id=2001";
            countDeleted = stmt.executeUpdate(sqlDelete);
            // Issue a SELECT to check the changes
            String strSelect = "select * from books";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()) {   // Move the cursor to the next row
                System.out.println(rset.getInt("id") + ", "
                        + rset.getString("author") + ", "
                        + rset.getString("title") + ", "
                        + rset.getDouble("price") + ", "
                        + rset.getInt("qty"));
            }

            conn.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}