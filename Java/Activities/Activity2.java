package activities;

import java.util.Arrays;

public class Activity2 {
	
	 public static void main(String[] args) {
	        //Initialize the array
	        int[] numArr = {10, 77, 10, 54, -11, 10};
	        System.out.println("Array: " + Arrays.toString(numArr));
	        
	        //Set constants
	        int searchNum = 10;
	        int fixedSum = 30;

	        System.out.println("Result: " + result(numArr, searchNum, fixedSum));
	    }

	    public static boolean result(int[] numbers, int searchNum, int fixedSum) {
	        int temp_sum = 0;
	        for (int number : numbers) {
	            if (number == searchNum) {
	                temp_sum += searchNum;
	            }

	            //Sum should not be more than 30
	            if (temp_sum > fixedSum) {
	                break;
	            }
	        }

	        return temp_sum == fixedSum;
	    }

}
