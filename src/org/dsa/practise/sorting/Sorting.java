package org.dsa.practise.sorting;

import java.lang.reflect.Field;

/**
 * Sorting class to handle multiple methods of sorting.
 */
public class Sorting {

	/**
	 * Bubble Sort.
	 * 
	 * @param <T>
	 * @param A
	 * @param fieldName
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] bubbleSort(T[] A, String fieldName)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		int length = A.length;

		Field field = Utils.getField(A[0], fieldName);

		// [4,6,3,4,7]
		// A.length = 5
		for (int i = length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				Object[] vals = Utils.getValues(fieldName, field, A, j);

				if (!(vals[0] instanceof Comparable) || !(vals[1] instanceof Comparable)) {
					throw new IllegalArgumentException("Values of field '" + fieldName + "' are not comparable");
				}
				Comparable<Object> comp1 = (Comparable<Object>) vals[0];
				if (comp1.compareTo(vals[1]) > 0) {
					T temp = A[j];
					A[j] = A[j + 1];
					A[j + 1] = temp;
				}
			}
		}
		return A;
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] selectionSort(T[] A, String fieldName)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		int length = A.length;
		Field field = Utils.getField(A[0], fieldName);
		Object min = null;
		int minIndex = 0;
		for (int i = 0; i < length - 1; i++) {
			min = Utils.getValue(fieldName, field, A, i);
			minIndex = i;
			for (int j = i + 1; j < length; j++) {
				Object jElement = Utils.getValue(fieldName, field, A, j);
				Comparable<Object> jComparable = (Comparable<Object>) jElement;
				if (!(jComparable instanceof Comparable) || !(min instanceof Comparable)) {
					throw new IllegalArgumentException("Values of field '" + fieldName + "' are not comparable");
				}
				if (jComparable.compareTo(min) < 0) {
					min = jElement;
					minIndex = j;
				}
			}
			if (minIndex != i) {
				T temp = A[minIndex];
				A[minIndex] = A[i];
				A[i] = temp;
			}
		}
		return A;
	}

	/**
	 * Insertion Sort.
	 * 
	 * @param A
	 * @return
	 * @throws SecurityException,   IllegalAccessException
	 * @throws NoSuchFieldException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] insertionSort(T[] A, String fieldName)
			throws NoSuchFieldException, SecurityException, IllegalAccessException {
		int length = A.length;
		Field field = Utils.getField(A[0], fieldName);
		// [4 6 3 4 7 1]
		// A.length = 6
		for (int i = 1; i < length; i++) {
			int j = i-1;
			while(j>=0) {
				Object left = Utils.getValue(fieldName, field, A, j);
				Object right = Utils.getValue(fieldName, field, A, j+1);
				Comparable<Object> leftComp = (Comparable<Object>) left;
				if(leftComp.compareTo(right) > 0) {
					T temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
				j--;
			}
			System.out.printf("Array after %d step \n", i);
			Utils.printArr(A, true, 0, fieldName);
		}
		return A;
	}

}
