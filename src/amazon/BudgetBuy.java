package amazon;

import java.util.ArrayList;
import java.util.List;

public class BudgetBuy {

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

    public static void main(String arg[]){
        int p[] = new int[]{2,3};
        int s[] = new int[]{4};
        int t[] = new int[]{2,3};
        int k[] = new int[]{1,2};
        int rupee = 10;

        List<int []> prices= new ArrayList<>();
        prices.add(p);
        prices.add(s);
        prices.add(t);
        prices.add(k);
        dfs(prices, rupee, 0, 0);
        System.out.println(count);
    }

}



//https://leetcode.com/discuss/interview-question/928404/question-asked-in-bny-mellon-for-sde


//#include<bits/stdc++.h>
//        using namespace std;
//
//        int m[5][100001];
//        int helper(vector<vector<int>>item,int budget,int level,int curr)
//        {
//
//        if(curr<=budget&&level==4)
//        {
//        return 1;
//        }
//        if(curr>budget&&level==4)
//        {
//        return 0;
//        }
//        if(m[level][curr]!=-1)
//        {
//        return m[level][curr];
//        }
//        int count=0;
//
//        for(int i=0;i<item[level].size();i++)
//        {
//
//        count+=helper(item,budget,level+1,curr+item[level][i]);
//
//
//        }
//
//        m[level][curr]=count;
//        return count;
//        }
//        int main()
//        {
//        int budget=10;
//
//        vector<vector<int>>item;
//        vector<int>v1{2,3};
//        vector<int>v2{4};
//        vector<int>v3{2,3};
//        vector<int>v4{2,1};
//        item.push_back(v1);
//        item.push_back(v2);
//        item.push_back(v3);
//        item.push_back(v4);
//        memset(m,-1,sizeof m);
//
//        cout<<helper(item,budget,0,0);
//        return 0;
//        }