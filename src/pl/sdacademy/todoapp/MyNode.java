package pl.sdacademy.todoapp;

import java.awt.*;
import java.util.*;
import java.util.List;

public class MyNode {

    MyNode parent;
    List<MyNode> children;
    int value;

    MyNode(int value, MyNode parent) {
        this.value = value;
        this.parent = parent;
    }

    private void addNode(int value, MyNode node) {
        if (children == null) {
            children = new LinkedList<MyNode>();
        }
    }
}
