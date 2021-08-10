package CapitalOne;

import java.util.Arrays;
import java.util.List;

public class ReformatDate {
    static public String reformatDate(String date) {

        String[] monthArray = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        List<String> list = Arrays.asList(monthArray);

        String[] split = date.split(" ");
        String day = split[0].replaceAll("\\D", "");
        // \D means "not digit" in regex
        int month = list.indexOf(split[1]);

        // "%02d" means if length of the argument is less than 2 then pad with a zero
        return split[2] + "-" + String.format("%02d", month) + "-" + String.format("%02d", Integer.parseInt(day));
    }

    public static void main(String[] args) {
        System.out.println(reformatDate("20th Oct 2052"));
        System.out.println(reformatDate2("2052-10-20"));

    }
    static public String reformatDate2(String date) {

        String[] monthArray = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        List<String> list = Arrays.asList(monthArray);

        String[] split = date.split("-");
        String day = split[0].replaceAll("\\D", "");
        // \D means "not digit" in regex
        String month = list.get(Integer.parseInt(split[1]));

        // "%02d" means if length of the argument is less than 2 then pad with a zero
        return split[2]+ "th " + month+" "+String.format("%02d", Integer.parseInt(day))  ;
    }


}
