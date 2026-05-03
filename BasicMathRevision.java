import java.util.*;

public class BasicMathRevision {

    // Function for counting the digit in the number
    public static int countDigit(int n) {
        int count = 0;

        while (n > 0) {
            n /= 10;
            count++;
        }

        return count;
    }

    // Function for reversing the number
    public static int reverseNum(int n) {
        int rev = 0;

        while (n > 0) {
            int last = n % 10;
            rev = rev * 10 + last;
            n /= 10;
        }

        return rev;
    }

    // Function for checking if number is palindrome or not
    public static boolean isPlaindrome(int n) {
        return n == reverseNum(n);
    }

    // Function for checking Armstrong number
    public static boolean isArmstrong(int n) {
        int num = 0,
                copy = n;

        while (copy > 0) {
            int last = copy % 10;
            num += last * last * last;
            copy /= 10;
        }

        return n == num;
    }

    // Function for printing all the divisor of the number
    public static void printDivisor(int n) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                arr.add(i);

                if (i != n / i)
                    arr.add(n / i);
            }
        }

        Collections.sort(arr);

        for (int ele : arr) {
            System.out.println(ele);
        }
    }

    // Function for checking is number is prime or not
    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    // Function for finding the GCD/HCF of two number's
    public static int gcd(int n1, int n2) {
        if (n2 > n1)
            return gcd(n2, n1);

        if (n1 == 0)
            return n2;
        else if (n2 == 0)
            return n1;

        return gcd(n1 % n2, n2);
    }

    // Function for print all Prime factore of number
    public static void findAllPrimeFactore(int n) {

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    System.out.println(i);
                    n = n / i;
                }
            }
        }

        if (n > 1)
            System.out.println(n);
    }

    // Function for finding the n power p
    public static int findPower(int n, int p) {

        if (p == 0)
            return 1;

        int half = findPower(n, p / 2);

        if (p % 2 == 0)
            return half * half;
        else
            return n * half * half;
    }

    // Function for implementing the Sieve of eratosthens
    public static int[] sieve(int n) {

        int s[] = new int[n + 1];
        Arrays.fill(s, 1);
        s[0] = 0; // 0 and 1 is not prime
        s[1] = 0;

        for (int i = 2; i * i <= n; i++) {
            if (s[i] == 1) {
                for (int j = i * i; j <= n; j += i) {
                    s[j] = 0;
                }
            }
        }

        return s;
    }

    // Function for counting the prime in range
    public static int[] countPrime(int l, int r) {

        int primeCount[] = sieve((int) 1e6);

        int count = 0;

        for (int i = 2; i <= 1e6; i++) {
            if (primeCount[i] == 1) {
                count++;
                primeCount[i] = count;
            } else
                primeCount[i] = count;
        }

        return primeCount;
    }

    // Functionf for finding the smollest prime factore
    public static int[] findSmollestPrimeFactore() {

        int smolPriFactArr[] = new int[(int) 1e6];

        // initialy mark number is smollest prime factor's of it self
        for (int i = 0; i < 1e6; i++) {
            smolPriFactArr[i] = i;
        }

        for (int i = 2; i * i < 1e6; i++) {
            if (smolPriFactArr[i] == i) {
                for (int j = i * i; j < 1e6; j += i) {
                    if (smolPriFactArr[j] == j)
                        smolPriFactArr[j] = i;
                }
            }
        }

        return smolPriFactArr;
    }

    public static void main(String[] args) {
        int num = 153;

        System.out.println("Digit's in number " + num + "is :");
        System.out.println(countDigit(num));

        System.out.println("Reverse of number :");
        System.out.println(reverseNum(num));

        System.out.println("Is palindrome :");
        System.out.println(isPlaindrome(num));

        System.out.println("Is Armstrong :");
        System.out.println(isArmstrong(num));

        System.out.println("All divisor of number" + num);
        printDivisor(num);

        System.out.println("Is prime " + num);
        System.out.println(isPrime(num));

        System.out.println("GCD of 12 and 24");
        System.out.println(gcd(12, 24));

        System.out.println("Prime factor of number " + num);
        findAllPrimeFactore(num);

        System.out.println("5 power 5 is ");
        System.out.println(findPower(5, 5));

        System.out.println("Prime number's in range 40 ");
        int si[] = sieve(40);

        for (int i = 2; i < 40; i++) {
            if (si[i] == 1)
                System.out.println(i);
        }

        int l = 10,
                r = 50;
        System.out.println("Prime number's in ragne " + l + " " + r + " is ");
        int prefix[] = countPrime(l, r);
        System.out.println(prefix[r] - prefix[l - 1]);

        System.out.println("Smollest Prime factore of Number " + num);
        int primeFactArr[] = findSmollestPrimeFactore();
        System.out.println(primeFactArr[num]);
    }
}
