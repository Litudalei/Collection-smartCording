import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortEmployeeDemo {
    public static void main(String[] args) {
        List<Employee> emplist= Arrays.asList(
                new Employee("Amit",12,34.0),
                new Employee("Glen",34,321.8),
                new Employee("Javed",21,789.0),
                new Employee("Wasim",21,554.0)
        );
        System.out.println("--------Before Sorting-----------");
        emplist.forEach(emp-> System.out.println(emp));
        Collections.sort(emplist);
        System.out.println("List employee after sorting");
        emplist.forEach((emp)-> System.out.println(emp));

    }
}
