/**
 * GIVEN A STACK
 * - METHOD TO ADD ELEMENT IN THE STACK
 * - REMOVE ELEMENT IN THE STACK
 * - GET THE LATEST ADDED ELEMENT (PEEK)
 * - GET THE MAX VALUE OF THE STACK
 * - GET THE MINIMUM VALUE OF THE STACK
 * - GET THE CURRENT STACK
 * <p>
 * SOLUTION
 * MAINTAINING A ARRAY OF HASHMAP OF THE MIN VALUE AND MAX VALUE EVERY TIME A NEW ELEMENT IS ADDED IN THE STACK
 * RETURN THE MIN AND MAX VALUE FORM THE HASHMAP
 * WHEN POP REMOVE THE TOP INDEX OF THE HASH MAP FROM THE ARRAY
 * <p>
 * TIME COMPLEXITY 0(1) space o(1)
 */

package Stacks.Medium;

import java.util.ArrayList;
import java.util.HashMap;

public class MinMaxStack {

    public static void main(String[] args) {
        MinMaxStack minMaxStack = new MinMaxStack();

        ArrayList<Integer> stack = minMaxStack.push(2);
        Integer min = minMaxStack.getMin();
        Integer max = minMaxStack.getMax();
        Integer peek = minMaxStack.peek();

        System.out.println("Stack: " + stack.toString());
        System.out.println("max:" + max);
        System.out.println("min:" + min);
        System.out.println("peek:" + peek);

        ArrayList<Integer> stack2 = minMaxStack.push(5);
        Integer min2 = minMaxStack.getMin();
        Integer max2 = minMaxStack.getMax();
        Integer peek2 = minMaxStack.peek();
        System.out.println("Stack: " + stack2.toString());
        System.out.println("max:" + max2);
        System.out.println("min:" + min2);
        System.out.println("peek:" + peek2);


        ArrayList<Integer> stack3 = minMaxStack.push(7);
        Integer min3 = minMaxStack.getMin();
        Integer max3 = minMaxStack.getMax();
        Integer peek3 = minMaxStack.peek();
        System.out.println("Stack: " + stack3.toString());
        System.out.println("max:" + max3);
        System.out.println("min:" + min3);
        System.out.println("peek:" + peek3);

        ArrayList<Integer> stack4 = minMaxStack.pop();
        Integer min4 = minMaxStack.getMin();
        Integer max4 = minMaxStack.getMax();
        Integer peek4 = minMaxStack.peek();
        System.out.println("Stack: " + stack4.toString());
        System.out.println("max:" + max4);
        System.out.println("min:" + min4);
        System.out.println("peek:" + peek4);

    }

    /**
     * MIN MAX VALUE INDEXING
     */
    protected ArrayList<HashMap<String, Integer>> StackMinMax;
    /**
     * ACTUAL STACK
     */
    protected ArrayList<Integer> Stack;

    MinMaxStack() {
        this.StackMinMax = new ArrayList<>();
        this.Stack = new ArrayList<>();
    }

    /**
     * REMOVING AN ITEM FROM THE STACK
     */
    public ArrayList<Integer> pop() {
        if (!this.StackMinMax.isEmpty()) {
            this.StackMinMax.remove(this.StackMinMax.size() - 1);
        }
        if (!this.Stack.isEmpty()) {
            this.Stack.remove(this.Stack.size() - 1);
        }
        return this.Stack;
    }

    /**
     * GET THE LATEST PUSHED ELEMENT FROM THE STACK
     */
    public Integer peek() {
        if (this.Stack.isEmpty()) {
            return null;
        }
        return this.Stack.get(this.Stack.size() - 1);
    }

    /**
     * GET ALL THE ELEMENT FORM THE STACK
     */
    public ArrayList<Integer> getStack() {
        return this.Stack;
    }

    public ArrayList<Integer> push(int number) {
        HashMap<String, Integer> minmax = new HashMap<>();
        minmax.put("min", number);
        minmax.put("max", number);

        /*UPDATING THE MIN MAX MAPPING */
        if (!this.StackMinMax.isEmpty()) {
            HashMap<String, Integer> previousMinMax = this.StackMinMax.get(this.StackMinMax.size() - 1);
            minmax.put("min", Math.min(number, previousMinMax.get("min")));
            minmax.put("max", Math.max(number, previousMinMax.get("max")));
        }

        this.StackMinMax.add(minmax);
        this.Stack.add(number);
        return this.Stack;
    }

    public Integer getMin() {
        if (this.StackMinMax.isEmpty()) {
            return null;
        }
        return this.StackMinMax.get(this.StackMinMax.size() - 1).get("min");
    }

    public Integer getMax() {
        if (this.StackMinMax.isEmpty()) {
            return null;
        }
        return this.StackMinMax.get(this.StackMinMax.size() - 1).get("max");
    }
}
