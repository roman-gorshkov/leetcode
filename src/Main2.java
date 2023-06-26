import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        int val = 6;
        int[] arrays = new int[]{1, 0, 3, 4, 5};
        int[] arrays3 = new int[]{3, 3, 3};
        String[] arrays2 = new String[]{"--X", "X++", "X++"};
        System.out.println(Arrays.toString(reversArray(6)));
        System.out.println(Arrays.toString(array(5)));
        System.out.println(arrayList(5));
        System.out.println(kidsWithCandies(arrays, 2));
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

    public int removeDuplicates(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[i] == nums[j]) {
                    nums[i] = nums[j];
                    counter++;
                } else {
                    nums[counter] = nums[i];
                }
            }
        }
        return counter;
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


    public class ListNode {
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

}
