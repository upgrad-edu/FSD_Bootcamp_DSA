package hashing;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class DeepCopy {

    public static Map<Integer, Person> deepCopy(HashMap<Integer, Person> map) {

        Map<Integer, Person> clonedMap = new HashMap<>();

        for (Map.Entry<Integer, Person> e : map.entrySet()) {

            Person person = e.getValue();
            Person newP = new Person(person.getName(), person.getAge());
            clonedMap.put(e.getKey(), newP);
        }
        return clonedMap;
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

