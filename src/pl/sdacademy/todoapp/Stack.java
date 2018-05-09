package pl.sdacademy.todoapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stack {
    private Integer[] simTableStack = new Integer[30];
    private int stackIndex = -1;

    private void push(int i) {
        stackIndex += 1;
        simTableStack[stackIndex] = i;
    }

    private int pop() {
        int popValue;

        if (stackIndex < 0) {
            System.out.println("lista nie zawiera żadnych elementów. Zwrócono wartość ZERO");
            return 0;
        } else {
            popValue = simTableStack[stackIndex];
            stackIndex -= 1;
            return popValue;
        }
    }

    private int peek() {
        int popValue;

        if (stackIndex < 0) {
            System.out.println("lista nie zawiera żadnych elementów. Zwrócono wartość ZERO");
            return 0;
        } else {
            popValue = simTableStack[stackIndex];
            return popValue;
        }
    }

    private int size() {
        return stackIndex + 1;
    }

    private void print() {
        int printedValueOfStack;

        System.out.println("Elementy stosu : ");
        for (int i = 0; i <= stackIndex; i++) {
            System.out.print(simTableStack[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int operationID;
        int poppedInteger;
        Stack ourStackExample = new Stack();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Podaj kod operacji : ");
            System.out.println("Dostępne kody : 1-PUSH, 2-POP, 3-PEEK, 4-SIZE, 5-QUIT");
            operationID = scanner.nextInt();
            switch (operationID) {
                case 1:
                    System.out.println("Podaj liczbę do umieszczenia na stosie : ");
                    ourStackExample.push(scanner.nextInt());
                    break;
                case 2:
                    poppedInteger = ourStackExample.pop();
                    System.out.println("Pobrana liczba : " + poppedInteger);
                    break;
                case 3:
                    poppedInteger = ourStackExample.peek();
                    System.out.println("Pobrana liczba : " + poppedInteger);
                    break;
                case 4:
                    System.out.println("Wielkość stosu : " + ourStackExample.size());
                    break;
                case 5:
                    return;
            }
            ourStackExample.print();
        }
    }
}
