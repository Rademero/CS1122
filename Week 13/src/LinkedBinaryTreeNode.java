import java.util.ArrayList;
import java.util.Stack;

public class LinkedBinaryTreeNode<E> implements BinaryTreeNode<E> {
    E data;
    BinaryTreeNode<E> parent;
    BinaryTreeNode<E> leftChild;
    BinaryTreeNode<E> rightChild;
    int depth = 0;
    public LinkedBinaryTreeNode(E value){
        this.getRoot().setData(value);
    }

    @Override
    /**
     * Returns the data stored in this node.
     */
    public E getData() {
        return data;
    }

    @Override
    /**
     * Modifies the data stored in this node.
     */
    public void setData(E data) {
        this.data = data;
    }

    private void setParent(BinaryTreeNode<E> parent){
        this.parent = parent;
       if(parent!=null) depth = parent.getDepth()+1;
    }

    @Override
    /**
     * Returns the ancestor of this node that has no parent,
     * or returns this node if it is the root.
     */
    public BinaryTreeNode<E> getRoot() {
        if(getParent() != null){
            return parent.getRoot();
        }
        return this;
    }

    @Override
    /**
     * Returns the parent of this node, or null if this node is a root.
     */
    public BinaryTreeNode<E> getParent() {
        return parent;
    }

    @Override
    /**
     * Returns the left child of this node, or null if it does
     * not have one.
     */
    public BinaryTreeNode<E> getLeft() {
        return leftChild;
    }

    @Override
    /**
     * Removes child from its current parent and inserts it as the
     * left child of this node.  If this node already has a left
     * child it is removed.
     */
    public void setLeft(BinaryTreeNode<E> child) {
        leftChild = child;
       if(child!= null) ((LinkedBinaryTreeNode) child).setParent(this);
    }

    @Override
    /**
     * Returns the right child of this node, or null if it does
     * not have one.
     */
    public BinaryTreeNode <E>getRight() {
        return rightChild;
    }

    @Override
    /**
     * Removes child from its current parent and inserts it as the
     * right child of this node.  If this node already has a right
     * child it is removed.
     */
    public void setRight(BinaryTreeNode<E> child) {
        rightChild = child;
        if(child!=null) ((LinkedBinaryTreeNode) child).setParent(this);
    }

    @Override
    /**
     * Returns true if the node has any children.
     * Otherwise, returns false.
     */
    public boolean isParent() {
        return leftChild != null || rightChild != null;
    }

    @Override
    /**
     * Returns true if the node is childless.
     * Otherwise, returns false.
     */
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    @Override
    /**
     * Returns true if the node has a left child
     */
    public boolean hasLeftChild() {
        return leftChild != null;
    }

    @Override
    /**
     * Returns true if the node has a right child
     */
    public boolean hasRightChild() {
        return rightChild != null;
    }

    @Override
    /**
     * Returns the number of edges in the path from the root to this node.
     */
    public int getDepth() {
//        int depth = 0;
//        BinaryTreeNode<E> currentNode = this;
//        while (currentNode.getParent() != null){
//            depth++;
//            currentNode = currentNode.getParent();
//        }
        return depth;
    }

    @Override
    /**
     * Returns the number of edges in the path from the root
     * to the node with the maximum depth.
     */
    public int getHeight() {
        BinaryTreeNode<E> root = getRoot();
        final int[] height = {0};
        root.traversePreorder(node -> {
             depth = node.getDepth();
            if (height[0] < depth){
                height[0] = depth;
            }
        });
        return height[0];
    }

    @Override
    /**
     * Returns the number of nodes in the subtree rooted at this node.
     */
    public int size() {
        final int[] size = {0};
        traversePreorder(node -> {
            size[0]++;
        });
        return size[0];
    }

    @Override
    /**
     * Removes this node, and all its descendants, from whatever
     * tree it is in.  Does nothing if this node is a root.
     */
    public void removeFromParent() {
        BinaryTreeNode<E> parent = getParent();
        if(parent != null){
            if(parent.getLeft() == this){
                parent.setLeft(null);
            }else {
                parent.setRight(null);
            }setParent(null);
        }
    }

    @Override
    /**
     * Returns the path from this node to the specified descendant.
     * If no path exists, returns an empty list.
     */
    public ArrayList<BinaryTreeNode<E>> pathTo(BinaryTreeNode<E> descendant) {
        ArrayList<BinaryTreeNode<E>> path = descendant.pathFrom(this);
        Stack<BinaryTreeNode<E>> stack = new Stack<>();
        for (BinaryTreeNode<E> node : path){
            stack.push(node);
        }
        path = new ArrayList<>();
        while (!stack.isEmpty()){
            path.add(stack.pop());
        }
        return path;
    }

    @Override
    /**
     * Returns the path to this node from the specified ancestor.
     * If no path exists, returns an empty list.
     */
    public ArrayList<BinaryTreeNode<E>> pathFrom(BinaryTreeNode<E> ancestor) {
        ArrayList<BinaryTreeNode<E>> path = new ArrayList<>();
        BinaryTreeNode<E> currentNode = this;
        while (currentNode != ancestor && currentNode != null){
            path.add(currentNode);
            currentNode = currentNode.getParent();
        }
        if(currentNode == null){
            path = new ArrayList<>();
        }else {
            path.add(currentNode);
        }
        return path;
    }

    @Override
    /**
     * Visits the nodes in this tree in preorder.
     */
    public void traversePreorder(Visitor visitor) {
        visitor.visit(this);
        if(hasLeftChild()) getLeft().traversePreorder(visitor);
        if(hasRightChild()) getRight().traversePreorder(visitor);
    }

    @Override
    /**
     * Visits the nodes in this tree in postorder.
     */
    public void traversePostorder(Visitor visitor) {
        if(hasLeftChild()) getLeft().traversePostorder(visitor);
        if(hasRightChild()) getRight().traversePostorder(visitor);
        visitor.visit(this);
    }

    @Override
    /**
     * Visits the nodes in this tree in inorder.
     */
    public void traverseInorder(Visitor visitor) {
        if(hasLeftChild()) getLeft().traverseInorder(visitor);
        visitor.visit(this);
        if(hasRightChild()) getRight().traverseInorder(visitor);
    }
}
