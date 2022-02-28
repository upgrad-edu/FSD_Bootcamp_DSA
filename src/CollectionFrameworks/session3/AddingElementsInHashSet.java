package CollectionFrameworks.session3;

import java.util.HashSet;

public class AddingElementsInHashSet {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Vishw");
        set.add("Abhishel");
        set.add("Babun");
        set.add("Cat");
        set.add("Deewana");
        set.add("English");
        set.add("Fan");
        set.add("Goat");
        set.add("House");
        set.add("India");

        for(String name : set){
            System.out.println(name);
        }


    }
}
