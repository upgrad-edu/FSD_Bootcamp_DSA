package CollectionFrameworks.session3;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {
        /**
         * Constructors
         */

        HashMap<Integer, String> map = new HashMap<>();

        HashMap<Integer, String> map1 = new HashMap<>(64);

        HashMap<Integer, String> map2 = new HashMap<>(64,0.9f);

        HashMap<Integer, String> map3 = new HashMap<>(new HashMap<>());


        /**
         * Methods supported
         */

        //Inserting elements
        map.put(1, "Vishwa");
        map.put(2, "Mohan");
        map.put(3, "Shivani");

        //Inserting a mpa
        map1.putAll(map);

        //Getting the set of keys
        System.out.println(map.keySet());

        //Removing the key from the map
        System.out.println(map.remove(1));

        //Check for the value in the map
        System.out.println(map.containsValue("Shivani"));
        System.out.println(map.containsValue("Vishwa"));

        //Check for the keys in the map
        System.out.println(map.containsValue(1));
        System.out.println(map.containsValue(2));

        //Iterating over the hashMap
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() +" -> "+entry.getValue());
        }

        //Checking if the HashMap is empty
        System.out.println(map.isEmpty());
        System.out.println(map2.isEmpty());

        //Cloning a hashmap
        HashMap<Integer, String> clonedMap = (HashMap<Integer, String>) map.clone();
        System.out.println(clonedMap);





    }
}
