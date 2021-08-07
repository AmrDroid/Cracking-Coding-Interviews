package amazon;

public class MaxArrayElement100 {
    public void findMinMax(int[] array, int start, int end) {
        if (start < 0 || end >= array.length || start > end)
            System.out.println("Invalid inputs");
        else {
            int tmpMin, tmpMax;
            int min = end;
            int max = end;
            // for loop checks even number of entries starting from array[start],
            // up to array[end] or array[end-1], depending if (end-start+1)%2==0 or not
            for (int i = start; i < end; i+=2) {
                if (array[i] <= array[i+1]) {
                    tmpMin = i;
                    tmpMax = i+1;
                }
                else { // array[i] > array[i+1]
                    tmpMin = i+1;
                    tmpMax = i;
                }
                min = ( array[min] <= array[tmpMin] ) ? min : tmpMin;
                max = ( array[max] >= array[tmpMax] ) ? max : tmpMax;
            }
            System.out.println("Min = " + Integer.toString(array[min]) + " at index " + Integer.toString(min));
            System.out.println("Max = " + Integer.toString(array[max]) + " at index " + Integer.toString(max));
        }
    }

//    Suppose there is array contains 100 unsorted elements ...say a[1] to a[100].
//    find out the minimum and maximum value in the range of a[25] to a[75].

}
