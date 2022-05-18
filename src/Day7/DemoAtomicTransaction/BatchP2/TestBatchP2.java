package Day7.DemoAtomicTransaction.BatchP2;

/*
    @author: Dinh Quang Anh
    Date   : 5/16/2022
    Project: Java2
*/
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
public class TestBatchP2 {
    public static @NotNull List<person> personList() {
        List<person> listPerson = new ArrayList<person>();
        for (int i = 0; i < 1000; i++) {
            listPerson.add(new person(i, "person" + i, "address" + i));
        }
        return listPerson;
    }
    public static void main(String[] args) throws SQLException {
        demoInsertWithoutBatch();
        System.out.println("---------------------------------------------------------------");
        demoInsertWithBatch(200);
    }
    public static void demoInsertWithBatch(int batchSize) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testbatch", "root",
                "");
        /*
        System.currentTimeMillis() thường được sử dụng để đo khoảng thời gian làm một việc gì đó
         bằng cách gọi method này trước khi bắt đầu công việc, và sau khi hoàn thành công việc. đơn vị là ms.
         */
        long startTime = System.currentTimeMillis();
        List<person> listPerson = personList();
        String sql = "INSERT INTO person(name, address) VALUES (?, ?);";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        connection.setAutoCommit(false);
        System.out.println("Sử dụng batch để insert.. ");
        int count = 1;
        for (person person : listPerson) {
            pstmt.setString(1, person.getName());
            pstmt.setString(2, person.getAddress());
            pstmt.addBatch();
            if (count % batchSize == 0) {
                pstmt.executeBatch();
                connection.commit();
            }
            count++;
        }
        pstmt.executeBatch();
        connection.commit();
        long endTime = System.currentTimeMillis();
        System.out.println("Done.");
        System.out.println("Total time: " + (endTime - startTime));
        connection.close();
    }
    public static void demoInsertWithoutBatch() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testbatch", "root",
                "");
        long startTime = System.currentTimeMillis();
        List<person> listPerson = personList();
        String sql = "INSERT INTO person(name, address) VALUES (?, ?);";
        PreparedStatement pstmt = connection.prepareStatement(sql);

        System.out.println("không sử dụng batch để insert ");

        int count = 1;
        for (person person : listPerson) {
            pstmt.setString(1, person.getName() + count);
            pstmt.setString(2, person.getAddress() + count);
            pstmt.executeUpdate();
            count ++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Done.");
        System.out.println("Total time: " + (endTime - startTime));
        connection.close();
    }
}
