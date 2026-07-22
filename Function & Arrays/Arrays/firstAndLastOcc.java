package Arrays;

public class firstAndLastOcc {
    public int firstOcc(int[] arr, int tar) {
        int left = 0;
        int right = arr.length - 1;
        int firstOcc = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == tar) {
                firstOcc = mid;
                right = mid - 1;
            } else if (arr[mid] < tar) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return firstOcc;
    }

    public int lastOcc(int[] arr, int tar) {
        int left = 0;
        int right = arr.length - 1;
        int lastOcc = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == tar) {
                lastOcc = mid;
                left = mid + 1;
            } else if (arr[mid] < tar) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return lastOcc;
    }

    public int[] searchRange(int[] arr, int tar) {
        int first = firstOcc(arr, tar);
        int last = lastOcc(arr, tar);
        return new int[] { first, last };
    }

    public static void main(String[] args) {
        int[] arr = { 5, 7, 7, 8, 8, 10 };
        int tar = 6;
        firstAndLastOcc obj = new firstAndLastOcc();
        System.out.println("First occurrence: " + obj.firstOcc(arr, tar));
        System.out.println("Last occurrence: " + obj.lastOcc(arr, tar));
        int[] range = obj.searchRange(arr, tar);
        System.out.println("Search range: [" + range[0] + ", " + range[1] + "]");
    }
}
