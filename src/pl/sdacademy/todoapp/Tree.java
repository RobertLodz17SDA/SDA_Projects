package pl.sdacademy.todoapp;

public class Tree {

    private Node root;

    void add(Integer value) {
        if (root == null) {
            root = new Node(value, null);
        } else {
            root.add(new Node(value, root));
        }
    }

    public boolean search(int value){
        Node actual = root;
        while (actual!= null && actual.getValue() != value){
            if (actual.getValue() > value){
                actual= actual.getLeft();
            }else{
                actual = actual.getRight();
            }
        }
        if (actual == null)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Root:\n");
        sb.append(root.getValue());
        sb.append("\n");
        sb.append(root.toString());
        return sb.toString();
    }
}