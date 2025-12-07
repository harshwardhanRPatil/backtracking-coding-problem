package OOPS_and_Java_Concepts;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class lambda {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("bob", "Charlie","Alice", "David");

        // Sort the list in a case-insensitive manner using lambda expression
        names.sort((s1, s2) -> s1.compareToIgnoreCase(s2));

        // Print the sorted list
        names.forEach(System.out::print);

//        paladrom
        String input = "radar";
        Predicate<String> ans=str->{
          String revesr    =new StringBuilder(str).reverse().toString();
            return str.equals(revesr);
        };
        System.out.println("is paladrom" +ans.test(input) );

//
//Filter even numbers from a list of integers:
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Predicate<Integer> isEven = x -> x % 2 == 0;

        List<Integer> evenNumbers = numbers.stream().filter(isEven).collect(Collectors.toList());

        numbers.stream().filter(x -> x % 2 == 0).map(x -> x ^ 2).forEach(System.out::print);
//        System.out.println("Even numbers: " + evenNumbers);
        int a = 3;
        int b = 23;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a value " + a);
        System.out.println("b value " + b);


        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        System.out.println("Original array: " + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));



    }
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
