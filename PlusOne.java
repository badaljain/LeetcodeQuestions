package LeetcodePrograms;

/**
 * Created by rkhurana on 7/25/18.
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        return newNumber;
    }

    public static void main(String [] args){
        int []num = {8,9};
        System.out.println(plusOne(num));
    }
}
