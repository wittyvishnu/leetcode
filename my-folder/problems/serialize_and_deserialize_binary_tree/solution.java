/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    StringBuilder sb=new StringBuilder();
    int index;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        preorder(root);
        sb.setLength(sb.length() - 1);
        return sb.toString();
        
    }
    public void preorder(TreeNode root){
        if(root==null){
            sb.append('#').append(',');
            return;
        }
         sb.append(root.val).append(',');
         preorder(root.left);
         preorder(root.right);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int index=0;
        String[] parts = data.split(",");
        return build(parts);
    }
     private TreeNode build(String[] parts) {
        if (parts[index].equals("#")) {
            index++;
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(parts[index]));
        index++;
        node.left=build(parts);
        node.right=build(parts);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));