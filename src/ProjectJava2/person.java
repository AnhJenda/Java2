package ProjectJava2;

/*
    @author: Dinh Quang Anh
    Date   : 5/16/2022
    Project: Java2
*/
public class person {
    private int id;
    private String name;
    private String address;

    public person(int id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }
    // getter setter

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getAddress(){
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
