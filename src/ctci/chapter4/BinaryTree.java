package ctci.chapter4;

import java.util.Stack;

public class BinaryTree {

    protected BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof BinaryTree)) {
            return false;
        }

        BinaryTree other = (BinaryTree) o;
        Stack<BinaryTreeNode> thisStack = new Stack<>();
        Stack<BinaryTreeNode> otherStack = new Stack<>();

        if (root != null) {
            thisStack.add(root);
        }

        if (other.root != null) {
            otherStack.add(other.root);
        }

        while(!thisStack.isEmpty() && !otherStack.isEmpty()) {
            BinaryTreeNode thisCurr = thisStack.pop();
            BinaryTreeNode otherCurr = otherStack.pop();

            if (!thisCurr.equals(otherCurr)) {
                return false;
            }

            if (thisCurr.getLeft() != null) {
                thisStack.add(thisCurr.getLeft());
            }
            if (otherCurr.getLeft() != null) {
                otherStack.add(otherCurr.getLeft());
            }
            if (thisCurr.getRight() != null) {
                thisStack.add(thisCurr.getRight());
            }
            if (otherCurr.getRight() != null) {
                otherStack.add(otherCurr.getRight());
            }
        }

        return thisStack.isEmpty() && otherStack.isEmpty();
    }
}
