package pl.sdacademy.todoapp;

public class TreeTest {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(50);
        tree.add(20);
        tree.add(60);
        tree.add(5);
        tree.add(540);
        tree.add(2);
        tree.add(5);
        tree.add(20);
        tree.add(2);
        tree.add(5);
        System.out.println(tree);

        System.out.println(tree.search(222));
    }
}