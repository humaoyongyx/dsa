package issac.study.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author issac.hu
 */
public class DeepSort {
    /**
     * --------A
     * ---B       C
     * -D   E   F   G
     * <p>
     * 先序 ABDECFG
     * 中序 DBEAFCG
     * 后序 DEBFGCA
     * 广度优先遍历：ABCDEFG
     *
     * @param args
     */
    public static void main(String[] args) {
        Node node = getNode();
        deepSort(node);
        System.out.println("----");
        deepSortWithStackPre(node, new Stack<>());
        System.out.println("----");
        breadthSort(node, new LinkedList<>());
    }

    /**
     * 先序
     *
     * @return
     */
    private static Node getNode() {
        Node d = new Node("D");
        Node e = new Node("E");
        Node b = new Node("B", d, e);
        Node f = new Node("F");
        Node g = new Node("G");
        Node c = new Node("C", f, g);
        Node a = new Node("A", b, c);
        return a;
    }


    public static void breadthSort(Node node, Queue<Node> queue) {
        if (node == null) {
            return;
        }
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.println(node.getData());
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }
    }


    public static void deepSortWithStackPre(Node node, Stack<Node> stack) {
        if (node == null) {
            return;
        }
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.println(node.getData());
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }

    public static void deepSortWithStackInOrder(Node node, Stack<Node> stack) {
        
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.getLeft();
            } else {
                node = stack.pop();
                System.out.println(node.getData());
                node = node.getRight();
            }
        }
    }

    public static void deepSort(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getData());
        deepSort(node.getLeft());
        deepSort(node.getRight());

    }


}
