package hashing;

import java.util.*;

public class Session3 {

    /**
     * Implementing own custom HashTable
     */

    static class Node<K, V> {
        private K key;
        private V value;
        private final int hashCode;

        private Node<K, V> next;

        public Node(K key, V value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public int getHashCode() {
            return hashCode;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }

    static class HashMap<K, V> {

        private List<Node<K, V>> buckets;

        private int bucketsCount;

        private int size;

        public HashMap() {
            buckets = new ArrayList<>();
            bucketsCount = 10;
            size = 0;

            for (int i = 0; i < bucketsCount; i++)
                buckets.add(null);
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        private final int hashCode(K key) {
            return Objects.hashCode(key);
        }

        private int getBucketIndex(K key) {
            int hashCode = hashCode(key);
            int index = hashCode % bucketsCount;
            index = index < 0 ? index * -1 : index;
            return index;
        }

        public V delete(K key) {
            int bucketIndex = getBucketIndex(key);
            int hashCode = hashCode(key);
            Node<K, V> head = buckets.get(bucketIndex);
            Node<K, V> prev = null;
            while (head != null) {
                if (head.getKey().equals(key) && hashCode == head.getHashCode())
                    break;

                prev = head;
                head = head.getNext();
            }

            if (head == null)
                return null;

            size--;

            // Remove key
            if (prev != null)
                prev.setNext(head.getNext());
            else
                buckets.set(bucketIndex, head.getNext());

            return head.getValue();
        }

        public V get(K key) {
            int bucketIndex = getBucketIndex(key);
            int hashCode = hashCode(key);

            Node<K, V> head = buckets.get(bucketIndex);

            while (head != null) {
                if (head.getKey().equals(key) && head.getHashCode() == hashCode)
                    return head.value;
                head = head.next;
            }

            return null;
        }

        public void add(K key, V value) {
            int bucketIndex = getBucketIndex(key);
            int hashCode = hashCode(key);
            Node<K, V> head = buckets.get(bucketIndex);

            while (head != null) {
                if (head.getKey().equals(key) && head.getHashCode() == hashCode) {
                    head.setValue(value);
                    return;
                }
                head = head.getNext();
            }

            size++;
            head = buckets.get(bucketIndex);
            Node<K, V> newNode
                    = new Node<K, V>(key, value, hashCode);
            newNode.setNext(head);
            buckets.set(bucketIndex, newNode);

            if ((1.0 * size) / bucketsCount >= 0.7) {
                List<Node<K, V>> temp = buckets;
                buckets = new ArrayList<>();
                bucketsCount = 2 * bucketsCount;
                size = 0;
                for (int i = 0; i < bucketsCount; i++)
                    buckets.add(null);

                for (Node<K, V> headNode : temp) {
                    while (headNode != null) {
                        add(headNode.getKey(), headNode.getValue());
                        headNode = headNode.getNext();
                    }
                }
            }
        }

    }

    /**
     * Check if the array can be divided into pairs whose sum is divisible by k
     * Input: arr[] = {9, 7, 5, 3},
     * k = 6
     * Output: True
     * We can divide the array into (9, 3) and
     * (7, 5). Sum of both of these pairs
     * is a multiple of 6.
     */

    public static boolean canDivideInPairs(int[] arr, int k) {
        if (arr.length % 2 == 1)
            return false;

        Map<Integer, Integer> map = new java.util.HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int rem = ((arr[i] % k) + k) % k;
            if (!map.containsKey(rem)) {
                map.put(rem, 0);
            }
            map.put(rem, map.get(rem) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            int rem = ((arr[i] % k) + k) % k;

            if (2 * rem == k) {
                if (map.get(rem) % 2 == 1)
                    return false;
            } else if (rem == 0) {
                if (map.get(rem) % 2 == 1)
                    return false;
            } else {
                if (map.get(k - rem) != map.get(rem))
                    return false;
            }
        }
        return true;
    }

    /**
     * Check for a pair with the given sum in an array
     * <p>
     * Input: arr[] = {0, -1, 2, -3, 1}
     * sum = -2
     * Output: -3, 1
     */

    public static void findPairSum(int[] arr, int sum) {
        Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < arr.length; ++i) {
            int temp = sum - arr[i];
            if (s.contains(temp)) {
                System.out.println(arr[i] + " , "+temp);
            }
            s.add(arr[i]);
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.add("Vishwa", 1);
        map.add("Mohan", 2);
        map.add("Shivani", 4);
        map.add("Akanksha", 5);
        System.out.println(map.size());
        System.out.println(map.delete("Vishwa"));
        System.out.println(map.delete("Mohan"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());

        int arr[] = {92, 75, 65, 48, 45, 35};
        int arr1[] = {93, 75, 65, 48, 45, 35};
        int k = 10;

        System.out.println(canDivideInPairs(arr, 10));
        System.out.println(canDivideInPairs(arr1, 10));


        findPairSum(arr, 123);

    }
}