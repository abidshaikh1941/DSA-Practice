package binary.tree;

import java.util.LinkedList;

public class BinaryTree {
    TreeNode root;

    public boolean insertNode(String val){
        if (root == null){
            root = new TreeNode(val);
            return true;
        }
        TreeNode current = root;
        while(true){
            if (current.val.compareTo(val) == 0){
                return false;
            }
            if(current.val.compareTo(val) < 0){
                if (current.left == null){
                    current.left = new TreeNode(val);
                    return true;
                } else {
                    current = current.left;
                }
            }
            if(current.val.compareTo(val) > 0){

                if (current.right == null){
                    current.right = new TreeNode(val);
                    return true;
                } else {
                    current = current.right;
                }

            }
        }


    }


    public void inOrderTraversal()
    {
        System.out.println("Printing inOrderTraversal");
        inOrderTraversal(root);
    }
    private void inOrderTraversal(TreeNode root)
    {
        if (root != null){
            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }
    }

    public void preOrderTraversal()
    {
        System.out.println("Printing preOrderTraversal");
        preOrderTraversal(root);
    }
    private void preOrderTraversal(TreeNode root)
    {
        if (root != null){
            System.out.print(root.val + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public void postOrderTraversal()
    {
        System.out.println("Printing postOrderTraversal");
        postOrderTraversal(root);
    }
    private void postOrderTraversal(TreeNode root)
    {
        if (root != null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }

    public void levelOrderTraversal(){
        System.out.println("Printing levelOrderTraversal");
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) return;

        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }




    public void inOrderTraversalIterative() {
        if (root == null)
            return;

        TreeNode curr = root;
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.print(curr.val + " ");

            curr = curr.right;
        }
    }
}
