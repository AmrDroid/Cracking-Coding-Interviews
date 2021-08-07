package amazon;

import java.util.Stack;

public class ReverseIndividualWords {

    //function to reverse the individual words
    String reverse(String str) {
        //create a stack to access the string from end
        Stack<Character> s = new Stack<>();

        //push all the characters of the stack
        for(int i = 0; i < str.length();i++)
            s.push(str.charAt(i));

        //rev string to store the required output
        String rev = "";
        String temp = "";

        //till the stack becomes empty
        while(!s.isEmpty()) {
            //if top of the stack is a letter,
            //then append it to temp;
            if(Character.isLetter(s.peek()))
                temp = temp + s.pop();
                //if it is a space, the append space to rev
                //and also temp to rev
            else {
                rev = " " + temp +rev;
                //make the temp empty
                temp = "";
                s.pop();
            }
        }
        //if temp is not empty, add temp to rev at the front
        if(temp != "")
            rev = temp + rev;

        //return the output string
        return rev;
    }

    public static void main(String[] args) {
        String str = "Geeks for Geeks";

        ReverseIndividualWords obj = new ReverseIndividualWords();
        System.out.println(obj.reverse(str));
    }

}
