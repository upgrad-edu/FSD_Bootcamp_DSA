package CollectionFrameworks.session3;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTableDemo {

    public static void main(String[] args) {
        /**
         * Constructors declaration
         */

        Hashtable< Integer, String> ht = new Hashtable<>();
        Hashtable<Integer, String> ht1 = new Hashtable<>(64);
        Hashtable<Integer, String> ht2 = new Hashtable<>(64,.9f);
        Hashtable<Integer, String> ht3 = new Hashtable<>(ht);

        /**
         * Hashtable methods
         */
        //Inserting elements
        ht.put(1, "Vishwa");
        //Inserting elements
        ht.put(1, "Vishwa");
        ht.put(2, "Mohan");
        ht.put(3, "Shivani");

        //Inserting a mpa
        ht1.putAll(ht);

        //Getting the set of keys
        System.out.println(ht.keySet());

        //Removing the key from the map
        System.out.println(ht.remove(1));

        //Check for the value in the map
        System.out.println(ht.containsValue("Shivani"));
        System.out.println(ht.containsValue("Vishwa"));

        //Check for the keys in the map
        System.out.println(ht.containsValue(1));
        System.out.println(ht.containsValue(2));

        //Iterating over the hashMap
        for(Map.Entry<Integer, String> entry : ht.entrySet()){
            System.out.println(entry.getKey() +" -> "+entry.getValue());
        }

        //Checking if the HashMap is empty
        System.out.println(ht.isEmpty());
        System.out.println(ht.isEmpty());

        //Cloning a hashmap
        Hashtable<Integer, String> clonedMap = (Hashtable<Integer, String>) ht.clone();
        System.out.println(clonedMap);

    }
}
