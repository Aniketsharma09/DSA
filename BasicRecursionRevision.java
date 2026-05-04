public class BasicRecursionRevision {

    // Function for printing name n time
    public static void printName(String name, int n){
        if(n == 0) return;

        System.out.println(name);
        printName(name, n-1);
    }

    // Function for printing N to 1
    public static void printNTo1(int n){
        if(n == 0) return;

        System.out.println(n);

        printNTo1(n-1);
    }

    // Function for printing 1 to N
    public static void print1ToN(int n){
        if(n == 0) return;
        print1ToN(n-1);
        System.out.println(n);
    }

    // Function for finding the sum of first n number's
    public static int findSum(int n){
        if(n == 1) return 1;
        return n + findSum(n-1);
    }

    // Function for finding the n!
    public static int findFact(int n){
        if(n <= 1) return 1;

        return n * findFact(n-1);
    }

    // Function for reversing the array recursivly
    public static void reverseArray(int arr[], int s, int e){
        if(s >= e) return;
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
        reverseArray(arr, s+1, e-1);
    }

    // Function for checking if string is palindrome or not recursvely
    public static boolean isPalindrome(String str, int s, int e){
        if(s >= e) return true;
        else if(str.charAt(s) != str.charAt(e)) return false;
        return isPalindrome(str, s+1, e-1);
    }

    // Function for findng the fibonacci number
    public static int findFibo(int n){
        if(n <= 1) return n;
        return findFact(n-1) + findFact(n-2);
    }



    public static void main(String[] args){

        int n = 5;
        String name = "Aniket";

        System.out.println("Printing name "+ name + " " + n + " times");
        printName(name, n);
        System.out.println("");
        System.out.println("");

        System.out.println("Printing "+ n + " to 1");
        printNTo1(n);
        System.out.println("");
        System.out.println("");

        System.out.println("Printing 1 to " + n);
        print1ToN(n);
        System.out.println("");
        System.out.println("");

        System.err.println("Sum of first " + n + " numbers is ");
        System.out.println(findSum(n));
        System.out.println("");
        System.out.println("");

        System.out.println(n +"! is ");
        System.out.println(findFact(n));
        System.out.println("");
        System.out.println("");

        int arr[] = {1, 2, 3, 4, 5};
        System.err.println("Array before reversing ");
        for(int ele : arr){
            System.out.println(ele);
        }
        reverseArray(arr, 0, arr.length-1);
        System.out.println("Array after reversing ");
        for(int ele : arr){
            System.out.println(ele);
        }
        System.out.println("");
        System.out.println("");

        String str = "madam";
        System.out.println("Checking if string " + str + " is palindrome or not");
        System.out.println(isPalindrome(str, 0, str.length() -1));
        System.out.println("");
        
        System.err.println("fibonacci number of 6 is");
        System.out.println(findFibo(n));

    }
}
