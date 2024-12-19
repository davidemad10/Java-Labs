class Task2 {

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; 
            }

            if (arr[mid] < target) {
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        int[] arr = {11, 21, 34, 48, 52, 66, 71, 88, 94, 118};
        int target = 52; 

        
        long startTime = System.nanoTime();
        System.out.println("Start time: " + startTime);

        
        int index = binarySearch(arr, target);

        
        long endTime = System.nanoTime();
        System.out.println("End time: " + endTime);

        
        long elapsedTime = endTime - startTime;

        if (index == -1) {
            System.out.println("Target not found. Time taken: " + elapsedTime + " nanoseconds.");
        } else {
            System.out.println("Target found at index " + index);
            System.out.println("Time taken to find the target using binary search: " + elapsedTime + " nanoseconds.");
        }
    }
}

