package CapitalOne;

public class SumTwoArrayChar {

    static public int sum(char[] n1, char[] n2) {

        String s1="",s2="";
        for(char a : n1)s1+=a;
        for(char a : n2)s2+=a;
        int x = Integer.parseInt(s1);
        int y = Integer.parseInt(s2);
        return x + y;
    }

    public static void main(String[] args) {

        char[] n1 = new char[]{'3', '5', '9'};
        char[] n2 = new char[]{'1', '2', '8', '4'};
        System.out.println(sum(n1, n2));
    }
}
