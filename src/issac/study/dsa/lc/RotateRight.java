package issac.study.dsa.lc;


class ListNode {
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


class Solution {

    public static void main(String[] args) {
        ListNode node = generateList(3);
        printNodeList(node);
        System.out.println("----");
        ListNode node1 = rotateRight(node, 4);
        printNodeList(node1);
    }


    public static ListNode generateList(int n) {
        if (n <= 0) {
            return null;
        }
        ListNode root = new ListNode(0);
        ListNode next = root;
        for (int i = 1; i < n; i++) {
            next.next = new ListNode(i);
            next = next.next;
        }
        return root;
    }

    public static void printNodeList(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        ListNode node = listNode;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 旋转列表
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        //   head = rotate(head, k);
        head = rotate2(head, k);
        return head;
    }

    private static ListNode rotate2(ListNode head, int k) {
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            n++;
            tail = tail.next;
        }
        k = n - k % n;
        if (k == n) {
            return head;
        }
        ListNode cur = head, pre = head;
        while (k-- > 0) {
            pre = cur;
            cur = cur.next;
        }
        tail.next = head;
        head = cur;
        pre.next = null;
        return head;
    }

    private static ListNode rotate(ListNode head, int k) {
        ListNode ct = new ListNode(1);
        ListNode rightPre = findRightPre(head, ct);
        k = k % ct.val;
        for (int i = 0; i < k; i++) {
            ListNode right = rightPre.next;
            rightPre.next = null;
            right.next = head;
            head = right;
            rightPre = findRightPre(head, ct);
        }
        return head;
    }

    private static ListNode findRightPre(ListNode head, ListNode ct) {
        if (head == null) {
            return null;
        }
        ListNode pre = head, next = head.next;
        while (next != null && next.next != null) {
            pre = next;
            next = next.next;
            ct.val++;
        }
        ct.val++;
        return pre;
    }
}