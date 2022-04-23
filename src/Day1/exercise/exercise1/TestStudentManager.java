package Day1.exercise.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

/*
    @author: Dinh Quang Anh
    Date   : 4/21/2022
    Project: Java2
*/
public class TestStudentManager {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        // add()
        students.add(new Student("Dinh Quang Anh", 1, "Ninh Binh", "11/07/1999",
                "quanganh@nowhere.com", "Dang hoc"));
        students.add(new Student("Dinh Quang Em", 2, "Ha Noi", "12/08/2000",
                "quangem@nowhere.com", "Chua hoc"));
        students.add(new Student("Dinh Quang Chi", 3, "Ninh Binh", "13/09/2001",
                "quangchi@nowhere.com", "Hoc xong"));

        System.out.println("list: " + students);

        // set()
        students.set(2,new Student("Dinh Quang Em 2", 3, "Ninh Binh", "14/10/2002",
                        "quangem2@nowhere.com", "Hoc xong"));
        System.out.println("list" + students);

        // find
//        students.forEach(student -> {
//            if (student.getFullName() == "Dinh Quang Anh") {
//                System.out.println("Dinh Quang Anh is exist in the student array");
//                System.out.println("index of \"Dinh Quang Anh\": " +students.indexOf(student));
//            }else {
//                System.out.println("can not find \"Dinh Quang Anh\"");
//            }
//        });
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFullName().contains("Dinh Quang Anh")){
                System.out.println("Dinh Quang Anh is exist in the student array");
                System.out.println("index of \"Dinh Quang Anh\": " + i);
            }else {
                System.out.println("can not find \"Dinh Quang Anh\"");
            }
        }
        // sort by name
        Collections.sort(students, Comparator.comparing(Student::getFullName));
        System.out.println(students);
        // remove
        students.remove(2);
        System.out.println(students);
    }
}
