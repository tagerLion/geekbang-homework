package cn.emmayu.homework.week.third;

public class BuildTree {

    private int[] inorder;
    private int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return build(0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode build(int s1, int l1, int s2, int l2) {
        if (s1 > l1 || s2 > l2) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[l2]);
        int mid = s1;
        while (inorder[mid] != root.val) {
            mid++;
        }
        root.left = build(s1, mid - 1, s2, s2 + mid - s1 -1);
        root.right = build(mid + 1, l1, s2 + mid - s1, l2 - 1);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
