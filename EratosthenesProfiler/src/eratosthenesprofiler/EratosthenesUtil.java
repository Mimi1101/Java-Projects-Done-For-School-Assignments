package eratosthenesprofiler;

/**
 * Provides an implementation for the Eratosthene's sieve generator
 * Contains sieve and toString method.
 *
 * @author Duncan, Bibhushita Baral  <pre>50
 * Date: 9/4/2022
 * Course: csc 3102
 * Project # 0
 * Instructor: Dr. Duncan
 * </pre>
 */
import java.util.ArrayList;
import java.util.Arrays;

class EratosthenesUtil {

    /**
     * Generates a sequence of all primes less than the specified parameter
     *
     * @param n the upper bound on the prime sequence
     * @return an array list containing all primes in [2,n] or an empty array
     * list if n < 2.
     
     */
    public static ArrayList<Long> sieve(long n) {
        ArrayList<Long> primes = new ArrayList<>(); 
        ArrayList<Boolean> isPrime = new ArrayList<>();
        if(n<2){
            return primes; // if the number is less than twp
        }
        else{
        for(int b = 0; b<=n; b++){
         isPrime.add(true);} //specifying all the values in the array to true
        
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(isPrime.get(i)){
                for(int j = i*i; j<=n; j+=i){
                    isPrime.set(j, false); // setting the non-prime number values to false
                }
            }
        }
        for(int l=2; l<=n; l++ ){
            if(isPrime.get(l)){
                primes.add((long)l); //adding the prime numbers to the arraylist
            }
        }
        return primes;
    }
        

        
    }

    /**
     * Gives a string representation of the specified array list of longs
     * enclosed in a pair of curly brackets and each adjacent pair of primes
     * separated by a comma followed by a space.
     *
     * @param v an array list of longs
     * @return a string representation of an array list of longs
     */
    public static String toString(ArrayList<Long> v) {
        //Implement this method
        String hehe = "{";
        if (v.isEmpty()) {
            return "{ }";
        }
        hehe += v.get(0);
        for (int i = 1; i < v.size(); i++) {
            hehe += ", " + v.get(i);

        }
        hehe += "}";
        return hehe;
    }
}
