package com.semantyca.test.algorithms;

public class BubbleSorter {
    void sort(int array[]) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[0]);
    }

    public static void main(String args[]) {
        BubbleSorter sorter = new BubbleSorter();
        int array[] = {64, 34, 25, 12, 22, 11, 90};
        sorter.sort(array);
        System.out.println("Sorted array");
        sorter.printArray(array);
    }
}
