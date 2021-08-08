package amazon;

public class ProductAllElementExcceptIndex {
    public static void main(String[] args) {


        int arr[]={1,2,3,4,5};


        for(int i=0;i<arr.length;i++)
        {
            int res=1;
            for(int j=0;j<arr.length;j++)
            {
                if(i!=j)
                    res*=arr[j];
            }
            System.out.println(res+"  ");
        }

    }
}
