package CollectionFrameworks.session3;

import java.util.HashSet;
import java.util.Objects;

public class DeepCopy {

    public static  HashSet<Person>  deepCopy(HashSet<Person> set){

        HashSet<Person> clone = new HashSet();

        for(Person p : set){
            Person newP = new Person(p.getName(), p.getAge());
            clone.add(newP);
        }
        return clone;
    }

    public static void main(String[] args) {
        Person p1 = new Person("Vishwa",99);
        Person p2 = new Person("Mohan",97);
        Person p3 = new Person("Shivani",96);

        HashSet<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);

        System.out.println(deepCopy(set));
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
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

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
