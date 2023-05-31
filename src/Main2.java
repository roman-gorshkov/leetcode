import java.math.BigInteger;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
//        int val = 6;
//        int[] arrays = new int[]{1, 0, 3, 4, 5};
//        int[] arrays3 = new int[]{3, 3, 3};
//        String[] arrays2 = new String[]{"--X", "X++", "X++"};
//        System.out.println(Arrays.toString(reversArray(6)));
//        System.out.println(Arrays.toString(array(5)));
//        System.out.println(arrayList(5));
//        System.out.println(kidsWithCandies(arrays, 2));
//        ListNode n3 = new ListNode(1, null);
//        ListNode n2 = new ListNode(0, n3);
//        ListNode n1 = new ListNode(1, n2);
//
//        System.out.println(getDecimalValue(n1));

        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        System.out.println(addBinary(a, b));


        //System.out.println(removeDuplicates(hui));
    }

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }

    public static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("--X") || operations[i].equals("X--")) {
                x--;
            } else {
                x++;
            }
        }
        return x;
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int numIdenticalPairs(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i < j) {
                    a++;
                }
            }
        }
        return a;
    }

    public static int sumOfMultiples(int n) {
        int x = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                x = x + i;
            }
        }
        return x;
    }

    public int countKDifference(int[] nums, int k) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] - nums[j] == k) {
                    x++;
                }
            }
        }
        return x;
    }

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if (i >= 0 && j > i && k > j && arr.length > k && arr[i] - arr[j] <= a &&
                            arr[j] - arr[k] <= b && arr[i] - arr[k] <= c) {
                        x++;
                    }
                }
            }
        }
        return x;
    }

    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                i++;
            }
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (nums1[i] == 0 && j >= 0) {
                nums1[i] = nums2[j];
                j--;
            }
        }
        Arrays.sort(nums1);
    }

    public int removeElement(int[] nums, int val) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[counter] = nums[i];
                counter++;
            }
        }
        return counter;
    }

    public static int removeDuplicates(int[] nums) {
        int deleted = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == -1) {
                return i;
            }

            if (nums[i] == nums[i-1]) {
                System.arraycopy(nums, i + 1, nums, i, nums.length - i - 1);
                deleted++;
                nums[nums.length - deleted] = -1;
                i--;
            }
        }

        return nums.length;
    }

    public static int[] reversArray(int val) {
        int[] array = new int[val + 1];
        for (int i = val; i >= 0; i--) {
            array[i] = val;
            val--;
        }
        return array;
    }

    public static int[] array(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }

    public static List<Integer> arrayList(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> list = new ArrayList<>();
        int maxValue = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] > maxValue) {
                maxValue = candies[i];
            }
        }
        for (int valueOfCandy : candies) {
            list.add(valueOfCandy + extraCandies >= maxValue);
        }
        return list;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode();
        ListNode curr = mergedList;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null)
            curr.next = list1;

        if (list2 != null)
            curr.next = list2;

        return mergedList.next;
    }
    public static int getDecimalValue(ListNode head) {
        int value = 0;
        ListNode curr = head;
        int[] initialArray = new int[30];
        int idx = 0;
        while (curr != null) {
            initialArray[idx] = curr.val;
            if (curr.next != null) {
                idx++;
            }
            curr = curr.next;
        }
        int[] array = new int[idx + 1];
        System.arraycopy(initialArray, 0, array, 0, idx + 1);
        int result = 0;
        for (int i = idx; i >= 0; i--) {
            result += (array[i] * Math.pow(2, array.length - i - 1));
        }
        return result;
    }
    public static ListNode middleNode(ListNode head) {
        int counter = 0;
        for(ListNode i = head; i != null; i = i.next){
            counter ++;
        }
        int middle = (int) Math.ceil(counter/2);
        for(ListNode j = head; j != null; j = j.next){
            if(middle == 0){
                return j;
            }
            middle--;
        }
        return null;
    }
    public ListNode reverseList(ListNode head) {
        ListNode currNode = head;
        ListNode prevNode = null;

        while(currNode != null){
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }
    public int mostWordsFound(String[] sentences) {
        int counter = 0;
        for (int i = 0; i < sentences.length; i++) {
            String[] words = sentences[i].split(" ");
            if(words.length > counter){
                counter = words.length;
            }
        }
        return counter;
    }
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--){
            if(digits[i] != 9){
                digits[i] = digits[i] + 1;
            }
            else {
                digits[i] = 0;
            }
        }

        if (digits[0] == 0) {
            int[] soloValue = new int[digits.length + 1];
            soloValue[0] = 1;
            return soloValue;
        }

        return digits;
    }
    public int mySqrt(int x) {
        int y = (int) Math.sqrt(x);
        Math.round(y);
        return y;
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= Math.min(i + k, nums.length - 1); j++) {
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static String addBinary(String a, String b) {
        BigInteger first = new BigInteger(a, 2);
        BigInteger second = new BigInteger(b, 2);
        BigInteger sum = first.add(second);

        return sum.toString(2);
    }
    public List<String> fizzBuzz(int n) {
        ArrayList<String> answer = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0  && i % 5 == 0){
                answer.add("FizzBuzz");
            }
            else if (i % 3 == 0) {
                answer.add("Fizz");
            }
            else if (i % 5 == 0) {
                answer.add("Buzz");
            }
            else {
                answer.add(String.valueOf(i));
            }
        }
        return answer;
    }

}
