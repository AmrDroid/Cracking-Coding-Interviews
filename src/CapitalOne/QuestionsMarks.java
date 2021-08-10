package CapitalOne;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


//https://www.coderbyte.com/solution/Questions%20Marks#JavaScript
public class QuestionsMarks {
    public static String QuestionsMarks(String str) {
        int quantityOfQuestionMarks = 0, sumOfNumbers = 0;
        boolean foundFirstNumber = false, foundSecondNumber = false, valid = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 49 && str.charAt(i) <= 57) { //if it´s a number
                sumOfNumbers += Integer.valueOf(String.valueOf(str.charAt(i)));
                //it checks whether it's the first or the second number that has been found
                if (foundFirstNumber == false) foundFirstNumber = true;
                else foundSecondNumber = true;
            }

            //We only care about question marks found between two numbers
            if (str.charAt(i) == 63 && (foundFirstNumber || foundSecondNumber)) quantityOfQuestionMarks++;

            if (foundFirstNumber && foundSecondNumber) {
                if (sumOfNumbers == 10 && quantityOfQuestionMarks == 3) valid = true;
                else if (sumOfNumbers == 10 && quantityOfQuestionMarks != 3) valid = false;

                //It resets the flags to resume the search for another pair of numbers
                foundFirstNumber = false;
                foundSecondNumber = false;
                quantityOfQuestionMarks = 0;
                sumOfNumbers = 0;
            }
        }

        if (valid) return "true";
        return "false";
    }

    public static void main(String[] args) {
        // keep this function call here

        System.out.print(QuestionsMarks("acc?7??sss?3rr1??"));
        System.out.print(QuestionsMarks2("acc?7??sss?3rr1??"));
        System.out.print(QuestionsMarks3("acc?7??sss?3rr1??"));
    }


    public static String QuestionsMarks2(String str) {

        // code goes here
    /* Note: In Java the return type of a function and the
       parameter types being passed are defined, so this return
       call must match the return type of the function.
       You are free to modify the return type. */
        str = str.replaceAll("[a-z]", "");
        Pattern pattern = Pattern.compile("([0-9])([?])([?])([?])([0-9])");
        Pattern falseP1 = Pattern.compile("([0-9])([?])([?])([0-9])");
        Pattern falseP2 = Pattern.compile("([0-9])([?])([0-9])");
        Matcher falseMatchP1 = falseP1.matcher(str);
        Matcher falseMatchP2 = falseP2.matcher(str);
        Matcher matchPattern = pattern.matcher(str);
        if (falseMatchP1.find() || falseMatchP2.find()) {
            return "false";
        }
        if (matchPattern.find()) {
            return "true";
        }
        return "false";
    }

    public static String QuestionsMarks3(String str) {

        int i = 0;
        while (i < str.length()) {
            if (Character.isDigit(str.charAt(i))) {
                int j = i + 1;
                int qCount = 0;
                while (j < str.length()) {
                    if (str.charAt(j) == '?') qCount++;
                    if (Character.isDigit(str.charAt(j))) {
                        int sum = Integer.parseInt(str.charAt(i) + "") + Integer.parseInt(str.charAt(j) + "");
                        if (!(sum == 10 && qCount == 3)) return "false";
                        i = j;
                        break;
                    }
                    j++;
                }
            }
            i++;
        }
        return "true";
    }


}
