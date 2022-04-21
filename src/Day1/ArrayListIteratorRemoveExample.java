package Day1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
    @author: Dinh Quang Anh
    Date   : 4/21/2022
    Project: Java2
*/
public class ArrayListIteratorRemoveExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(13);
        numbers.add(18);
        numbers.add(25);
        numbers.add(40);

        Iterator<Integer> numbersIterator = numbers.iterator();
        while (numbersIterator.hasNext()) {
            Integer num = numbersIterator.next();
            if(num % 2 != 0) {
                numbersIterator.remove();
            }
        }

        System.out.println(numbers);
    }
}
