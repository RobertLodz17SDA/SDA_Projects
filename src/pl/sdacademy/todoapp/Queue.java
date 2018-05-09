package pl.sdacademy.todoapp;

import java.util.Scanner;

public class Queue<T> {
    private final static int SIZE = 5;
    private Object[] array;
    private int index;

    public Queue() {
        array = new Object[SIZE];
    }

    public T pop() {
        Object element;
        element = array[0];
        for (int i = 0; i < index; i++) {
            array[i] = array[i + 1];
        }
        array[index] = null;
        index--;
        return (T) element;
    }

    public void push(T element) {
        if (index >= array.length - 1) {

        }
    }

    public T peek() {
        return (T) array[0];
    }

    public int size() {
        return index;
    }
        int operationID;
        Queue poppedObject;

    private void extendedQueue() {

    }

    //    Queue ourStackExample = new Queue<>();
    //    Scanner scanner = new Scanner(System.in);
    //    while (true) {
    //        System.out.println("Podaj kod operacji : ");
    //        System.out.println("Dostępne kody : 1-PUSH, 2-POP, 3-PEEK, 4-SIZE, 5-QUIT");
    //        operationID = scanner.nextInt();
    //        switch (operationID) {
     //           case 1:
    //                System.out.println("Podaj liczbę do umieszczenia na stosie : ");
    //                ourStackExample.push(scanner.nextInt());
    //                break;
   //             case 2:
 //   public static void main(String[] var args) {
    //                poppedObject = ourStackExample.pop();
//
  //                  System.out.println("Pobrana liczba : " + poppedInteger);
    //                break;
      //          case 3:
        //            poppedInteger = ourStackExample.peek();
          //          System.out.println("Pobrana liczba : " + poppedInteger);
            //        break;
              //  case 4:
  //                  System.out.println("Wielkość stosu : " + ourStackExample.size());
    //                break;
      //          case 5:
        //            return;
          //  }
//        }
      //      ourStackExample.print();
   // }
}
