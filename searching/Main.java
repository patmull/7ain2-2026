public class Main {

    public static boolean binarySearch(int[] searchedItems, int searchedItem) {

        if (searchedItems.length == 0) {
            System.out.println("WARNING: inserted array is empty!"); // OPTIONAL
            return false;
        } else {
            return binarySplit(searchedItems, searchedItem, 0, searchedItems.length - 1);
        }
    }

    public static boolean binarySplit(int[] splitOfItems, int searchedItem, int leftBound, int rightBound) {
        if (leftBound == rightBound) // BASE CASE #3
            return splitOfItems[leftBound] == searchedItem; // if (splitOfItems[leftBound] == searchedItem) return true;
        // if(splitOfItems[leftBound] == searchedItem) return True;
        int mid = (leftBound + rightBound) / 2;
        // recalculate the middle item
        if (splitOfItems[mid] == searchedItem)
            // stop if the current middle item is the searched item
            return true; // BASE CASE
        else if (searchedItem < splitOfItems[mid])
            // e.g. 3(L),4,5(mid),8,10(R) and search for 4 (searchedItem)
            if (leftBound == mid) return false; // We cannot move left past the mid => all options exhausted // BASE CASE #2
            // it does not make sense to test the right (e.g. 10)
                // since we know it will never be the searched item since searched item is < than middle
            else return binarySplit(splitOfItems, searchedItem, leftBound, mid - 1);
                // RECURSIVE CASE
            // R = mid, so we have: 3(L),4,5(R) => and later 4 becomes the mid => item found
        else
            // if (leftBound == mid) return false; // WRONG
            // middle item > searchedItem, e.g. 3(L),4,5(mid),8,10(R) and search for 8 (searchedItem)
            return binarySplit(splitOfItems, searchedItem, mid + 1, rightBound);
            // L = mid, so we have: 5(L),8,10(R) => and later 8 becomes the mid => item found
    }

    public static void main(String[] args) {
        int[] exampleArray = {3,4,5,8,10};
        //System.out.println(binarySearch(exampleArray, 4));
        //System.out.println(binarySearch(exampleArray, 48));
        //System.out.println(binarySearch(exampleArray, 8));
        int[] exampleArray2 = {3, 4};
        System.out.println(binarySearch(exampleArray2, 4));
    }
}
