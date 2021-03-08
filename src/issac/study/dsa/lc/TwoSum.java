package issac.study.dsa.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author issac.hu
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));

        ListNode l1 = convertArr(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = convertArr(new int[]{9, 9, 9, 9});
        ListNode listNode = addTwoNumbers(l1, l2);
        printListNode(listNode);
        String s = "tmmzuxt";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }

    /**
     * https://leetcode-cn.com/problems/two-sum/
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int two = target - nums[i];
            Integer towIndex = temp.get(two);
            if (towIndex == null) {
                temp.put(nums[i], i);
            } else {
                if (i < towIndex) return new int[]{i, towIndex};
                else return new int[]{towIndex, i};

            }
        }
        return null;
    }

    public static ListNode convertArr(int[] arr) {
        ListNode head = new ListNode();
        ListNode next = head;
        for (int i = 0; i < arr.length; i++) {
            next.val = arr[i];
            ListNode temp = new ListNode();
            next.next = temp;
            next = temp;
        }
        return head;
    }

    public static void printListNode(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        do {
            list.add(listNode.val);
        } while ((listNode = listNode.next) != null);
        System.out.println(Arrays.toString(list.toArray()));
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

    /**
     * https://leetcode-cn.com/problems/add-two-numbers/
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curNode = new ListNode();
        ListNode head = curNode;
        int overflow = 0;
        boolean hasNext = false;
        do {
            if (hasNext) {
                curNode = curNode.next = new ListNode();
            }
            int add = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + overflow;
            curNode.val = add % 10;
            overflow = add / 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            //并且溢出位不为0
        } while (hasNext = (l1 != null || l2 != null || overflow != 0));
        return head;
    }

    /**
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        int beginIndex = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int tempIndex = s.indexOf(c, beginIndex);
            if (tempIndex < i && tempIndex != -1) {
                beginIndex = tempIndex + 1;
            } else {
                maxLength = Math.max(i + 1 - beginIndex, maxLength);
            }
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring(String s) {
        int beginIndex = 1;
        int maxLength = 0;
        int[] temp = new int[128];//ascii码范围
        for (int i = 1; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            int tempIndex = temp[c];
            if (tempIndex >= beginIndex) {
                beginIndex = tempIndex + 1;
            } else {
                maxLength = Math.max(i + 1 - beginIndex, maxLength);
            }
            temp[c] = i;
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int beginIndex = 0;
        int maxLength = 0;
        HashMap<Character, Integer> indexMap = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            char c = chars[i];
            Integer tempIndex = indexMap.get(c);
            if (tempIndex != null && tempIndex >= beginIndex) {
                beginIndex = tempIndex + 1;
            } else {
                maxLength = Math.max(i + 1 - beginIndex, maxLength);
            }
            indexMap.put(c, i);
        }
        return maxLength;
    }


}
