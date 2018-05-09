package pl.sdacademy.todoapp;

import java.util.ArrayList;
import java.util.List;

public class StackSimulation {
    private List<Integer> simulatedStack = new ArrayList<>();

    void push(int i) {
        int stackSize;
        stackSize = simulatedStack.size();
        simulatedStack.set(stackSize, i);
    }

    private int pop() {
        int popValue;
        int elementPosition;
        elementPosition = simulatedStack.size() - 1;
        popValue = simulatedStack.get(elementPosition);
        simulatedStack.remove(elementPosition);
        return popValue;
    }

    private int peek() {
        int elementPosition;
        elementPosition = simulatedStack.size() - 1;
        return simulatedStack.get(elementPosition);
    }

    private int size() {
        return simulatedStack.size();
    }

    void print(int noElementsByRow) {
        int printValueOfStack;

    }

    public static void main(String[] args) {

    }
}