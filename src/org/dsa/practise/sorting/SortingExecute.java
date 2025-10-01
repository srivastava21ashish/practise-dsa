package org.dsa.practise.sorting;

import org.dsa.practise.Constants;

public class SortingExecute {
	
	public static void main(String[] args) {
		try {
			/**
			 * Bubble Sort.
			 
			Integer[] bubbleArr = {4,6,3,4,7,1};
			Utils.printArr(bubbleArr, true, 0, "selection sort");
			Integer[] bubbleArrSorted = Sorting.bubbleSort(bubbleArr, null);
			Utils.printArr(bubbleArrSorted, true, bubbleArrSorted.length, "bubble sort");
			*/
			/**
			 * Selection sort
			 
			Integer[] ssArr = {4,6,3,4,7,1};
			Utils.printArr(ssArr, true, 0, "selection sort");
			Integer[] selectionSortedArray = Sorting.selectionSort(ssArr, null);
			Utils.printArr(selectionSortedArray, true, ssArr.length, "selection sort");
			*/
			/**
			 * Insertion sort
			 
			Integer[] insArr = {4,6,3,4,7,1};
			Utils.printArr(insArr, true, 0, "insertion sort");
			Integer[] insSortedArray = Sorting.insertionSort(insArr, null);
			Utils.printArr(insSortedArray, true, insArr.length, "insertion sort");
			*/
			
			Integer[] arr = {2,7,3,9,10,6,5,4,8};
			System.out.println("input array");
			Utils.printArr(arr, true, 0, "merge sort");
			MergeSort.mergeSort(arr, 0, arr.length-1, null);
			System.out.println("sorted array");
			Utils.printArr(arr, true, arr.length, "merge sort");
			
		} catch (Exception e) {
			switch (Constants.ENV.DEBUG_MODE) {
			case DEBUG: {
				e.printStackTrace();
			}
			default:
				System.out.println("Exception occured: "+e.getMessage());			}
		} 
	}
}
