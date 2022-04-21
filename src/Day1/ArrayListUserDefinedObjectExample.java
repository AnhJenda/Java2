package Day1;
import java.util.ArrayList;
import java.util.List;

/*
    @author: Dinh Quang Anh
    Date   : 4/21/2022
    Project: Java2
*/
class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
public class ArrayListUserDefinedObjectExample {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Rajeev", 25));
        users.add(new User("John", 34));
        users.add(new User("Steve", 29));

        users.forEach(user -> {
            System.out.println("Name : " + user.getName() + ", Age : " + user.getAge());
        });
    }
}
