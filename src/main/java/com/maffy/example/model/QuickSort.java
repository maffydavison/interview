package com.maffy.example.model;

/**
 * Created with IntelliJ IDEA.
 * User: maryannfinnerty
 * Date: 11/20/13
 * Time: 9:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class QuickSort {

    private int[] numbers;

/*    public QuickSort(int [] numbers) {
        this.numbers = numbers;
    }*/

/*    public void sort(int start, int end) {
        if (start < end) {
            int index = partition(start, end);
            sort(start, index - 1);
            sort(index + 1, end);
        }
    }

    public int [] getNumbers() {
        return numbers;
    }

   private int partition(int start, int end) {
       int pivot = numbers[end];
       int index = start;

       for (int i = start; i < end; i++) {
           if (numbers[i] <= pivot) {
               swap(numbers[i], numbers[index]);
               index++;
           }
       }
       swap(numbers[index], numbers[end]);
       return index;
   }

    private void swap(int start, int end) {
        int temp = numbers[start];
        numbers[start] = numbers[end];
        numbers[end] = temp;
    }*/

    public void sort(int[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
        this.numbers = values;
        int number = values.length;
        quickSort(0, number - 1);
    }

    public int [] getNumbers() {
        return numbers;
    }

    private void quickSort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quickSort(low, j);
        if (i < high)
            quickSort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }


    public static void main(String[] args) {

        int [] array = {1,2,8,3,5,7,2,6,5,9,2,1,0,4,6,9};
        System.out.println("Before sort...");
        for (int i : array) {
            System.out.print(i);
        }
        System.out.println();
        QuickSort sorter = new QuickSort();
        sorter.sort(array);
        System.out.println("After sort...");
        for (int i : sorter.getNumbers()) {
            System.out.print(i);
        }
        System.out.println();

    }
}
