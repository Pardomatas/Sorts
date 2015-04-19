public class Main {

	public static void main(String[] args) {
		int size = 10;
		Sorts sort = new Sorts();
		int[] myArray = new int[size];
		
		System.out.println("Original Array:");
		sort.fillArray(myArray, size);
		sort.displayArray(myArray);
		
		System.out.println("Bubble Sort:");
		sort.displayArray(sort.bubbleSort(myArray));
		
		System.out.println("Insertion Sort:");
		sort.displayArray(sort.insertionSort(myArray));
		
		System.out.println("Selection Sort:");
		sort.displayArray(sort.selectionSort(myArray));
		
		System.out.println("Merge Sort:");
		sort.displayArray(sort.mergeSort(myArray));
	}
	
	
}
