package org.dsa.practise.sorting;

import java.lang.reflect.Field;

import org.dsa.practise.Constants;
import org.dsa.practise.Constants.ENV.DebugMode;
import org.dsa.practise.logger.Logger;

/**
 * Utils - Utility functions to support sorting.
 * 
 * @author assrivastava
 */
public class Utils {

	private Utils() {
		/**
		 * Marked private to prevent instantiation.
		 */
	}

	/**
	 * Get reflection field.
	 * 
	 * @param <T>
	 * @param generic
	 * @param fieldName
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public static <T> Field getField(T generic, String fieldName) throws NoSuchFieldException, SecurityException {
		Field field = null;
		if (fieldName != null) {
			field = generic.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
		}
		return field;
	}

	/**
	 * Get Reflection values.
	 * 
	 * @param <T>
	 * @param fieldName
	 * @param field
	 * @param A
	 * @param j
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static <T> Object[] getValues(String fieldName, Field field, T[] A, int j)
			throws IllegalArgumentException, IllegalAccessException {
		Object[] vals = new Object[2];
		if (fieldName == null) {
			vals[0] = A[j];
			vals[1] = A[j + 1];
		} else {
			vals[0] = field.get(A[j]);
			vals[1] = field.get(A[j + 1]);
		}
		return vals;

	}

	/**
	 * Get Reflection value.
	 * 
	 * @param <T>
	 * @param fieldName
	 * @param field
	 * @param A
	 * @param j
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static <T> Object getValue(String fieldName, Field field, T[] A, int j)
			throws IllegalArgumentException, IllegalAccessException {
		if (fieldName == null) {
			return A[j];
		} else {
			return field.get(A[j]);
		}

	}

	public static <T> void printArr(T[] A, boolean finalStep, int index, String identifier) {
		if (!finalStep) {
			Logger.debug("Printing array at index %d ..! \n", index);
		} else {
			if (index == 0) {
				Logger.debug("Printing array before %s ..! \n", identifier);
			} else {
				Logger.debug("Printing array after %s ..! \n", identifier);
			}

		}

		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i].toString() + " ");
		}
		Logger.debug("\n End Printing..!");
		System.out.println();
	}

	public static void printSubArray(Integer[] A, int begin, int end) {
		if (Constants.ENV.DEBUG_MODE == DebugMode.DEBUG) {
			Logger.debug("printing from index %d to index %d \n", begin, end);
			for (int i = begin; i <= end; i++) {
				System.out.print(A[i].toString() + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Code to merge 2 sorted arrays.
	 * 
	 * @param A         - Array
	 * @param l         - left index
	 * @param m         - mid index
	 * @param r         - right index Primary type int.
	 * @param fieldName - {@link String} - Field name for reflection
	 */
	public static void mergedSortedArrays(Integer[] A, int l, int m, int r, String fieldName) {
		Logger.debug("inside merge function \n");
		// [2,4,6,8,1,3,5,7]
		// l=0, r=7; m=3
		Logger.debug("l %d m %d r %d are: \n", l, m, r);
		// Calculating left and right array length.
		int llength = m - l + 1; // 4
		int rlength = r - m; // 4

		// creating temporary left and right array to hold data
		Integer[] lArr = new Integer[llength];
		Integer[] rArr = new Integer[rlength];

		// initialising loop params for left and right array and new array.
		// int i=0, j=0, k=0;

		// initialising left and right array with data.
		for (int i = 0; i < llength; i++) {
			lArr[i] = A[l + i];
		}
		for (int i = 0; i < rlength; i++) {
			rArr[i] = A[m + i + 1];
		}

		// left and right temp array initialisation complete.
		if (Constants.ENV.DEBUG_MODE == DebugMode.DEBUG) {
			Utils.printArr(lArr, true, 0, "Left Array");
			Utils.printArr(rArr, true, 0, "right Array");
		}

		// Execute 2-way merge.
		int i = 0, j = 0, k = l;

		while (i < lArr.length && j < rArr.length) {
			if (lArr[i] < rArr[j]) {
				A[k++] = lArr[i++];
			} else {
				A[k++] = rArr[j++];
			}
		}

		Logger.debug("larr length %s rArr length: %s k is %s i is %s j is %s", lArr.length, rArr.length, k, i, j);
		while (i < lArr.length) {
			A[k++] = lArr[i++];
		}
		while (j < rArr.length) {
			A[k++] = rArr[j++];
		}
		//Utils.printArr(A, true, 0, "2-Way sorted array.");
	}
}
