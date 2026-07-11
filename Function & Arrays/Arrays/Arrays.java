package Arrays;

public class Arrays {
    public static int linearSearch(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int getNumbers(int number[]) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < number.length; i++) {
            if (number[i] > largest) {
                largest = number[i];
            }
            if (number[i] < smallest) {
                smallest = number[i];
            }
        }
        System.out.println("Smallest number is " + smallest);
        return largest;
    }

    public static int binarySearch(int number[], int key) {
        int start = 0;
        int end = number.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (number[mid] == key) {
                return mid;

            }
            if (number[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void reverseArray(int number[]) {
        int start = 0;
        int end = number.length - 1;
        while (start < end) {
            int temp = number[end];
            number[end] = number[start];
            number[start] = temp;
            start++;
            end--;
        }
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i] + " ");
        }
    }

    public static void printPairs(int number[]) {
        for (int i = 0; i < number.length; i++) {
            int curr = number[i];
            for (int j = i + 1; j < number.length; j++) {
                System.out.print("(" + curr + "," + number[j] + ") ");
            }
            System.out.println();
        }
    }

    public static void printSubArrays(int number[]) {
        int ts = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < number.length; i++) {
            for (int j = i; j < number.length; j++) {
                int curr = 0;
                for (int k = i; k <= j; k++) {
                    System.out.print(number[k] + " ");
                    curr = curr + number[k];

                }
                ts++;
                System.out.print("      Subarray (" + i + " to " + j + "): " + curr);

                if (curr < min) {
                    min = curr;
                }
                if (curr > max) {
                    max = curr;
                }

                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total subarrays : " + ts);
        System.out.println("Minimum is : " + min);
        System.out.println("Maximum is : " + max);
    }

    public static void prefixSum(int number[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[number.length];

        prefix[0] = number[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + number[i];
        }

        for (int i = 0; i < number.length; i++) {
            for (int j = i; j < number.length; j++) {
                currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("max sum = " + maxSum);
    }

    public static void kadanes(int number[]) {
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        for (int i = 0; i < number.length; i++) {
            cs += number[i];
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }
        System.out.println("our max subarray sum is : " + ms);
    }

    public static void main(String args[]) {
        int numbers[] = { 2, 4, -6, 8, 10 };
        kadanes(numbers);

    }
}