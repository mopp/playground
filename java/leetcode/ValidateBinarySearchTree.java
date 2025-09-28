// 回答を見てから書いたもの
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    // サブツリーの保持可能な値の範囲を持ち続けてチェックする
    // 右側は root よりも全て大きい => 最小値が root である
    // 左側は root よりも全て小さい => 最大値が root である
    private boolean validate(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (min != null && !(min.val < root.val)) {
            return false;
        }
        if (max != null && !(max.val > root.val)) {
            return false;
        }

        return validate(root.left, min, root) && validate(root.right, root, max);
    }
}


class Solution {
    public boolean isValidBST(TreeNode root) {
        var nums = new ArrayList<Integer>();

        // 木を辿って配列にしてから順序を比較する
        // 昇順に並べたいので left から走査する (in-order traversal)
        traverse(root, nums);

        int[] arr = nums
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();

        for (int i = 1; i < arr.length; i++) {
            // 可読性を優先し普遍条件の否定として書く
            if (!(arr[0] < arr[i] && arr[i - 1] < arr[i])) {
                return false;
            }
        }

        return true;
    }

    void traverse(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }

        traverse(root.left, nums);
        nums.add(root.val);
        traverse(root.right, nums);
    }
}
