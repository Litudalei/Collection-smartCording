package day3;

import java.util.ArrayList;
import java.util.List;

public class CustomSorting {
    public static void main(String[] args) {
        List<Employee> emplist=new ArrayList<>();
        emplist.add(new Employee(1,"Richu",234.5,20));
        emplist.add(new Employee(2,"Chella",204.5,10));
        emplist.add(new Employee(3,"Chidda",224.5,40));
        emplist.add(new Employee(4,"Roshan",1234.5,100));
        emplist.sort((e1,e2)->e2.salary.compareTo(e1.salary));
        System.out.println(emplist);
    }
}
