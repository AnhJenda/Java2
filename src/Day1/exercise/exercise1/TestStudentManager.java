package Day1.exercise.exercise1;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
/*
    @author: Dinh Quang Anh
    Date   : 4/21/2022
    Project: Java2
*/
public class TestStudentManager {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Managerment managerment = new Managerment();
        Student s1 = new Student("Dinh Quang Anh", 1, "Ninh Binh", "11/07/1999", "quanganh.nowhere@gmail.com", "1");
        Student s2 = new Student("Dinh Quang Em", 2, "Ninh Binh", "11/07/1999", "quanganh.nowhere@gmail.com", "1");
        Student s3 = new Student("Dinh Quang Chi", 3, "Ninh Binh", "11/07/1999", "quanganh.nowhere@gmail.com", "1");
        Scanner input = new Scanner(System.in);
        managerment.objAddStudent(s1);
        managerment.objAddStudent(s2);
        managerment.objAddStudent(s3);
        int choice;
        do {
            System.out.println("1.Them sinh vien");
            System.out.println("2.Xoa sinh vien");
            System.out.println("3.Sua thong tin sinh vien");
            System.out.println("4.Sap xep theo thu tu A->Z");
            System.out.println("5.In ra danh sach sinh vien");
            System.out.println("6.Thoat");
            System.out.println("Nhap lua chon: ");
            choice = input.nextInt();
            switch (choice){
                case 1: managerment.addStudent();
                    break;
                case 2: managerment.removeStudent();
                    break;
                case 3: managerment.setStudent();
                    break;
                case 4: managerment.sortStudent();
                    break;
                case 5: managerment.getStudentList();
                    break;
            }
        }while (choice<6 && choice > 0);
    }
}
