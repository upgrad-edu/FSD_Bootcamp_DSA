package CollectionFrameworks.session3;

import java.util.HashMap;
import java.util.Map;

public class IteratingHashMap {

    public static void main(String[] args) {


        HashMap<String, Integer> map = new HashMap<>();

        map.put("Vishwa", 231);
        map.put("Mohan", 143);
        map.put("Shivani", 560);
        map.put("Akshay", 191);
        map.put("Evin", 231);
        map.put("Keith", 204);
        map.put("Sonam", 299);
        map.put("Kareena", 508);
        map.put("Kajol", 511);
        map.put("Arpit", 531);

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println("Salary details  : "+ entry.getKey() + " : "+ entry.getValue());
        }
    }
}
