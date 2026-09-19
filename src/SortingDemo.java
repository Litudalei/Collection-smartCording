import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingDemo {
    public static void main(String[] args) {
        List<Person> personsallist= Arrays.asList(
                new Person("Richu",23,446),
                new Person("Gitiranjan",27,654),
                new Person("Rohan",34,889),
                new Person("Anbu",21,675),
                new Person("Hemashree",32,764)


        );
        System.out.println("Before sorting");
        System.out.println(personsallist);
        System.out.println("after Sorting");
        Collections.sort(personsallist);
        System.out.println(personsallist);
    }
}
