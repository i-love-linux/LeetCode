package _0427_Construct_Quad_Tree;

/**
 * Date: 2021/6/1 14:24
 * 执行用时：3 ms, 在所有 Java 提交中击败了12.40%的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了82.65%的用户
 */
public class Solution {

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    };

    int[][] s;

    public Node construct(int[][] grid) {
        int n = grid.length;
        s = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + grid[i - 1][j - 1];
        return dfs(1, 1, n, n);
    }

    private Node dfs(int x1, int y1, int x2, int y2) {
        int n = x2 - x1 + 1;
        int sum = s[x2][y2] - s[x2][y1 - 1] - s[x1 - 1][y2] + s[x1 - 1][y1 - 1];
        if (sum == 0 || sum == n * n) return new Node(sum != 0, true);
        Node node = new Node(false, false);
        int m = n / 2;
        node.topLeft = dfs(x1, y1, x1 + m - 1, y1 + m - 1);
        node.topRight = dfs(x1, y1 + m, x1 + m - 1, y2);
        node.bottomLeft = dfs(x1 + m, y1, x2, y1 + m - 1);
        node.bottomRight = dfs(x1 + m, y1 + m, x2, y2);
        return node;
    }
}
