import java.util.Scanner;

public class PowerLevelSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] powerLevels = new int[10];

        // Input power levels
        System.out.println("Enter the power levels of 10 creatures:");
        for (int i = 0; i < 10; i++) {
            powerLevels[i] = scanner.nextInt();
        }

        // Bubble Sort (Ascending Order)
        bubbleSort(powerLevels);
        System.out.println("Power levels after Bubble Sort (Ascending):");
        printArray(powerLevels);

        // Selection Sort (Descending Order)
        selectionSort(powerLevels);
        System.out.println("Power levels after Selection Sort (Descending):");
        printArray(powerLevels);

        // Calculate and Display Analysis
        int evenSum = 0, oddSum = 0, min = powerLevels[0], max = powerLevels[0];
        for (int powerLevel : powerLevels) {
            if (powerLevel % 2 == 0) {
                evenSum += powerLevel;
            } else {
                oddSum += powerLevel;
            }
            min = Math.min(min, powerLevel);
            max = Math.max(max, powerLevel);
        }

        System.out.println("Sum of even power levels: " + evenSum);
        System.out.println("Sum of odd power levels: " + oddSum);
        System.out.println("Minimum power level: " + min);
        System.out.println("Maximum power level: " + max);

        scanner.close();
    }

    // Bubble Sort implementation
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in inner loop, then break
            if (!swapped)
                break;
        }
    }

    // Selection Sort implementation
    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] > arr[minIndex])
                    minIndex = j;

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Utility function to print an array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}