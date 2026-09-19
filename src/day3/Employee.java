package day3;

public class Employee {
     int id;
     String name;
     Double salary;
     int bonous;

    public Employee(int id, String name, Double salary, int bonous) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.bonous = bonous;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", bonous=" + bonous +
                '}';
    }
}
