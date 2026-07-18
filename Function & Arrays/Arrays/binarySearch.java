package Arrays;

public class binarySearch {
    public static int binSearch(int arr[], int key){
        int left = 0;
        int right = arr.length-1;
        while (left<=right) {
            int mid = (left+ right)/2;
            if(arr[mid]==key){
                return mid;
            }
            if(arr[mid]<key){
                left=mid+1;
            }
            else{
                right= mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr = {3,5,8,9,10,11,14};

        int key = 10;
        int idx = binSearch (arr, key);

        System.out.println("Target exists at index: " + idx);
    }
}
