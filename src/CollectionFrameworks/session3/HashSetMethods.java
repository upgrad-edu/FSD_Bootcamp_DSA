package CollectionFrameworks.session3;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetMethods {

    public static void main(String[] args) {
        HashSet<Integer> mySet = new HashSet<>();
        mySet.add(5171);
        mySet.add(5172);

        System.out.println(mySet);

        //Clearing all the elements

        mySet.clear();
        System.out.println(mySet);

        //Cloning hashset
        mySet.add(5171);
        mySet.add(5172);

        HashSet<Integer> clonedHashSet = (HashSet<Integer>) mySet.clone();
        System.out.println(clonedHashSet);

        //Checking for an element
        System.out.println(mySet.contains(123));
        System.out.println(mySet.contains(5171));

        //Checking if empty
        System.out.println(mySet.isEmpty());
        System.out.println((new HashSet<>()).isEmpty());

        //Getting the iterator
        Iterator<Integer> iterator = mySet.iterator();
        System.out.println(iterator);
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //Removing an element
        System.out.println(mySet.remove(123));
        System.out.println(mySet.remove(5171));

        //Get the size of the set
        System.out.println(mySet.size());
    }
}
