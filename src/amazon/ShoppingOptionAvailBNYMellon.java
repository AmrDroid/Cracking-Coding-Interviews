package amazon;

import java.util.*;

public class ShoppingOptionAvailBNYMellon {
    static int count=0;
    private static void dfs(List<int []> prices, int r, int pos, int sum){

        if(sum > r) return;
        if(sum <= r && pos == prices.size()) {
            count++;
            return;
        }

        for(int x : prices.get(pos))
        {
            sum +=x;
            dfs(prices, r, pos+1, sum);
            sum -=x;
        }
    }
    //https://www.geeksforgeeks.org/amazon-interview-experience-for-sde-2-4-years-experienced/
    //https://leetcode.com/discuss/interview-question/928404/question-asked-in-bny-mellon-for-sde
    public static void main(String arg[]){
//        pants=[3, 5, 7], shirts = [4, 7, 8],
//        skirts = [5, 8], shoes = [3], budget = 25
        int p[] = new int[]{3, 5, 7};
        int s[] = new int[]{4, 7, 8};
        int t[] = new int[]{5, 8};
        int k[] = new int[]{3};
        int rupee = 25;

        List<int []> prices= new ArrayList<>();
        prices.add(p);
        prices.add(s);
        prices.add(t);
        prices.add(k);
        dfs(prices, rupee, 0, 0);
        System.out.println(count);
    }
}
