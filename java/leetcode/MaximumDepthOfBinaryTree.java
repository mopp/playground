class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// Pair の要素の方が案外メモリ消費が多かったりするだろうか？
// 提出結果を見ると案外そうかも
record Pair(int depth, TreeNode n) {}
int maxDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }

    Stack<Pair> stack = new Stack<>();
    stack.push(new Pair(1, root));

    int depth = -1;
    while (stack.empty() == false) {
        var curr = stack.pop();

        if (curr.node.left != null) {
            stack.push(new Pair(curr.depth + 1, curr.node.left));
        }

        if (curr.node.right != null) {
            stack.push(new Pair(curr.depth + 1, curr.node.right));
        }

        if (depth < curr.depth) {
            depth = curr.depth;
        }
    }

    return depth;
}

// stack 分のメモリがもったいないのでループに書き換える
int maxDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }

    var rn = 1 + maxDepth(root.right);
    var ln = 1 + maxDepth(root.left);

    return rn < ln ? ln : rn;
}
