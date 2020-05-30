package LC.binaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class BinTreeFInPost {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    static Map<Integer, Integer> positions = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            positions.put(inorder[i], i);
        }
        int in[]={inorder.length-1};
        TreeNode root = build(inorder, postorder,0, inorder.length-1,in);
        //preOrder(root);
        return root;
    }

    TreeNode build(int inorder[], int postorder[], int start, int end, int in[]){
        if(start>end){
            return null;
        }
        TreeNode root = new TreeNode(postorder[in[0]]);
        in[0]--;
        if(start == end){
            return root;
        }

        root.right = build(inorder, postorder, positions.get(root.val)+1, end,in);
        root.left = build(inorder, postorder,start, positions.get(root.val)-1, in);


        return root;
    }

    public static void main(String[] args) {
        int inorder[] = {2,1,4,3,5};
        int postorder[] = {2,4,5,3,1};
        new BinTreeFInPost().buildTree(inorder, postorder);
    }
}
