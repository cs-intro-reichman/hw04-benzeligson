public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println("Prime numbers up to " + n + ":");
        boolean[] NumbersToN = new boolean[n+1];
        // sets all values from 2 to ne prime until proven else
        for (int i = 2; i < NumbersToN.length; i++) {
            NumbersToN[i] = true;
        }
        int primeCounter = 0;
        for (int i = 0; i < NumbersToN.length; i++) {
            if (NumbersToN[i] == true) {
                System.out.println(i);
                primeCounter++;
                // this while loop sets all multiples of the
                // prime number (up to n) to be not prime
                int j = 2;
                while (i * j < NumbersToN.length) { 
                    NumbersToN[i * j] = false;
                    j++;
                }
            }
        }
        double precentage = ((double) primeCounter / (NumbersToN.length - 1)) * 100;
        System.out.println("There are " + primeCounter + 
        " primes between 2 and " + n +" (" + (int) precentage +"% are primes)");
    }
}