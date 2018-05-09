package pl.sdacademy.todoapp;

import java.util.LinkedList;
import java.util.List;

public class MyTree {

    List<MyNode> root;

    public void add(int value){
        if ( root == null){
            root = new LinkedList<>();
        }
    }

}
