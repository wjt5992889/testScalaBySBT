package Concept.tailrecursive;

public class RecursiveJava {


    public static int fib(int n){
        if(n <= 2){
            return 1;
        }else{
            return fib(n-1) + fib(n-2);
        }
    }

    public static long fibRecursive(int n,long a,long b){
        if(n <= 2){
            return b;
        }else{
            return fibRecursive(n-1,b,a+b);
        }
    }

    private static final long fibloop(int n, long acc1, long acc2) {
        while (n > 2) {
            final int loc_0 = n - 1;
            final long loc_1 = acc2;
            acc2 += acc1;
            acc1 = loc_1;
            n = loc_0;
        }
        return acc2;
    }

    public static void main(String[] args) {
//        System.out.println(fib(50));
        //StackOverflowError
//        System.out.println(fibRecursive(15000,1,1));
        System.out.println(fibloop(15000,1,1));
    }
}
