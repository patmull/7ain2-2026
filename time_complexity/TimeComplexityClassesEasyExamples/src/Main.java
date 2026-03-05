import java.util.*;
import java.util.function.BooleanSupplier;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Example:
        // 1. Try to make one of the algorithms faster/slower.
        // 2. What happens if the exponent gets too big?
        // 3. What kind of time complexity is this?

        int limit = 100000;
        long result1 = 0;

        System.out.println("Measuring time of the execution....");
        long timeBefore = System.currentTimeMillis();
        long timeBeforeNanoSec = System.nanoTime();

        System.out.println("Time before: " + timeBefore); // NOTICE: This is often slower than the for if limit in thousands
        for (int i = 1; i <= limit; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            // System.out.println("i = " + i);
            result1 += i;
        }

        System.out.println("Result = " + result1);
        long timeAfter = System.currentTimeMillis();
        long timeAfterNanoSec = System.nanoTime();
        System.out.println("Time after: " + timeAfter);

        long timeDifference = timeAfter - timeBefore;
        long timeDifferenceNano = timeAfterNanoSec - timeBeforeNanoSec;

        System.out.println("Time of the execution: " + timeDifference + " ms"); // NOTICE: If you see 0 it is because it is faster than <0ms, need ns
        System.out.println("Time of the execution: " + timeDifferenceNano + " ns");
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        int exponent = 50;
        int base = 2;
        long result = base;

        System.out.println("Measuring time of the execution....");
        timeBefore = System.currentTimeMillis();
        timeBeforeNanoSec = System.nanoTime();

        System.out.println("Time before: " + timeBefore); // NOTICE: This is often slower than the for if limit in thousands
        for (int i = 1; i <= exponent; i++) {
            // System.out.println("i = " + i);
            result *= base;
        }

        System.out.println("Result = " + result);
        timeAfter = System.currentTimeMillis();
        timeAfterNanoSec = System.nanoTime();
        System.out.println("Time after: " + timeAfter);

        timeDifference = timeAfter - timeBefore;
        timeDifferenceNano = timeAfterNanoSec - timeBeforeNanoSec;

        System.out.println("Time of the execution: " + timeDifference + " ms"); // NOTICE: If you see 0 it is because it is faster than <0ms, need ns
        System.out.println("Time of the execution: " + timeDifferenceNano + " ns");

        // This is:
        // O(n)

        // O(1)
        int checkedLimit = 100000;
        if(result < checkedLimit) {
            System.out.println("Result is in the limit.");
        }

        // O(n^2)
        System.out.println("Measuring time of the execution....");
        timeBefore = System.currentTimeMillis();
        timeBeforeNanoSec = System.nanoTime();

        int loopLimit1 = 100;
        int loopLimit2 = 20;
        for (int i = 0; i < loopLimit1; i++) {
            System.out.println("Loop #1");
            for (int j = 0; j < loopLimit2; j++) {
                System.out.println("Nested loop #1");
            }
        }

        timeAfter = System.currentTimeMillis();
        timeAfterNanoSec = System.nanoTime();
        timeDifference = timeAfter - timeBefore;
        timeDifferenceNano = timeAfterNanoSec - timeBeforeNanoSec;
        System.out.println("Time after: " + timeAfter);
        System.out.println("Time of the execution: " + timeDifference + " ms"); // NOTICE: If you see 0 it is because it is faster than <0ms, need ns
        System.out.println("Time of the execution: " + timeDifferenceNano + " ns");

        // e.g. 2D arrays:
        int[][] array2D = {
                {4,5,7},
                {2,6,3},
                {8,4,3}
        };

        int[] array1D = {4,5,7,2,6,3,8,4,3};

        System.out.println("Measuring time of the execution....");
        timeBefore = System.currentTimeMillis();
        timeBeforeNanoSec = System.nanoTime();

        System.out.println("Items of 1D array:");
        for (int i = 0; i < array1D.length; i++) {
            System.out.println(array1D[i]);
        }

        timeAfter = System.currentTimeMillis();
        timeAfterNanoSec = System.nanoTime();
        timeDifference = timeAfter - timeBefore;
        timeDifferenceNano = timeAfterNanoSec - timeBeforeNanoSec;
        System.out.println("Time after: " + timeAfter);
        System.out.println("Time of the execution: " + timeDifference + " ms"); // NOTICE: If you see 0 it is because it is faster than <0ms, need ns
        System.out.println("Time of the execution: " + timeDifferenceNano + " ns");

        // ======================

        System.out.println("Measuring time of the execution....");
        timeBefore = System.currentTimeMillis();
        timeBeforeNanoSec = System.nanoTime();

        for (int i = 0; i < array2D.length; i++) {
            System.out.println("Loop #1: " + i);
            for (int j = 0; j < array2D[i].length; j++) {
                System.out.println("Nested loop #1: " + array2D[i][j]);
            }
        }

        timeAfter = System.currentTimeMillis();
        timeAfterNanoSec = System.nanoTime();
        timeDifference = timeAfter - timeBefore;
        timeDifferenceNano = timeAfterNanoSec - timeBeforeNanoSec;
        System.out.println("Time after: " + timeAfter);
        System.out.println("Time of the execution: " + timeDifference + " ms"); // NOTICE: If you see 0 it is because it is faster than <0ms, need ns
        System.out.println("Time of the execution: " + timeDifferenceNano + " ns");

        // O(n^3)
        // ========================

        // e.g. 3D arrays (e.g. multiple datasets or multiple results):
        //int[][] array2D = {{2,4,6},{2,5,6},{5,4,6}};
        int[][][] array3D = {
                {
                    {4,5,7}, // j
                    //k k k
                    {2,6,3}, // j
                    //k k k
                    {8,4,3} // j
                    // k k k
                }, // i
                {
                    {2,2,1},
                    {2,6,3},
                    {6,2,1}
                }, // i
                {
                    {8,6,2},
                    {2,1,4},
                    {6,7,3}
                } // i
        };

        System.out.println("Measuring time of the execution....");
        timeBefore = System.currentTimeMillis();
        timeBeforeNanoSec = System.nanoTime();

        for (int i = 0; i < array3D.length; i++) {
            // System.out.println("Loop #1: " + i);
            for (int j = 0; j < array3D[i].length; j++) {
                // System.out.println("Nested loop #1: " + j);
                for (int k = 0; k < array3D[i].length; k++) {
                    System.out.println("Nested loop #2: " + array3D[i][j][k]);
                }
            }
        }

        timeAfter = System.currentTimeMillis();
        timeAfterNanoSec = System.nanoTime();
        timeDifference = timeAfter - timeBefore;
        timeDifferenceNano = timeAfterNanoSec - timeBeforeNanoSec;
        System.out.println("Time after: " + timeAfter);
        System.out.println("Time of the execution: " + timeDifference + " ms"); // NOTICE: If you see 0 it is because it is faster than <0ms, need ns
        System.out.println("Time of the execution: " + timeDifferenceNano + " ns");

        // O(n^c): even more c times nested loops

        // O(2^n)
        // String password = "password123";

        System.out.println("Measuring time of the execution....");
        timeBefore = System.currentTimeMillis();
        timeBeforeNanoSec = System.nanoTime();

        String password = "gefhez"; // Assuming we do not know the length of the password beforehand...
        StringBuilder substringGuess = new StringBuilder("");
        boolean passwordAlreadyFound = false;
        String correctPasswordGuess = "";
        String[] guesses = {"a","a","a"};
        Set<String> guessesDatabase = new HashSet<>();
        String debugStr = "prl";
        int testedPositionIndex = 0;
        boolean outOfMemory = false;

        for(char j_char = 'a'; j_char <= 'z'; j_char++) {
            String jCharStr = "" + j_char;
            guessesDatabase.add(jCharStr);
        }

        do {
            Set<String> missingItems = new HashSet<>();
            for(String guess : guessesDatabase) {
                System.out.println(guess);
                if (guess.equals(password) && !passwordAlreadyFound) {
                    passwordAlreadyFound = true;
                    correctPasswordGuess = guess;
                    break;
                }
                for (char j_char = 'a'; j_char <= 'z'; j_char++) {
                    String guessPlusLetter = guess + j_char;
                    if (guessPlusLetter.equals(password)) {
                        passwordAlreadyFound = true;
                        correctPasswordGuess = guessPlusLetter;
                        break;
                    }
                    missingItems.add(guessPlusLetter);
                    // System.out.println("Missing items size: " + missingItems.size());
                    if (missingItems.size() > 40000000) {
                        outOfMemory = true;
                        break;
                    }
                }
                if(outOfMemory) {
                    outOfMemory = false;
                    break;
                }
            }
            guessesDatabase.addAll(missingItems);
            System.out.println("Guesses database size: " + guessesDatabase.size());
        } while(!passwordAlreadyFound);

        for(char j_char = 'a'; j_char <= 'z'; j_char++) {

            String jCharStr = "" + j_char;
            if(!guessesDatabase.contains(jCharStr)) {
                guessesDatabase.add(jCharStr);
            }
        }

        do {
            String newStartingString = "";
            for (int i = 0; i < substringGuess.length() + 1; i++) {
                newStartingString += "a";
            }
            substringGuess = new StringBuilder(newStartingString);

            for (int i = 0; i < substringGuess.length(); i++) {
                for(char i_char = 'a'; i_char <= 'z'; i_char++) {
                    substringGuess.setCharAt(i, i_char);
                    System.out.println("guess:" + substringGuess);
                    if (!guessesDatabase.contains(substringGuess.toString())) {
                        guessesDatabase.add(substringGuess.toString());
                    }

                    ArrayList<String> missingItems = new ArrayList<>();
                    int counter = 0;
                    for (String guess : guessesDatabase) {
                        // System.out.println(guess);

                        if (passwordAlreadyFound) {
                            break;
                        }
                        //System.out.println("guesses in db:" + guessesDatabase.size());
                        if (guess.contains(debugStr)) {
                            System.out.println("DEBUG: " + guess);
                        }
                        if (guess.equals(password)) {
                            passwordAlreadyFound = true;
                            correctPasswordGuess = guess;
                            break;
                        }

                        for (char a = 'a'; a <= 'z'; a++) {
                            String guessAndLastLetter = guess + a;
                            if (guessAndLastLetter.equals(password)) {
                                passwordAlreadyFound = true;
                                correctPasswordGuess = guessAndLastLetter;
                                break;
                            }
                            if (!guessesDatabase.contains(guessAndLastLetter) && !missingItems.contains(guessAndLastLetter)) {
                                missingItems.add(guessAndLastLetter);
                            }
                        }
                        System.out.println(counter + "/" + guessesDatabase.size());
                        counter++;
                    }
                    guessesDatabase.addAll(missingItems);
                }
            }

            // System.out.println(substringGuess);
            if(substringGuess.toString().equals(password)) {
                passwordAlreadyFound = true;
                correctPasswordGuess = substringGuess.toString();
            }
        } while(!passwordAlreadyFound);


        /*
        do {
            String newStartingString = "";
            for (int i = 0; i < substringGuess.length() + 1; i++) {
                newStartingString += "a";
            }

            substringGuess = new StringBuilder(newStartingString);
            for(char i_char = 'a'; i_char <= 'z'; i_char++) {
                //hackedPasswordGuess = new StringBuilder(newStartingString);
                guesses[0] = "" + i_char;
                System.out.println("outer:" + guesses[0]);

                for (int j = 0; j < substringGuess.length(); j++) {
                    for (char j_char = 'a'; j_char <= 'z'; j_char++) {
                        substringGuess.setCharAt(j, j_char);
                        System.out.println("->inner:" + substringGuess);
                        guesses[1] = substringGuess.toString();
                        String guessJoinedInner = String.join("", guesses);

                        if (!guessesDatabase.contains(guessJoinedInner)) {
                            guessesDatabase.add(guessJoinedInner);
                        }
                        if (!guessesDatabase.contains(guessJoinedInner + substringGuess)) {
                            guessesDatabase.add(guessJoinedInner + substringGuess);
                        }
                        if (!guessesDatabase.contains(guessJoinedInner + substringGuess)) {
                            guessesDatabase.add(guessJoinedInner + substringGuess);
                        }
                        if (!guessesDatabase.contains(guessJoinedInner + j_char)) {
                            guessesDatabase.add(guessJoinedInner + j_char);
                        }
                        if (!guessesDatabase.contains(substringGuess.toString() + j_char)) {
                            guessesDatabase.add(substringGuess.toString() + j_char);
                        }
                        if (!guessesDatabase.contains(guesses[1])) {
                            guessesDatabase.add(guesses[1]);
                        }
                        if (!guessesDatabase.contains(guesses[1] + guesses[0])) {
                            guessesDatabase.add(guesses[1] + guesses[0]);
                        }
                        if (!guessesDatabase.contains(guesses[0] + guesses[1])) {
                            guessesDatabase.add(guesses[0] + guesses[1]);
                        }

                        if (!guessesDatabase.contains(guesses[1] + j_char)) {
                            guessesDatabase.add(guesses[1] + j_char);
                        }
                        if (!guessesDatabase.contains(guesses[1] + guesses[0] + j_char)) {
                            guessesDatabase.add(guesses[1] + guesses[0] + j_char);
                        }
                        if (!guessesDatabase.contains(guesses[0] + guesses[1] + j_char)) {
                            guessesDatabase.add(guesses[0] + guesses[1] + j_char);
                        }

                        // the rest of string needs additional loop
                        for (int m = 0; m < substringGuess.length(); m++) {
                            for (char m_char = 'a'; m_char <= 'z'; m_char++) {
                                substringGuess.setCharAt(m, m_char);
                                System.out.println(" --> inner #2:" + substringGuess);
                                guesses[2] = substringGuess.toString();

                                String guessJoinedInner2 = String.join("", guesses);
                                if (!guessesDatabase.contains(guessJoinedInner2)) {
                                    guessesDatabase.add(guessJoinedInner2);
                                }
                                if (!guessesDatabase.contains(guessJoinedInner2 + substringGuess)) {
                                    guessesDatabase.add(guessJoinedInner2 + substringGuess);
                                }
                                if (!guessesDatabase.contains(guessJoinedInner2 + m_char)) {
                                    guessesDatabase.add(guessJoinedInner2 + m_char);
                                }
                                if (!guessesDatabase.contains(substringGuess.toString() + m_char)) {
                                    guessesDatabase.add(substringGuess.toString() + m_char);
                                }
                                if (!guessesDatabase.contains(guesses[2])) {
                                    guessesDatabase.add(guesses[2]);
                                }
                                if (!guessesDatabase.contains(guesses[0] + m_char)) {
                                    guessesDatabase.add(guesses[0] + m_char);
                                }
                                if (!guessesDatabase.contains(guesses[1] + m_char)) {
                                    guessesDatabase.add(guesses[1] + m_char);
                                }
                                if (!guessesDatabase.contains(guesses[2] + m_char)) {
                                    guessesDatabase.add(guesses[2] + m_char);
                                }

                                if (!guessesDatabase.contains(guesses[0] + guesses[2] + m_char)) {
                                    guessesDatabase.add(guesses[0] + guesses[2] + m_char);
                                }
                                if (!guessesDatabase.contains(guesses[1] + guesses[2] + m_char)) {
                                    guessesDatabase.add(guesses[1] + guesses[2] + m_char);
                                }
                                if (!guessesDatabase.contains(guesses[2] + guesses[1] + m_char)) {
                                    guessesDatabase.add(guesses[2] + guesses[1] + m_char);
                                }
                                if (!guessesDatabase.contains(guesses[0] + guesses[2] + m_char)) {
                                    guessesDatabase.add(guesses[0] + guesses[2] + m_char);
                                }
                                if (!guessesDatabase.contains(guesses[2] + guesses[0] + m_char)) {
                                    guessesDatabase.add(guesses[2] + guesses[0] + m_char);
                                }
                                if (!guessesDatabase.contains(guesses[2] + guesses[1] + guesses[0] + m_char)) {
                                    guessesDatabase.add(guesses[2] + guesses[1] + guesses[0] + m_char);
                                }
                                if (!guessesDatabase.contains(guesses[2] + guesses[0] + guesses[1] + m_char)) {
                                    guessesDatabase.add(guesses[2] + guesses[0] + guesses[1] + m_char);
                                }
                                if (!guessesDatabase.contains(guesses[1] + guesses[2] + guesses[0] + m_char)) {
                                    guessesDatabase.add(guesses[2] + guesses[2] + guesses[0] + m_char);
                                }
                                if (!guessesDatabase.contains(guesses[1] + guesses[0] + guesses[2] + m_char)) {
                                    guessesDatabase.add(guesses[1] + guesses[0] + guesses[2] + m_char);
                                }
                                if (!guessesDatabase.contains(guesses[0] + guesses[2] + guesses[1] + m_char)) {
                                    guessesDatabase.add(guesses[0] + guesses[2] + guesses[1] + m_char);
                                }

                                if (!guessesDatabase.contains(guesses[0] + guesses[2])) {
                                    guessesDatabase.add(guesses[0] + guesses[2]);
                                }
                                if (!guessesDatabase.contains(guesses[1] + guesses[2])) {
                                    guessesDatabase.add(guesses[1] + guesses[2]);
                                }
                                if (!guessesDatabase.contains(guesses[2] + guesses[1])) {
                                    guessesDatabase.add(guesses[2] + guesses[1]);
                                }
                                if (!guessesDatabase.contains(guesses[0] + guesses[2])) {
                                    guessesDatabase.add(guesses[0] + guesses[2]);
                                }
                                if (!guessesDatabase.contains(guesses[2] + guesses[0])) {
                                    guessesDatabase.add(guesses[2] + guesses[0]);
                                }
                                if (!guessesDatabase.contains(guesses[2] + guesses[1] + guesses[0])) {
                                    guessesDatabase.add(guesses[2] + guesses[1] + guesses[0]);
                                }
                                if (!guessesDatabase.contains(guesses[2] + guesses[0] + guesses[1])) {
                                    guessesDatabase.add(guesses[2] + guesses[0] + guesses[1]);
                                }
                                if (!guessesDatabase.contains(guesses[1] + guesses[2] + guesses[0])) {
                                    guessesDatabase.add(guesses[2] + guesses[2] + guesses[0]);
                                }
                                if (!guessesDatabase.contains(guesses[1] + guesses[0] + guesses[2])) {
                                    guessesDatabase.add(guesses[1] + guesses[0] + guesses[2]);
                                }
                                if (!guessesDatabase.contains(guesses[0] + guesses[2] + guesses[1])) {
                                    guessesDatabase.add(guesses[0] + guesses[2] + guesses[1]);
                                }
                                // 0 1 2 is already in the join...
                            }
                            // reset
                            substringGuess.setCharAt(m, 'a');
                            //substringGuess.setCharAt(m, 'a');
                        }
                        // reset
                        // substringGuess.setCharAt(j, 'a');
                        substringGuess.setCharAt(j, 'a');
                    }
                    // reset
                    // substringGuess.setCharAt(j, 'a');

                }
            }

            // System.out.println(substringGuess);
            System.out.println("Guessed words in database: " + guessesDatabase.size());
            System.out.println("Checking the collected DB of guesses...");

            System.out.println("Creating possible new string combinations with last letter...");
            ArrayList<String> missingItems = new ArrayList<>();

            int i = 0;
            for (String guess : guessesDatabase) {

                if (passwordAlreadyFound) {
                    break;
                }

                //System.out.println("guesses in db:" + guessesDatabase.size());
                if(guess.contains(debugStr)) {
                    System.out.println("DEBUG: " + guess);
                }
                if (guess.equals(password)) {
                    passwordAlreadyFound = true;
                    correctPasswordGuess = guess;
                    break;
                }

                for (char a = 'a'; a <= 'z'; a++) {
                    String guessAndLastLetter = guess + a;
                    if (guessAndLastLetter.equals(password)) {
                        passwordAlreadyFound = true;
                        correctPasswordGuess = guessAndLastLetter;
                        break;
                    }
                    if(!guessesDatabase.contains(guessAndLastLetter) && !missingItems.contains(guessAndLastLetter)) {
                        missingItems.add(guessAndLastLetter);
                    }
                }
                System.out.println(i + "/" + guessesDatabase.size());
                i++;
            }
            System.out.println("Collected " + missingItems.size() + " additional words.");
            guessesDatabase.addAll(missingItems);
            System.out.println("Guessed words in database after adding new combinations: " + guessesDatabase.size());
            testedPositionIndex++;
        } while (!passwordAlreadyFound);

         */


        System.out.println("Hacked password is:" + correctPasswordGuess);

        timeAfter = System.currentTimeMillis();
        timeAfterNanoSec = System.nanoTime();
        timeDifference = timeAfter - timeBefore;
        timeDifferenceNano = timeAfterNanoSec - timeBeforeNanoSec;
        System.out.println("Time after: " + timeAfter);
        System.out.println("Time of the execution: " + timeDifference + " ms"); // NOTICE: If you see 0 it is because it is faster than <0ms, need ns
        System.out.println("Time of the execution: " + timeDifferenceNano + " ns");
    }
}