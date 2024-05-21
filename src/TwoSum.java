/**
 * TWO ARRAY SUM
 * SOLUTION 2 POINTERS
 *
 */
import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] array = {7,6,3,4,5};
        int[] result = twoSum.returnTwoSums(array,8);
        System.out.println(Arrays.toString(result));
    }

    public int[] returnTwoSums(int[] array, int sum) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left] + array[right];
            if (temp == sum) {
                return new int[]{array[left],array[right]};
            }else if(temp > sum){
                right--;
            }else {
                left++;
            }
        }
        return new int[0];
    }


}
