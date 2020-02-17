import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<E extends Comparable<E>> {
    private class Node{
        E value;
        Node leftChild;
        Node rightChild;
        public Node(E value){
            this.value = value;
        }
    }
    Node root;

    int size = 0;
    public int size(){
        return size;
    }public boolean isEmpty(){
        return size <=0;
    }
    public  void add (E value){
        if (value == null){
            throw new IllegalArgumentException("value to be added is null");
        }
        if (root !=null){
            add(root,value);
        }else {
            Node node = new Node(value);
            root = node;
            size++;
        }

    }
    public void  add (Node node ,E value){
        if (value.compareTo(node.value) < 0){
            if (node.leftChild != null){
                add(node.leftChild,value);
            }else{
                Node newNode = new Node(value);
                node.leftChild = newNode;
                size++;
                return;
            }
        }else {
            if (node.rightChild != null){
                add(node.rightChild,value);
            }else{
                Node newNode = new Node(value);
                node.rightChild = newNode;
                size++;
                return;
            }
        }
    }
    public interface Visitor<E>{
        public void Visitor(E value);
    }
    public void inrorderTraversal ( Node node,Visitor visitor){
        if (node == null){
            return;
        }
        inrorderTraversal(node.leftChild,visitor);
        visitor.Visitor(node.value);
        inrorderTraversal(node.rightChild,visitor);
    }
    public void prerorderTraversal ( Node node,Visitor visitor){
        if (node == null){
            return;
        }
        visitor.Visitor(node.value);
        prerorderTraversal(node.leftChild,visitor);
        prerorderTraversal(node.rightChild,visitor);
    }
    public void posrorderTraversal ( Node node,Visitor visitor){
        if (node == null){
            return;
        }
        posrorderTraversal(node.leftChild,visitor);
        posrorderTraversal(node.rightChild,visitor);
        visitor.Visitor(node.value);
    }
    public void depthFrist(Node subTree, Visitor visitor){
        Stack<Node> stack = new Stack<>();
        stack.push(subTree);
        while (!stack.isEmpty()){
            Node currentNode = stack.pop();
            visitor.Visitor(currentNode.value);
            if (currentNode.rightChild != null){
                stack.push(currentNode.rightChild);
            }
           if (currentNode.leftChild != null){
               stack.push(currentNode.leftChild);
           }
        }
    }
    public void breadthFrist(Node subTree, Visitor visitor){
        LinkedList<Node> queue = new LinkedList<>();
        queue.push(subTree);
        while (!queue.isEmpty()){
            Node currentNode = queue.remove();
            visitor.Visitor(currentNode.value);
            if (currentNode.rightChild != null){
                queue.add(currentNode.rightChild);
            }
            if (currentNode.leftChild != null){
                queue.add(currentNode.leftChild);
            }
        }
    }


    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(4);
        tree.add(2);
        tree.add(7);
        tree.add(5);
        tree.add(1);
        ArrayList foo = new ArrayList();
        tree.prerorderTraversal(tree.root,value ->{
            System.out.println(value);
            foo.add(value);
        });
        System.out.println(foo);
        tree.depthFrist(tree.root,value ->{
            System.out.println(value);
            foo.add(value);
        });
        System.out.println(foo);
        tree.breadthFrist(tree.root,value ->{
            System.out.println(value);
            foo.add(value);
        });
    }

}
