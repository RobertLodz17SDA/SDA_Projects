package pl.sdacademy.todoapp;

import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {
        int[] tablica = randomGenerated(30, 1000);
//        int[] tablica = {1,3,2,6,5,20,4,7,9,8,10,2};
        System.out.print("Wejściowy ciąg liczb : ");
        printTable(tablica);
        tablica = bubbleSortUpTable(tablica);
        System.out.print("Wyjściowy ciąg liczb : ");
        printTable(tablica);
    }

    private static int[] randomGenerated(int size, int rangeUpper) {
        int[] tableGenerated = new int[size];
        Random random = new Random();
        for (int i = 0; i < tableGenerated.length; i++) {
            tableGenerated[i] = random.nextInt(rangeUpper);
        }
        return tableGenerated;
    }

    private static int[] bubbleSortUpTable(int[] table) {
        int helpVar;
        boolean control = true;
        while (control) {
            control = false;
            for (int i = 1; i < table.length; i++)
                if (table[i] < table[i - 1]) {
                    swapElements(table, i);
                    control = true;
                }
        }
        return table;
    }

    private static void swapElements(int[] table, int i) {
        int helpVar;
        helpVar = table[i - 1];
        table[i - 1] = table[i];
        table[i] = helpVar;
    }

    private static void printTable(int[] table) {
        for (int e : table) {
            System.out.print(" " + e);
        }
        System.out.println();
    }
}
