package ctci.chapter4;

public class BinaryTreeNode {

    private BinaryTreeNode right;
    private BinaryTreeNode left;

    private int data;

    public BinaryTreeNode(int data) {
        right = null;
        left = null;
        this.data = data;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode node) {
        right = node;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode node) {
        left = node;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof BinaryTreeNode)) {
            return false;
        }

        BinaryTreeNode other = (BinaryTreeNode) o;
        return this.data == other.getData();
    }
}
