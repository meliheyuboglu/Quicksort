import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {23, 35, 61, 1, 13};
        quicksort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));

    }

    public static void quicksort(int[] array, int lowindex, int highindex){
        if(lowindex >= highindex){
            return;
        }
        int pivot = array[highindex];
        int leftpointer = partition(array, lowindex, highindex, pivot);

        quicksort(array, lowindex, leftpointer - 1);
        quicksort(array, leftpointer + 1 , highindex);

    }

    private static int partition(int[] array, int lowindex, int highindex, int pivot) {
        int leftpointer = lowindex;
        int rightpointer = highindex;
        while(leftpointer < rightpointer){
            while(array[leftpointer] <= pivot && leftpointer < rightpointer){
                leftpointer++;
            }
            while(array[rightpointer] >= pivot && leftpointer < rightpointer){
                rightpointer--;
            }
            int temp = array[leftpointer];
            array[leftpointer] = array[rightpointer];
            array[rightpointer] = temp;
        }
        int temp2 = array[leftpointer];
        array[leftpointer] = array[highindex];
        array[highindex] = temp2;
        return leftpointer;
    }
}
