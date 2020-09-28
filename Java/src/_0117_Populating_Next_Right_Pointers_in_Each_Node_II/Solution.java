package _0117_Populating_Next_Right_Pointers_in_Each_Node_II;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 2020/9/28 8:36
 * Content:
 * 层次遍历
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int levelNum = 1;

        while (!queue.isEmpty()) {
            int newLevelNum = 0;
            Node curNode = new Node();
            for (int i = 0; i < levelNum; i++) {
                Node node = queue.remove();
                curNode.next = node;
                curNode = curNode.next;
                if (node.left != null) {
                    queue.add(node.left);
                    newLevelNum++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    newLevelNum++;
                }
            }
            curNode.next = null;
            levelNum = newLevelNum;
        }

        return root;
    }
}
