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

        printArrayHelper(mergeSort(unsortedList));
        printArrayHelper(mergeSort(unsortedList2));
        printArrayHelper(mergeSort(unsortedList3));
        printArrayHelper(mergeSort(unsortedList4));
        printArrayHelper(mergeSort(unsortedList5));
    }
}