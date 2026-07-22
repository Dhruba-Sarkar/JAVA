package Arrays;

public class findFloorAndCeil {
    public static void floorAndCeil(int[] arr, int tar) {
        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == tar) {
                floor = arr[mid];
                ceil = arr[mid];
                break;

            } else if (arr[mid] < tar) {
                floor = arr[mid];
                left = mid + 1;
            } else {
                ceil = arr[mid];
                right = mid - 1;
            }
        }

        System.out.println("Floor: " + floor);
        System.out.println("Ceil: " + ceil);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 8, 9, 10, 11, 14 };
        int tar = 13;
        floorAndCeil(arr, tar);
    }
}
