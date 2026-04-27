import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void printArrayHelper(int[] items) {
        for (int item : items) {
            System.out.print(item);
            System.out.print(", ");
        }
        System.out.print("\n");
    }

    public static int[] bubbleSort(int[] items) {
        boolean swap = true;
        while (swap) { // if no swap was done in the pass, then do not swap anymore
            swap = false; // assuming no swap was done => end
            for(int i = 1; i < items.length; i++) {
                // NOTICE: we cannot start from 0 because the i-1 would get us out of range...
                // NOTICE: we need to do i-1 and i, not i and i+1,
                // otherwise we would be out of range of the array!
                if (items[i-1] > items[i]) { // wrong order => swap
                    swap = true; // actually swap was done => do another pass next time (continue loop)
                    // if we do just: unsorted[i-1] = unsorted[i];
                    // ... but we would re-write the [i-1] and never have it back...
                    int temp = items[i-1]; // storing the re-written item to swap
                    items[i-1] = items[i]; // re-write
                    items[i] = temp;
                }
            }
        }

        return items; // this is now sorted
    }

    public static int[] selectionSort(int[] items) {
        for(int smallestItemCandidateIndex = 0; smallestItemCandidateIndex < items.length;
            smallestItemCandidateIndex++) {
            // no need to consider the already sorted... start from the place of not considered
            for(int allOthersIndex = smallestItemCandidateIndex; allOthersIndex < items.length; allOthersIndex++) {
                if(items[smallestItemCandidateIndex] > items[allOthersIndex]) {
                    int temp = items[smallestItemCandidateIndex]; // SWAP
                    items[smallestItemCandidateIndex] = items[allOthersIndex];
                    items[allOthersIndex] = temp;
                }
            }
        }

        return items;
    }

    public static int[] mergeSort(int[] items) {
        if (items.length <= 1) // BASE CASE
            return items; // we hit the leaf => stop splitting, just return the leaf

        int splitIndex = items.length / 2;
        // DIVIDE
        int[] arraySplitLeft = split(items,0, splitIndex); // continue splitting L...
        int[] arraySplitRight = split(items, splitIndex, items.length); // continue splitting R...

        // CONQUER
        return merge(arraySplitLeft, arraySplitRight); // we cannot split anymore
    }

    public static int[] split(int[] items, int from, int to) {
        int[] arraySplitLeft = Arrays.copyOfRange(items, from, to);
        return mergeSort(arraySplitLeft); // continue splitting until the // BASE CASE in mergeSort() not hit...
    }

    public static int[] merge(int[] leftSplit, int[] rightSplit) {
        int[] merged = new int[leftSplit.length + rightSplit.length];
        int leftSplitIndex = 0; int rightSplitIndex = 0;
        int newArrayAddedIndex = 0;

        while ((leftSplitIndex < leftSplit.length && rightSplitIndex < rightSplit.length)) { // stay in the bounds
            if(leftSplit[leftSplitIndex] < rightSplit[rightSplitIndex]) {
                merged[newArrayAddedIndex] = leftSplit[leftSplitIndex];
                 // moving only the index of the split from which we added to new merged array
                newArrayAddedIndex++; leftSplitIndex++;
            } else {
                merged[newArrayAddedIndex] = rightSplit[rightSplitIndex];
                newArrayAddedIndex++; rightSplitIndex++;
            }
        }

        // this would never be complete, some of items would still remain!
        if(newArrayAddedIndex < merged.length) {
            for(int i = leftSplitIndex; i < leftSplit.length; i++) {
                merged[newArrayAddedIndex] = leftSplit[i];
                newArrayAddedIndex++;
            }
        }

        if(newArrayAddedIndex < merged.length) {
            for(int i = rightSplitIndex; i < rightSplit.length; i++) {
                merged[newArrayAddedIndex] = rightSplit[i];
                newArrayAddedIndex++;
            }
        }

        return merged;
    }

    public static int[] mergeSortOptimizedDemo(int array[]) {
        return mergeSortOptimized(array, 0, array.length - 1);
    }

    public static int[] mergeSortOptimized(int array[], int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            // like in the case of bin. search, this is trick to avoid int overflows if rightIndex too big
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            array = mergeSortOptimized(array, leftIndex, midIndex);
            array = mergeSortOptimized(array, midIndex + 1, rightIndex);
            array = mergeTraditionally(array, leftIndex, midIndex, rightIndex);
        }
        return array;
    }

    public static int[] mergeTraditionally(int arr[], int l, int m, int r) {
        // classic implementation of merge() method
        int nLeft = m - l + 1; // boundary or left side
        int nRight = r - m; // boundary for right side

        int leftSplit[] = new int[nLeft];
        int rightSplit[] = new int[nRight];

        // copy left side
        for (int i = 0; i < nLeft; ++i)
            leftSplit[i] = arr[l + i];
        // copy right side
        for (int j = 0; j < nRight; ++j)
            rightSplit[j] = arr[m + 1 + j];

        int i = 0; int j = 0; // indexes for subarrays;
        // i (again) for the left (sub-)array; j for the right
        int k = l;
        // index for the (partially) merged:
        // tells where to copy the items from left and right to the original array

        while (i < nLeft && j < nRight) {
            // see the picture: https://www.w3schools.com/dsa/img_mergesort_long.png
            // this decides the arrows in the green part when we merge
            if(leftSplit[i] <= rightSplit[j]) {
                arr[k] = leftSplit[i];
                // copy from left split
                i++;
            } else {
                arr[k] = rightSplit[j]; // copy from right split
                j++;
            }
            k++;
        }

        while(i < nLeft) {
            arr[k] = leftSplit[i]; // copy from left split
            i++;
            k++;
        }

        while(j < nRight) {
            arr[k] = rightSplit[j];
            j++;
            k++;
        }

        return arr;
    }

    public static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    public static int[] quickSortLomuto(int[] arr, int left, int right) {
        if (left < right) {
            // Find the locked pivot index
            int pivotIndex = partitionLomuto(arr, left, right);

            // Recursively sort the left bucket and right bucket
            quickSortLomuto(arr, left, pivotIndex - 1);
            quickSortLomuto(arr, pivotIndex + 1, right);
        }
        return arr;
    }

    public static int partitionHoare(int[] arr, int left, int right) {
        int pivot = arr[left]; // Pick the first element as pivot
        int i = left - 1;      // Start just outside the left bound
        int j = right + 1;     // Start just outside the right bound

        while (true) {
            // find next element larger than pivot
            // from the left
            do {
                i++;
            } while (arr[i] < pivot);

            // find next element smaller than pivot
            // from the right
            do {
                j--;
            } while (arr[j] > pivot);

            // If the pointers meet/cross, STOP (otherwise we would get index errors)!
            if (i >= j) {
                return j;
            }

            // swap larger and smaller elements
            swap(arr, i , j);
        }
   }

    public static void quickSortHoareRecursive(int[] arr, int left, int right) {
        if (left < right) {
            // Find the dividing line (Notice Hoare doesn't lock the pivot!)
            int dividingLine = partitionHoare(arr, left, right);

            // Recursively sort the left and right sides
            // IMPORTANT: Because Hoare doesn't lock the pivot in the middle,
            // the left bucket INCLUDES the dividing line.
            quickSortHoareRecursive(arr, left, dividingLine);
            quickSortHoareRecursive(arr, dividingLine + 1, right);
        }
    }

    public static int[] quickSort(int[] items, String schemeType) {
        if (items.length == 0)
            return items;
        if (schemeType.equals("lomuto")) {
            // Call the recursive function starting with the full bounds
            quickSortLomuto(items, 0, items.length - 1);
            return items;
        } else if (schemeType.equals("hoare")) {
            quickSortHoareRecursive(items, 0, items.length - 1);
            return items;
        } else {
            System.out.println("Scheme not supported!");
            int[] emptyArrayFallback = {};
            return emptyArrayFallback;
        }
    }

    public static int partitionLomuto(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        // i acts as boundary between smaller and
        // larger element compared to pivot
        for (int j = left; j < right; j++) {
            // If smaller element is found expand the
            // boundary and swapping it with boundary element.
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        // place the pivot at its correct position
        swap(arr, i+1, right);
        return i+1;
    }

    public static void main(String[] args) {
        // NOTICE: It is good to test various edge cases, e.g. already sorted, few items, etc...
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int[] unsortedList = {6,2,2,9,1,4};
        int[] unsortedList2 = {6,2};
        int[] unsortedList3 = {1,2,2,4,6,9};
        int[] unsortedList4 = {2};
        int[] unsortedList5 = {1,2,2,4,6,9,10}; // odd number of items

        /*
        printArrayHelper(bubbleSort(unsortedList));
        printArrayHelper(bubbleSort(unsortedList2));
        printArrayHelper(bubbleSort(unsortedList3));
        printArrayHelper(bubbleSort(unsortedList4));

        printArrayHelper(selectionSort(unsortedList));
        printArrayHelper(selectionSort(unsortedList2));
        printArrayHelper(selectionSort(unsortedList3));
        printArrayHelper(selectionSort(unsortedList4));
         */
        /*
        printArrayHelper(mergeSort(unsortedList));
        printArrayHelper(mergeSort(unsortedList2));
        printArrayHelper(mergeSort(unsortedList3));
        printArrayHelper(mergeSort(unsortedList4));
        printArrayHelper(mergeSort(unsortedList5));
         */

        /*
        printArrayHelper(mergeSortOptimizedDemo(unsortedList));
        printArrayHelper(mergeSortOptimizedDemo(unsortedList2));
        printArrayHelper(mergeSortOptimizedDemo(unsortedList3));
        printArrayHelper(mergeSortOptimizedDemo(unsortedList4));
        printArrayHelper(mergeSortOptimizedDemo(unsortedList5));
         */

        /*
        printArrayHelper(quickSort(unsortedList, "lomuto"));
        printArrayHelper(quickSort(unsortedList2, "lomuto"));
        printArrayHelper(quickSort(unsortedList3, "lomuto"));
        printArrayHelper(quickSort(unsortedList4, "lomuto"));
        printArrayHelper(quickSort(unsortedList5, "lomuto"));
         */

        printArrayHelper(quickSort(unsortedList, "hoare"));
        printArrayHelper(quickSort(unsortedList2, "hoare"));
        printArrayHelper(quickSort(unsortedList3, "hoare"));
        printArrayHelper(quickSort(unsortedList4, "hoare"));
        printArrayHelper(quickSort(unsortedList5, "hoare"));
    }
}