package org.dsa.practise.sorting;

import org.dsa.practise.logger.Logger;

public class MergeSort {
	
	public static void mergeSort(Integer[] A, int l, int r, String fieldName) {
		int m = (l+r)/2;
		Logger.debug("l %d, m %d, r %d \n", l,m,r);
		if(l<r) {
			mergeSort(A, l, m, fieldName);
			mergeSort(A, m+1, r, fieldName);
			Utils.mergedSortedArrays(A, l, m, r, fieldName);
		}
	}

}
