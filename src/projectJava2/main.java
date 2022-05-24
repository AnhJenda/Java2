package projectJava2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

;
/*
    @author: Dinh Quang Anh
    Date   : 5/21/2022
    Project: Java2
*/
public class main {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava2", "root", "");
        ) {
            List<Student> studentList = new ArrayList<>();
            Controller controller = new Controller();
            System.out.println("Enter 1 to start program!");
            System.out.println("Enter 4 to end.");
            Scanner exit = new Scanner(System.in);
            int exitBtn = exit.nextInt();
                while (exitBtn != 4){
                    Scanner in = new Scanner(System.in);
                    System.out.println("* Enter 1 to add student record.");
                    System.out.println("* Enter 2 to display student records in collection.");
                    System.out.println("* Enter 3 to save student record to database.");
                    System.out.println("* Enter 4 to display student records in database.");
                    System.out.println("* Enter 5 to update student records in database.");
                    System.out.println("* Enter 6 to delete student records in database.");
                    System.out.println("* Enter 7 to exit.");
                    System.out.println("Enter your choice: ");
                    int choice = in.nextInt();
                    switch (choice) {
                        case 1:
                            controller.addStudent();
                            break;
                        case 2:
                            controller.displayCollectionStudent();
                            break;
                        case 3:
                            System.out.println("You choosed saving the student records!");
                            List<Student> listStudent = controller.getStudentList();
                            String saveStm = "INSERT INTO student(studentID, name, address, phone) VALUES (?, ?, ?,?);";
                            PreparedStatement pstmt = conn.prepareStatement(saveStm);
                            int count = 0;
                            for (Student student: listStudent) {
                                pstmt.setInt(1, student.getStudentID());
                                pstmt.setString(2, student.getName());
                                pstmt.setString(3, student.getAddress());
                                pstmt.setString(4, student.getPhone());
                                pstmt.executeUpdate();
                                ++count;
                            }
                            System.out.println(count + "records saved!");
                            break;
                        case 4:
                            System.out.println("You choosed displaying student records saved in database!");

                            String displayStm = "Select * from student";
                            PreparedStatement prpStmSelect = conn.prepareStatement(displayStm);
                            ResultSet rset = prpStmSelect.executeQuery();
                            ResultSetMetaData rsetMD = rset.getMetaData();
                            int numColumns = rsetMD.getColumnCount();
                            for (int i = 1; i <= numColumns; ++i) {
                                System.out.printf("%-30s", rsetMD.getColumnName(i));
                            }
                            System.out.println();
                            for (int i = 1; i <= numColumns; ++i) {
                                System.out.printf("%-30s",
                                        "(" + rsetMD.getColumnClassName(i) + ")");
                            }
                            System.out.println();
                            while (rset.next()) {
                                for (int i = 1; i <= numColumns; ++i) {
                                    System.out.printf("%-30s", rset.getString(i));
                                }
                                System.out.println();
                            }
                            break;
                        case 5:
                            System.out.println("You choosed updating student records saved in database");
                            String updateStm = "Update student set studentID = ?, name = ?, address = ?, phone = ? where studentID = ?";
                            System.out.println("Enter ID of the student you want to update: ");
                            int oldID = in.nextInt();
                            if (studentList.stream().anyMatch(student -> student.getStudentID() == oldID)){
                                PreparedStatement psstm = conn.prepareStatement(updateStm);
                                System.out.println("Enter new ID: ");
                                in.nextLine();
                                int newID = in.nextInt();
                                System.out.println("Enter new name: ");
                                String name = in.nextLine();
                                System.out.println("Enter address: ");
                                String address = in.nextLine();
                                System.out.println("Enter phone num: ");
                                String phoneNum = in.nextLine();

                                psstm.setInt(1, newID);
                                psstm.setString(2, name);
                                psstm.setString(3, address);
                                psstm.setString(3, phoneNum);
                                psstm.setInt(5, oldID);
                                psstm.executeUpdate();
                            } else {
                                System.out.printf("ID %d does not exists!", oldID);
                            }
                            break;
                        case 6:
                            System.out.println("You choosed delete student records saved in database");
                            System.out.println("Enter ID of the student you want to delete:");
                            int ID = in.nextInt();
                            if (studentList.stream().anyMatch(student -> student.getStudentID() == ID)){
                                String stmDelete = "delete from student where studentID = ?";
                                PreparedStatement psstm = conn.prepareStatement(stmDelete);
                                psstm.setInt(1, ID);
                                psstm.executeUpdate();
                            }else {
                                System.out.printf("ID %d does not exists!", ID);
                            }
                            break;
                        case 7:
                            exitBtn = 4;
                            break;
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
