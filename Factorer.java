public class Factorer {

    private long factorSmall;
    private long factorBig;
    private long numToFactor;
    private boolean prime;
    private boolean negative;

    public Factorer(long numToFactor) {
        this.numToFactor = numToFactor;

        factorSmall = smallerFactor(numToFactor);
        factorBig = biggerFactor(numToFactor);
    }


    public long smallerFactor(long numToFactor) {

        if (negative) {

        for(long i = -2; i <= -500000; i--) {

            if((numToFactor % i) == 0) {
                return i;
            }
        }

        } else {

            for(long i = 2; i <= 500000; i++) {

                if((numToFactor % i) == 0) {
                    return i;
                }
            }
        }
        return 1;

    }



    public long biggerFactor(long numToFactor) {
        return numToFactor / smallerFactor(numToFactor);
    }

    public String toString() {

        if(!prime){
            return (numToFactor + " has factors of: " + factorSmall + " and " + factorBig);
        } else {
            return ("I'm sorry " + numToFactor + " looks like a prime number");
        }
    }
}
