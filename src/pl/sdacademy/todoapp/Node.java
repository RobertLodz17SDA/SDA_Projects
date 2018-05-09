package pl.sdacademy.todoapp;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Node {
    private Node parent;
    private Node left;
    private Node right;
    private Integer value;

    public Node(Integer value, Node parent) {
        this.value = value;
        this.parent = parent;
    }

    public Integer getValue() {
        return value;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public Node getParent() {
        return parent;
    }

    public void add(Node node) {
        Node actual = this;
        Node parent = null;
        while (actual != null) {
            parent = actual;
            if (actual.value > node.getValue()) {
                actual = actual.left;
            } else {
                actual = actual.right;
            }
        }

        if (parent.value > node.getValue()) {
            parent.left = node;
            parent.left.parent = parent;
        } else {
            parent.right = node;
            parent.right.parent = parent;
        }
    }

    private int minValue(Node actual) {
        int value = actual.getValue();
        if (actual.getLeft() != null) {
            if (value > actual.getLeft().getValue()) {
                value = minValue(actual.getLeft());
            }
        }
        if (actual.getRight() != null) {
            if (value > actual.getRight().getValue()) {
                value = minValue(actual.getRight());
            }
        }
        return value;
    }

    public boolean search(int value){
        Node actual = this;
        while (actual!= null && actual.value != value){
            if (actual.value > value){
                actual= actual.left;
            }else{
                actual = actual.right;
            }
        }
        if (actual == null)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}