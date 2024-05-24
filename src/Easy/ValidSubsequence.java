/**
 * EXPLANATION
 * ARRAY  A - [1,2,4,5,6,7,8,9] B - [1,5,7,8]
 * HERE B IS A VALID SUBSEQUENCE OF A IF ALL THE ELEMENTS IN THE B ARE IN A , WITH ORDER
 * A - [1,2,3,4] B - [2,1] - IS NOT A VALID SUBSEQUENCE
 * *** ALGORITHM ******
 * TIME - O(n)  Space - O(1)
 * 1. STARTING INDEX A = 0 -> POINTER FOR MAIN ARRAY
 * 2. STARTING INDEX B = 0 -> POINTER FOR SEQUENCE
 * 3. WHILE A < length of MAIN ARRAY AND B < length of SEQUENCE - IF ELEMENT AT THE MAIN ARRAY AND SEQUENCE ARRAY
 * i. IF MAIN[A] === SEQUENCE[B]
 * B ++;
 * ii. A++;
 * 4. IF B === LENGTH OF SEQUENCE -> IT IS A VALID SUBSEQUENT (ALL ELEMENT WITH CORRECT POSITION HAS BEEN FOUND AND MAPPED)
 */

package Easy;

public class ValidSubsequence {

    public static void main(String[] args) {
        ValidSubsequence vs = new ValidSubsequence();

        /* MAIN ARRAY  */
        int[] array = {2, 3, -1, 5, -6, 10, 15};
        /* SUB SEQUENCE ASSERTIVE */
        int[] sequenceAssertive = {2, -1, 10};
        /* SUB SEQUENCE FALSE */
        int[] sequenceFalse = {2, 15, 10};

        boolean assertiveTest = vs.isValidSubsequence(array, sequenceAssertive);
        boolean failTest = vs.isValidSubsequence(array, sequenceFalse);

        if (assertiveTest && !failTest) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");

        }
    }


    public boolean isValidSubsequence(int[] array, int[] sequence) {
        int arrayIndex = 0, sequenceIndex = 0;
        while (arrayIndex < array.length && sequenceIndex < sequence.length) {
            if (array[arrayIndex] == sequence[sequenceIndex]) {
                sequenceIndex++;
            }
            arrayIndex++;
        }
        return sequenceIndex == sequence.length;
    }
}
