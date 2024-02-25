package number.theory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/*
 1. Prime or not?
 2. Sieve of Prime Numbers [if at index in array is true it is prime number]
 3. Prime Factorization
 4. Sieve of Prime Factorization [ need to check how to implement this.]
 5. Binary Exponentiation
 6. GCD
 7. LCM uses gcd

 */

public abstract class NumberTheory {

    public static boolean isPrimeNumber(int number){
        double sqrt = Math.sqrt(number);
        for (int i = 2; i <=sqrt ; i++){
            if (number%i==0){
                return false;
            }
        }
        return true;
    }

    // 50 = 2^1, 5^2
    public static void PrimeFactorization(Integer n){
        System.out.println("Prime factors of number "+ n + " are below:");
        for (int i = 2; i<= n; i++){
            if (n%i==0){
                int count = 0;
                while(n%i==0){
                    n = n / i;
                    count++;
                }
                System.out.println(i+"^"+count);
            }
        }
    }

    // mark all the values as false
    // mark all the mutiples starting from 2 as true
    public static List<Boolean> buildSieveOfPrimeNumbers(int n, Boolean printSieve){
        List<Boolean> sieveOfPrimeNumbers = new ArrayList<>(IntStream.rangeClosed(0, n + 1)
                .mapToObj(i -> true)
                .toList());


        for (int i = 2; i <= Math.sqrt(n); i++){
            if (sieveOfPrimeNumbers.get(i)){

                int multiple = i * 2;

                while(multiple<=n+1){
                    sieveOfPrimeNumbers.set(multiple, false);
                    multiple = multiple + i;
                }
            }
        }

        if (printSieve){
            for (int i = 2; i < sieveOfPrimeNumbers.size(); i++) {
                System.out.println(i + " - " + sieveOfPrimeNumbers.get(i));
            }
        }

        return sieveOfPrimeNumbers;

    }

    // example
    // 25 10
    // 10 5
    // 5 0
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    // Method to calculate LCM = (a * b) / gcd(a,b)
    public static int lcm(int a, int b) {
        int gcd = gcd(a, b);
       return gcd == 0 ? (a * b) : (a * b) / gcd;
    }


    //  mod support can also be added to binaryExponentiation
    public static int binaryExponentiation(int number, int power) {
        int result = 1;
        while (power > 0) {
            if (power % 2 == 1) //odd
            {
                result = (result * number);
                power--;
            } else {
                number = (number * number);
                power = power / 2;
            }
        }
        return result;
    }

}
