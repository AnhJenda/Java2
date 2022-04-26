package Day1.exercise.exercise1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    @author: Dinh Quang Anh
    Date   : 4/23/2022
    Project: Java2
*/
public class Managerment {
    private List<Student> studentList;
    private static Scanner input = new Scanner(System.in);

    public Managerment() {
        this.studentList = new ArrayList<>();
    }
    public void objAddStudent(Student student) {
        studentList.add(student);
    }
    public List<Student> getStudentList() {
        return studentList;
    }

    public void addStudent() {
        String fullName;
        int rollNo;
        String address;
        String DoB;
        String email;
        String status;

        System.out.println("Nhap thong tin sinh vien!");
        System.out.println("Moi ban nhap ma sinh vien(kieu int) : ");
        rollNo = input.nextInt();

        if(studentList.stream().allMatch(student -> student.getRollNo() != (rollNo))){
            System.out.println("Nhap fullName");
            fullName = input.next();
            System.out.println("Nhap address");
            address = input.nextLine();
            System.out.println("Nhap email");
            email = input.nextLine();
            System.out.println("Nhap ngay sinh");
            DoB = input.nextLine();
            System.out.println("Nhap status");
            status = input.nextLine();
            Student stu = new Student(fullName, rollNo, address, DoB, email, status);
            studentList.add(stu);
            System.out.println("Thêm sinh viên thành công");
        }else {
            System.out.println("Sinh viên đã tồn tại");
        }
    }
    public void removeStudent() {
        int rollNo;
        System.out.println("Xoa thong tin sinh vien!");
        System.out.println("Moi ban nhap ma sinh vien(kieu int) : ");
        rollNo = input.nextInt();

        if(studentList.stream().anyMatch(student -> student.getRollNo() == (rollNo))){
            for (Student student : studentList) {
                if(student.getRollNo() == (rollNo)){
                    studentList.remove(student);
                    System.out.println("Xóa sinh viên thành công");
                    break;
                }
            }
        }else {
            System.out.println("Sinh viên không tồn tại");
        }
    }
    public void setStudent() {
        String fullName;
        int rollNo;
        String address;
        String DoB;
        String email;
        String status;

        System.out.println("Sua thong tin sinh vien!");
        System.out.println("Moi ban nhap ma sinh vien(kieu int) : ");
        rollNo = input.nextInt();

        for (Student student : studentList) {
            if (student.getRollNo() != rollNo) {
                System.out.printf("Khong ton tai sinh vien co ma so %d \n", rollNo);
            } else {
                System.out.println("Moi ban nhap ten sinh vien : ");
                fullName = input.next();
                System.out.println("Moi ban nhap ma sinh vien : ");
                rollNo = input.nextInt();
                System.out.println("Moi ban nhap dia chi:");
                address = input.next();
                System.out.println("Moi ban nhap ngay sinh (dd/mm/yyyy)");
                DoB = input.next();
                System.out.println("Moi ban nhap email:");
                email = input.next();
                System.out.println("Moi ban nhap trang thai hoc tap(1-dang hoc; 2-hoc xong; 3-nghi hoc):");
                status = input.next();
                student.setFullName(fullName);
                student.setAddress(address);
                student.setDoB(DoB);
                student.setEmail(email);
                student.setStatus(status);
                student.setRollNo(rollNo);
            }
        }
    }
    public void sortStudent(){
        studentList.sort((stu1,stu2)->stu1.getFullName().compareTo(stu2.getFullName()));
        getStudentList();
    }
}
