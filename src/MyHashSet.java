
import java.util.*;

public class MyHashSet {
    private Integer[][] buckets;

    public MyHashSet() {
        this.buckets = new Integer[100_000][10];
    }

    public void add(int key) {
        int index = hash(key);
        Integer[] bucket = buckets[index];
        for(int i = 0; i <= 9; i++){
            if(bucket[i] == null){
                bucket[i] = key;
                break;
            }
        }
    }

    public void remove(int key) {
        int index = hash(key);
        Integer[] bucket = buckets[index];
        for(int i = 0; i <= 9; i++){
            if(bucket[i] != null && bucket[i] == key){
                bucket[i] = null;
            }
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        Integer[] bucket = buckets[index];
        for(int i = 0; i <= 9; i++){
            if(bucket[i] != null && bucket[i] == key){
                return true;
            }
        }
        return false;
    }
    private int hash(int x){
        x %= 100_000;
        return x;
    }
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            boolean res = numsSet.add(nums[i]);

            if (!res) {
                return true;
            }
        }

        return false;
    }
    public int singleNumber(int[] nums) {
        Set<Integer> candidates = new HashSet<>();
        for(Integer i : nums){
            if(!candidates.add(i)){
                candidates.remove(i);
            }
        }

        Iterator<Integer> iterator = candidates.iterator();
        return iterator.hasNext() ? iterator.next() : 0;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> value1 = new HashSet<>();
        Set<Integer> value2 = new HashSet<>();

        for (int i = 0; i < nums1.length; i++){
            value1.add(nums1[i]);
        }
        for (int j = 0; j < nums2.length; j++) {
            value2.add(nums2[j]);
        }

        Set<Integer> intersection = new HashSet<>(value1);
        intersection.retainAll(value2);

        int[] intersectionRes = new int[intersection.size()];
        int i = 0;
        for(Integer x : intersection){
            intersectionRes[i] = x;
            i++;
        }

        return intersectionRes;
    }
}
