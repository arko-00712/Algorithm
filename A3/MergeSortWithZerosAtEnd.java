import java.util.Arrays;

public class MergeSortWithZerosAtEnd {

    // Function to merge two halves of the array
    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays for left and right subarrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        // Merge the arrays
        int i = 0, j = 0, k = left;

        // Merge the non-zero elements first
        while (i < n1 && j < n2) {
            if (leftArr[i] != 0 && rightArr[j] != 0) {
                if (leftArr[i] <= rightArr[j]) {
                    arr[k++] = leftArr[i++];
                } else {
                    arr[k++] = rightArr[j++];
                }
            } else if (leftArr[i] != 0) {
                arr[k++] = leftArr[i++];
            } else if (rightArr[j] != 0) {
                arr[k++] = rightArr[j++];
            } else {
                i++;
                j++;
            }
        }

        // Add remaining elements from leftArr
        while (i < n1 && leftArr[i] != 0) {
            arr[k++] = leftArr[i++];
        }

        // Add remaining elements from rightArr
        while (j < n2 && rightArr[j] != 0) {
            arr[k++] = rightArr[j++];
        }
    }

    // Function to implement merge sort
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively sort the two halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        // Sample input array
        int[] arr = {0, 1, 4, 1, 7, 9, 0};

        // Count the zeros and filter out the zeros
        int zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroCount++;
            }
        }

        // Create a new array with only non-zero elements
        int[] nonZeroArray = new int[arr.length - zeroCount];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                nonZeroArray[index++] = arr[i];
            }
        }

        // Perform merge sort on the non-zero elements
        mergeSort(nonZeroArray, 0, nonZeroArray.length - 1);

        // Rebuild the original array with the sorted non-zero elements and zeros at the end
        index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (index < nonZeroArray.length) {
                arr[i] = nonZeroArray[index++];
            } else {
                arr[i] = 0;  // Place zeros at the end
            }
        }

        // Print the sorted array with zeros at the end
        System.out.println(Arrays.toString(arr));
    }
}