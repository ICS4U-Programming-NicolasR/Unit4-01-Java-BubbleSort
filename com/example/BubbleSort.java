package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Sort with bubble sort.
 *
 * @author Mr. Riscalas
 * @version 1.0
 * @since 2023-05-09
 */
public final class BubbleSort {
    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private BubbleSort() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * This is the bubbleSort method.
    *
    * @param nums // the numbers
    * @return nums
    */
    public static int[] bubbleSort(int[] nums) {
        // nested for loop for bubble sort this is the standard algorithm
        for (int i = 0; i <= nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    final int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    /**
    * This is the main method.
    *
    * @param args //unused
    */
    public static void main(final String[] args) {
        // Set the input and output file paths
        final String inputFilePath = "input.txt";
        final String outputFilePath = "output.txt";
        // Read input from file using Scanner
        try (Scanner inputFile = new Scanner(new File(inputFilePath));
            FileWriter writer = new FileWriter(outputFilePath)) {
            // sort each line using the bubble sort method
            while (inputFile.hasNextLine()) {
                // strip the string and convert to int
                final String numberStr = inputFile.nextLine().strip();
                // split the values by spaces
                final String[] numbersSplit = numberStr.split(" ");
                // create the numbers integer array
                final int[] numbers = new int[numbersSplit.length];
                for (int i = 0; i < numbers.length; i++) {
                    try {
                        numbers[i] = Integer.parseInt(numbersSplit[i]);
                    } catch (NumberFormatException error) {
                        System.err.println("Incorrect input: "
                                + error.getMessage());
                    }
                }
                // sort the numbers then display
                final int[] sortedNums = bubbleSort(numbers);
                writer.write("Your array sorted is"
                    + Arrays.toString(sortedNums) + "\n");
            }
        } catch (FileNotFoundException error) {
            System.err.println("File not found: " + error.getMessage());
        } catch (IOException error) {
            System.err.println("Error writing to file: " + error.getMessage());
        }
    }
}
