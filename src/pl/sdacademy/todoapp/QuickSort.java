package pl.sdacademy.todoapp;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    private List<Integer> arrayToBeSorted = new ArrayList<>();

    QuickSort() {
        this.arrayToBeSorted.add(1);
        this.arrayToBeSorted.add(4);
        this.arrayToBeSorted.add(3);
        this.arrayToBeSorted.add(22);
        this.arrayToBeSorted.add(32);
        this.arrayToBeSorted.add(4);
        this.arrayToBeSorted.add(5);
        this.arrayToBeSorted.add(66);
        this.arrayToBeSorted.add(7);
        this.arrayToBeSorted.add(8);
        this.arrayToBeSorted.add(9);
        this.arrayToBeSorted.add(10);
        this.arrayToBeSorted.add(11);
        this.arrayToBeSorted.add(4);
        this.arrayToBeSorted.add(6);
        this.arrayToBeSorted.add(10);
        this.arrayToBeSorted.add(5);
        this.arrayToBeSorted.add(2);
    }

    private int swapElementsSetPivot(int index) {
        int item = arrayToBeSorted.get(index - 1);
        arrayToBeSorted.set(index - 1, arrayToBeSorted.get(index));
        arrayToBeSorted.set(index, item);
        return index - 1;
    }

    private int sortRangeSetPivot(int lowRangePos, int listMaxIndex) {
        int item;
        int pivotPosition = listMaxIndex;
        for (int i = lowRangePos; i < pivotPosition; i++) {
            if (pivotPosition - i <= 1) {
                if (arrayToBeSorted.get(i) >= arrayToBeSorted.get(pivotPosition)) {
                    pivotPosition = swapElementsSetPivot(pivotPosition);
                }
            } else {
                if (arrayToBeSorted.get(i) >= arrayToBeSorted.get(pivotPosition)) {
                    item = arrayToBeSorted.get(pivotPosition - 1);
                    arrayToBeSorted.set((pivotPosition - 1), arrayToBeSorted.get(pivotPosition));
                    arrayToBeSorted.set(pivotPosition, arrayToBeSorted.get(i));
                    arrayToBeSorted.set(i, item);
                    pivotPosition--;
                    i--;
                }
            }
        }
        return pivotPosition;
    }

    private void doSort(int lowRange, int hiRange) {
        if (hiRange - lowRange <= 0) {
            return;
        } else {
            int pivot = sortRangeSetPivot(lowRange, hiRange);
            doSort(lowRange, pivot - 1);
            doSort(pivot + 1, hiRange);
        }
    }

    private void printArray() {
        System.out.print("array values are : ");
        for (int i = 0; i < arrayToBeSorted.size(); i++) {
            System.out.print(arrayToBeSorted.get(i) + "  ");
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSort sortedArr = new QuickSort();
        System.out.print("Initial ");
        sortedArr.printArray();
        int lowRangeIndex = 0;
        int listMaxIndex = sortedArr.arrayToBeSorted.size() - 1;
        sortedArr.doSort(lowRangeIndex, listMaxIndex);
        System.out.print("Sorted ");
        sortedArr.printArray();
    }
}
