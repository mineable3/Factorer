import java.util.Scanner;

public class factoringTwoPrimeNumsProduct {

    static long N;//the input number or the product of p and q
    static long g = 8;//random number that doesn't share a factor with N
    static long r;//what g is raised to the power of to get a mulitple of N
    static long p;//one prime number that is a factor of N
    static long q;//one prime number that is a factor of N
    static long remainder = 9999999;//the remainder of (g^r)/N
    static long secondRemainder = 9999;
    static long thirdRemainder = 99999;

    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {



        
        //collecting the input number N
        System.out.print("What number would you like me to sovle for?:  ");
        N = reader.nextInt();

        //factoring using a brute force i made
        Factorer F = new Factorer(N);

        System.out.println(F);







//=========================fancy way that will be used by quantum computers========================











        //setting g to a random number
        //g must be smaller than N and can not share any factors
        while ((g > N) || (g <= 1)){
            g = (long) (Math.random()*10);
        }

        //System.out.println("\ng: " + g);

        /* 
        if(g shares factors with N) {
            repick the value of g and check again
        }*/



        //Finding the r value that makes g^r % N equal to 1

        //the loops ends when we overrun  or when the remainder = 1
        //it keeps running if holder 1 or 2 will equal N
        for (long i = 1; ((remainder != 1) && (i <=1000)) || (((Math.pow(g, (r/2)) + 1) == N) || ((Math.pow(g, (r/2)) - 1) == N)); i++) {
            //System.out.println("iteration: " + i);
            remainder = (long) (Math.pow(g, i) % N);
            //System.out.println("Remainder: " + remainder);
            r = i;
        }

        //===================IF r is odd PICK A DIFFERENT g and start again

        //System.out.println("r: " + r);

        

        long holder1 = (long)Math.pow(g, (r/2)) + 1;
        long holder2 = (long)Math.pow(g, (r/2)) - 1;

        //System.out.println(holder1 + "one of these two");
        //System.out.println(holder2 + "one of these two");

        long answer1 = -9000;
        long answer2 = -9000;

        if (holder1 > N) {
            //euclids algorithm with holder1 as the first argument
            answer1 = euclidsAlgorithm(holder1, N);
        } else if (holder1 < N) {
            //euclids algorithm with holder2 as the first argument
            answer1 = euclidsAlgorithm(N, holder1);
        } else {
            //System.out.println("Whut?");
        }

        if (holder2 > N) {
            //euclids algorithm with holder1 as the first argument
            answer2 = euclidsAlgorithm(holder2, N);
        } else if (holder2 < N) {
            //euclids algorithm with holder2 as the first argument
            answer1 = euclidsAlgorithm(N, holder2);
        } else {
            //System.out.println("Whut??");
        }


        //System.out.println("either " + answer1 + " or " + answer2);
    
    }







    public static long euclidsAlgorithm(long biggestNumber, long smallerNumber) {



        //System.out.println("\nbig number:" + biggestNumber + " and small number:" + smallerNumber);

        long thingToReturn = 9999900;
        boolean loop = true;

        //A = biggestNumber, B = smallerNumber
        //Write A in quotient remainder form (A = B⋅Q + R)
        //Find GCD(B,R) using the Euclidean Algorithm since GCD(A,B) = GCD(B,R)

        //A/B = Q + R




        //set up for the loop
        secondRemainder = biggestNumber % smallerNumber;
        thirdRemainder = smallerNumber;


        if((secondRemainder == 0) && (smallerNumber != 1)) {
            thingToReturn = smallerNumber;
            loop = false;
        }







        while (loop) {


            remainder = secondRemainder % thirdRemainder;
            //System.out.println("remainder " + remainder);

            if (remainder == 0) {
                thingToReturn = thirdRemainder;
                break;
            }

            secondRemainder = thirdRemainder % remainder;
            //System.out.println("secondRemainder " + secondRemainder);

            if (secondRemainder == 0) {
                thingToReturn = remainder;
                break;
            }

            thirdRemainder = remainder % secondRemainder;
            //System.out.println("thirdRemainder " + thirdRemainder);

            if (thirdRemainder == 0) {
                thingToReturn = secondRemainder;
                break;
            }
        }

        //System.out.println("returning: " + thingToReturn);

        return thingToReturn;
    }



}
