public class factorial{
    public static int calculation(int n){
        int fact=1;
        for (int i=1;i<=n;i++){
            fact=fact*i;

        }
    return fact;
    }
     public static void main(String[] args){
        int n=5;
        int res=calculation(n);
        System.out.println("factorial of "+n+"is : "+res);
     }
}