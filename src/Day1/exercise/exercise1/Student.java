package Day1.exercise.exercise1;
/*
    @author: Dinh Quang Anh
    Date   : 4/21/2022
    Project: Java2
*/
    public class Student {
    private String fullName;
    private int rollNo;
    private String address;
    private String DoB;
    private String email;
    private String status;
    // constructor
    public Student(String fullName, int rollNo, String address, String DoB, String email, String status) {
        this.fullName = fullName;
        this.rollNo = rollNo;
        this.address = address;
        this.DoB = DoB;
        this.email = email;
        this.status = status;
    }
    // getter
    public String getFullName() {
        return this.fullName;
    }
    public int getRollNo() {
        return this.rollNo;
    }
    public String getAddress() {
        return this.address;
    }
    public String getDoB() {
        return this.DoB;
    }
    public String getEmail() {
        return this.email;
    }
    public String getStatus() {
        return this.status;
    }
    // setter
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public void setDoB(String DoB) {
        this.DoB = DoB;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    // to String
    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", rollNo=" + rollNo +
                ", address='" + address + '\'' +
                ", DoB=" + DoB +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
