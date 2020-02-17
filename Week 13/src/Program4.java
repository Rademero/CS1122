import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*Samuel Milner & Michael Romero
cs1122 Program4
4/25/2019
 */

public class Program4 {
    Scanner input = new Scanner(System.in);
    String answer;
    LinkedBinaryTreeNode<String> root;
    LinkedBinaryTreeNode<String> currentNode;
    private int counter = 0;

    //helper classes to separate questions from answers
    public class Answer<E> extends LinkedBinaryTreeNode<E>{ public Answer(E value) {
        super(value);
    }}
    public class Question<E> extends LinkedBinaryTreeNode<E>{ public Question(E value) {
        super(value);
    }}

    //@param Filename is the name of the file we are loading
    //loads all of the questions and answers form the the file into a LinkedBinaryTree list
    public LinkedBinaryTreeNode<String> load(String Filename) throws FileNotFoundException {
        File phile = new File(Filename);
        Scanner scan = new Scanner(phile);
        String lne = scan.nextLine();
        if(lne.startsWith("A")) {
            Answer Answer = new Answer(lne);
            root = Answer;
        }
        if (lne.startsWith("Q")){
            Question question = new Question(lne);
            root = question;
            currentNode = question;
        }
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if(line.startsWith("Q")) {
                Question question = new Question(line);
                if(currentNode.getLeft() == null) {
                    currentNode.setLeft(question);
                    currentNode = question;
                }
                else if(currentNode.getRight() == null) {
                    currentNode.setRight(question);
                    currentNode = question;
                } else {
                    if(currentNode != root) {
                        loadHelper((LinkedBinaryTreeNode<String>) currentNode.getParent()).setRight(question);
                        currentNode = question;
                    }
                }
            }
            if (line.startsWith("A")) {
                Answer answer = new Answer(line);
                if(currentNode.getLeft() == null) {
                    currentNode.setLeft(answer);
                }
                else if(currentNode.getRight() == null) {
                    currentNode.setRight(answer);
                } else {
                    if (currentNode != root) {
                        loadHelper((LinkedBinaryTreeNode<String>) currentNode.getParent()).setRight(answer);
                    }
                }
            }
        }
        return(root);
    }
    //@param parent the parent to the current node a current node
    //@return LinkedBinaryTreeNode to use recession or to go back up the tree
    //only to get a parent with an open right node
    public LinkedBinaryTreeNode<String> loadHelper(LinkedBinaryTreeNode<String> parent) {
        if(parent.getRight() == null) { return parent; }
        else return loadHelper((LinkedBinaryTreeNode<String>) parent.getParent());
    }
    //@param currentNode is to keep track of where in the list to add a node
    //Used to ask questions to the user and call for other actions
    //Goes ad infinitum. Can be used to create trees of whatever size you like.
    public void runGame(LinkedBinaryTreeNode<String> currentNode) {
        Scanner ques = new Scanner(System.in);
        System.out.println(currentNode.getData());
        String answer = ques.next();
        if (answer.equals("yes")){
            if (currentNode.hasRightChild()) {
                runGame((LinkedBinaryTreeNode<String>) currentNode.getRight());
            } else System.out.println("Hey I got it!");
        } else if (answer.equals("no")) {
            if (currentNode.hasLeftChild()) {
                runGame((LinkedBinaryTreeNode<String>) currentNode.getLeft());
            } else {
                addQuestion(currentNode);
                runGame(root);
            }
        } else {
            System.out.println("Please enter either 'yes' or 'no'");
            runGame(currentNode);
        }
    }
    //@param node is used check it's current position within the tree
    //used to add a question to the try base off of it's position within the tree
    public void addQuestion(LinkedBinaryTreeNode<String> node){
        System.out.println("What was the animal?");
        answer = "A:" + input.nextLine();
        Answer Answer = new Answer(answer);
        System.out.println("How can we tell the difference?");
        answer = "Q:" + input.nextLine();
        Question question = new Question(answer);
        if(node == root) {
            question.setRight(Answer);
            question.setLeft(node);
            if(node == root) {
                root = question;
            }
        } else {
            LinkedBinaryTreeNode<String> oldAnswer;
            if(node.getLeft() == null) {
                oldAnswer = node;
            } else oldAnswer = (LinkedBinaryTreeNode<String>) node.getLeft();

            if(node.getParent().getRight() == node) {
                node.getParent().setRight(question);
            } else node.getParent().setLeft(question);
            question.setRight(Answer);
            question.setLeft(oldAnswer);
        }
        write(root);
    }
    //@param node is used to keep track of the current position within the tree
    //writes the tree out to a new file
    public void write(LinkedBinaryTreeNode<String> node) {
        PrintWriter print = null;
        ArrayList<String> list = new ArrayList<>();
        node.traversePreorder(value -> {
            list.add(value.getData().toString());
        } );
        try {
            print = new PrintWriter("tree.data");
            for (String s: list) {
                print.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            print.close();
        }
    }
    //EXTRA CREDIT computer gets 20 tries to guess animal
    public void twentyQuestionsGame(LinkedBinaryTreeNode<String> currentNode) {
        Scanner ques = new Scanner(System.in);
        while (counter < 21) {
            System.out.println(currentNode.getData());
            counter++;
            String answer = ques.next();
            if (answer.equals("yes")){
                if (currentNode.hasRightChild()) {
                    twentyQuestionsGame((LinkedBinaryTreeNode<String>) currentNode.getRight());
                } else {
                    System.out.println("Hey I got it!");
                    counter = 25;
                }
            } else if (answer.equals("no")) {
                if (currentNode.hasLeftChild()) {
                    twentyQuestionsGame((LinkedBinaryTreeNode<String>) currentNode.getLeft());
                } else {
                    System.out.println("I have no idea what animal it could be! You win!!!");
                    addQuestion(currentNode);
                    counter = 25;
                }
            } else {
                System.out.println("Please enter either 'yes' or 'no'");
                twentyQuestionsGame(currentNode);
            }
        } if (counter == 21) { System.out.println("I couldn't guess your animal in twenty questions! You Win!!");}
    }

    //Main method to start the program
    public static void main(String[] args) throws FileNotFoundException {
        Program4 p = new Program4();
        System.out.println("Welcome to the Animals game!" +"\n" + "Shall we play a game? Enter 'tq' to play twenty questions, enter 'run' to run the main program to make a tree");
        Scanner startInput = new Scanner(System.in);
        String play = startInput.next();
        if (play.equals("tq")){
            //twentyQuestionsGame is part of extra credit
            p.twentyQuestionsGame(p.load("tree.data"));
        } else if (play.equals("run")) {
            //main project
            p.runGame(p.load("tree.data"));
        } else if (play.equals("no")) {
            System.out.println("Have a good day");
        } else {
            System.out.println("What");
        }
    }
}
