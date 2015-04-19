import java.util.Arrays;
import java.util.Random;

public class Sorts {

	void swap(int[] array, int first, int second) {
		int temp = array[first];               
		array[first] = array[second];
		array[second] = temp;
	}
	
	//-------------------------------------------------------------------------------------
	
	void fillArray(int array[], int size) {
		Random rand = new Random();
		for(int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(size + 1);
		}
	}
	
	//------------------------------------------------------------------------------------

	void displayArray(int array[]) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if(i != array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println('\n');
	}
	
	//----------------------------------------------------------------------------------------
	
	int[] bubbleSort(int[] myArray) {
		int[] array = Arrays.copyOf(myArray, myArray.length);
		long startTime = System.nanoTime();
		
	    boolean flag = true;  

	    while(flag) {
	    	flag = false;    
	        for(int i = 0; i < array.length - 1; i++) {
	        	if(array[i] > array[i + 1]) {
	        		swap(array, i, i + 1);
	        		flag = true;              
	        	}
	        }
	    }
	    long stopTime = System.nanoTime();
	    System.out.println("Nano seconds: " + (stopTime - startTime));
	    
	    return array;
	} 
	
	//------------------------------------------------------------------------------------------
	
	int[] selectionSort(int[] myArray) {
		int[] array = Arrays.copyOf(myArray, myArray.length);
		long startTime = System.nanoTime();
		
		for(int i = 0; i < array.length - 1; i++) {
			int k = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[j] < array[k]) {
					k = j;
				}
			}
			swap(array, i, k);
		}
		
		long stopTime = System.nanoTime();
		System.out.println("Nano seconds: " + (stopTime - startTime));
	    
	    return array;
	}
	
	//--------------------------------------------------------------------------------------------
	
	int[] insertionSort(int[] myArray) {
		int[] array = Arrays.copyOf(myArray, myArray.length);
		long startTime = System.nanoTime();
		
		for(int i = 1; i < array.length; i++) {
			for(int k = i; k > 0 && array[k] < array[k - 1]; k--) {
				swap(array, k, k-1);
			}
		}
		
		long stopTime = System.nanoTime();
	    System.out.println("Nano seconds: " + (stopTime - startTime));
	    
	    return array;
	}
	
	//-------------------------------------------------------------------------------------------
	
	int[] mergeSort(int[] myArray) {
		int[] array = Arrays.copyOf(myArray, myArray.length);
		long startTime = System.nanoTime();
		
		doMergeSort(array, 0, array.length - 1);
		
		long stopTime = System.nanoTime();
	    System.out.println("Nano seconds: " + (stopTime - startTime));
	    
		return array;
	}
	
	void doMergeSort(int[] array, int lower, int higher) {
		if(lower < higher) {
			int middle = lower + (higher - lower) / 2;
			doMergeSort(array, lower, middle);
			doMergeSort(array, middle + 1, higher);
			mergeParts(array, lower, middle, higher);
		}
	}
	
	void mergeParts(int[] array, int lower, int middle, int higher) {
		int[] temp = new int[array.length];
		for(int i = lower; i <= higher; i++) {
			temp[i] = array[i];
		}
		int i = lower;
		int j = middle + 1;
		int k = lower;
		while(i <= middle && j <= higher) {
			if(temp[i] <= temp[j]) {
				array[k] = temp[i];
				i++;
			} else {
				array[k] = temp[j];
				j++;
			}
			k++;
		}
		while(i <= middle) {
			array[k] = temp[i];
			k++;
			i++;
		}
	}
	
	//-------------------------------------------------------------------------------------------------
}
