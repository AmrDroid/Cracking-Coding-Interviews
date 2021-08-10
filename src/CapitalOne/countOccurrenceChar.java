package CapitalOne;

public class countOccurrenceChar {

    static int countinString(char ch, String s)
    {
        //base case;
        if(s.length()==0)
            return 0;
        int count = 0;

        //checking if the first character of
        //the given string is that character
        //or not
        if(s.charAt(0)==ch)
            count++;

        //this will count the occurrence of
        //given character in the string
        //from index 1 to the last
        //index of the string
        count+=countinString(ch,s.substring(1));


        return count;
    }
    public static void main (String[] args) {
        String str= "geeksforgeeks";
        char c = 'e';
        System.out.println(countinString(c,str));
    }

}
