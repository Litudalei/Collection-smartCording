public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private int sal;

    public Person(String name, int age, int sal) {
        this.name = name;
        this.age = age;
        this.sal = sal;
    }


    @Override
    public int compareTo(Person o) {
        return this.age-o.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sal=" + sal +
                '}';
    }
}
