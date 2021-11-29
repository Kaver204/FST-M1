package activities;

import java.util.Arrays;

public class Activity4 {
	
	 static void insertionSort(int array[]) {
	        int size = array.length, i;
	        
	        for (i = 1; i < size; i++) {
	            int key = array[i];
	            int j = i - 1;
	            
	            while (j >= 0 && key < array[j]) {
	                array[j + 1] = array[j];
	                --j;
	            }
	            array[j + 1] = key;
	        }
	    }
	    
	    public static void main(String args[]) {
	        int[] data = { 11,45, 11, 44, 53 };
	        insertionSort(data);
	        System.out.println("Array in Ascending Order: ");
	        System.out.println(Arrays.toString(data));
	    }

}
