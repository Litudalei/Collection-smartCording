public class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private double sal;

    public Employee(String name, int age, double sal) {
        this.name = name;
        this.age = age;
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sal=" + sal +
                '}';
    }


@Override
    public int compareTo(Employee o) {
        return Double.compare(this.sal,o.sal);//- operator will be used for numberic data types not for strings.
}}
