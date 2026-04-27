public class Main {

    public static boolean binarySearch(int[] searchedItems, int searchedItem) {
        if (searchedItems.length == 0) {
            System.out.println("WARNING: inserted array is empty!"); // OPTIONAL
            return false;
        } else {
            return binarySplit(searchedItems, searchedItem, 0, searchedItems.length - 1);
        }
    }

    public static boolean binarySplit(int[] splitOfItems,
                                      int searchedItem,
                                      int leftBound,
                                      int rightBound) {
        if (leftBound == rightBound) // BASE CASE #3
            return splitOfItems[leftBound] == searchedItem;
        // if (splitOfItems[leftBound] == searchedItem) return true;
        int mid = (leftBound + rightBound) / 2;
        // recalculate the middle item
        if (splitOfItems[mid] == searchedItem) // BASE CASE
            // stop if the current middle item is the searched item
            return true;
        else if (searchedItem < splitOfItems[mid])
            // e.g. 3(L),4,5(mid),8,10(R) and search for 4 (searchedItem)
            if (leftBound >= mid) return false;
            // BASE CASE #2
            // We cannot move left past the mid
                // => all options exhausted
            else return binarySplit(splitOfItems, searchedItem,
                    leftBound, mid - 1);
                    // RECURSIVE CASE #1
            // R = mid-1, so we have: 3(L),4(R) => and later 4 becomes the mid => item found
        else
            // if (leftBound == mid) return false; // WRONG
            // middle item > searchedItem, e.g. 3(L),4,5(mid),8,10(R) and search for 8 (searchedItem)
            return binarySplit(splitOfItems, searchedItem,
                    mid + 1, rightBound);
                    // RECURSIVE CASE #2
            // L = mid+1, so we have: 8(L),10(R)
            // => and later 8 becomes the mid => item found
    }

    public static boolean binarySplitCleaner(int[] splitOfItems, int searchedItem, int leftBound, int rightBound) {
        // BASE CASE #2: Putting the base cases #2 and #3 from "non-clean" version together:
        // use the bad moment when the pointers cross as
        // an indication that the item is not there.
        if (leftBound > rightBound) {
            return false;
        }
        // Calculate mid safely to avoid integer overflow
        // If (leftBound + rightBound) would be too big,
        // this is a safe way to do it:
        int mid = leftBound + (rightBound - leftBound) / 2;
        // BASE CASE #1: ITEM FOUND
        if (splitOfItems[mid] == searchedItem) {
            return true;
        }
        // RECURSIVE CASE #1: LEFT HALF SPLIT
        else if (searchedItem < splitOfItems[mid]) {
            return binarySplit(splitOfItems, searchedItem, leftBound, mid - 1);
        }
        // RECURSIVE CASE #2: RIGHT HALF SPLIT
        else {
            return binarySplit(splitOfItems, searchedItem, mid + 1, rightBound);
        }
    }

    public static void main(String[] args) {
        int[] exampleArray = {3,4,5,8,10};
        //System.out.println(binarySearch(exampleArray, 4));
        //System.out.println(binarySearch(exampleArray, 48));
        //System.out.println(binarySearch(exampleArray, 8));
        //int[] exampleArray2 = {3, 4};
        //int[] exampleArray = {6,8,11};
        System.out.println(binarySearch(exampleArray, 8));
    }
}
