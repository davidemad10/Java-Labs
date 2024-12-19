import java.util.Random;

class Task1 {

    public static int[] populateArray() {
        int[] array = new int[100];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1;
        }

        array[80] = 10; 
        return array;
    }
    

    
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int[] arr = populateArray(); 
        int target = 10; 

        
        long startTime = System.nanoTime();
        System.out.println("Start time: " + startTime);

        
        int index = linearSearch(arr, target);

        
        long endTime = System.nanoTime();
        System.out.println("End time: " + endTime);

        
        long elapsedTime = endTime - startTime;

        if (index != -1) {
            System.out.println("Target found at index " + index);
            System.out.println("Time taken to compute the task: " + elapsedTime + " nanoseconds");
        } else {
            System.out.println("Target not found.");
            System.out.println("Time taken to compute the task: " + elapsedTime + " nanoseconds");
        }
    }
}

