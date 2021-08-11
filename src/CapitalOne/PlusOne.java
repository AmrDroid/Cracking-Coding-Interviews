package CapitalOne;

import java.util.Arrays;

public class PlusOne {
   static public int[] plusOne2(int[] digits) {
        if(digits==null||digits.length==0)
            return new int[0];
        int carry = 1;
        for(int i=digits.length-1; i>=0; i--){
            int sum = digits[i]+carry;
            if(sum>=10){
                carry=1;
            }else{
                carry=0;
            }
            digits[i]=sum%10;
        }
        if(carry==1){
            int[] result = new int[digits.length+1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0]=1;
            return result;
        }else{
//int[] result = new int[digits.length];
            return digits;
        }
    }
    public static int[] plusOne(int[] digits) {
//        The time complexity of the above code is O(n) because we are traversing the digits array only once. Here n is the length of the digit array.
//
//                Space complexity
//        The space complexity of the above code is O(1)  in case the array contains at least one digit smaller than 9, otherwise O(n).
//

        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++; return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        return newNumber;
    }
    public static void main(String[] args) {
        int [] arr = {4,3,2,1};
        int [] arr2 = {4,3,2,1};
        int[]ans=plusOne(arr);
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(plusOne2(arr2)));

        test(null);
    }
    static void test(int obj){
        System.out.println("test2");
    }
  static   void test(String str){

       System.out.println("test1");
    }


}
