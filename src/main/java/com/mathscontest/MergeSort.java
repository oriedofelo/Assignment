package com.mathscontest;

import java.util.Random;

/*
 * The algorithm sorts an array by splitting an array into two equal
 * sized subarrays, sorting each subarray, then merging them into one larger array
 * With an odd number of elements, the algorithm creates the two subarrays such that
 * one has more elements than the other
 * The implementation of merge sort in this example is recursive,
 * the base case is an array with one element, which is, ofcourse sorted, so the merge
 * sort immediately returns in this case
 * */
public class MergeSort {

    private Entry[] entryData;


    public MergeSort(Entry[] entries) {
        this.entryData = entries;
    }


    public void sortEntry() {
        //pass first and last elements of array
        sortArrayEntry(0, entryData.length - 1);
    }

    // splits array, sorts subarrays and merges subarrays into sorted array
    private void sortArrayEntry(int low, int high) {
        // test base case; size of array equals 1
        if ((high - low) >= 1) {
            int middle1 = (low + high) / 2; // calculate middle of array
            int middle2 = middle1 + 1; // calculate next element over
            // split array in half; sort each half (recursive calls)
            sortArrayEntry(low, middle1); // first half of array
            sortArrayEntry(middle2, high); // second half of array

            // merge two sorted arrays after split calls return
            mergeEntry(low, middle1, middle2, high);

        }

    }

    // merge two sorted subarrays into one sorted subarray
    private void mergeEntry(int left, int middle1, int middle2, int right) {
        int leftIndex = left; // index into left subarray
        int rightIndex = middle2; // index into right subarray
        int combinedIndex = left; // index into temporary working array
        Entry[] combined = new Entry[entryData.length];// working array
        // merge arrays until reaching end of either
        while (leftIndex <= middle1 && rightIndex <= right) {
            // place smaller of two current elements into result
            // and move to next space in arrays
            if (entryData[leftIndex].totalScore() >= entryData[rightIndex].totalScore()) {
                combined[combinedIndex++] = entryData[leftIndex++];
            } else {
                combined[combinedIndex++] = entryData[rightIndex++];
            }
        } // end while

        // if left array is empty
        if (leftIndex == middle2) // copy in rest of right array
        {
            while (rightIndex <= right) {
                combined[combinedIndex++] = entryData[rightIndex++];
            }
        } else // right array is empty
        // copy in rest of left array
        {
            while (leftIndex <= middle1) {
                combined[combinedIndex++] = entryData[leftIndex++];
            }
        }
        // copy values back into original array
        for (int i = left; i <= right; i++) {
            entryData[i] = combined[i];
        }
    }// end method merge


}// end class MergeSort
