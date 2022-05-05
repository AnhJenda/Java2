package Day1.exercise.exercise3;
import java.util.ArrayList;
import java.util.List;
/*
    @author: Dinh Quang Anh
    Date   : 4/26/2022
    Project: Java2
*/
public class menu {
    private List<cafe> menuList;

    public menu() {
        menuList = new ArrayList<>();
    }

    public void addMenuList(cafe cafe) {
        for (cafe cafe1: menuList) {
            if (!cafe1.equals(cafe)) {
                menuList.add(cafe);
            } else {
                System.out.println("Da co loai cafe nay trong menu");
            }
        }
    }

    public void updateMenuList () {

    }
}
