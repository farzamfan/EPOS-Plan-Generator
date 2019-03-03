package ETHZ.Stats;

//import org.apache.commons.math3.distribution.PoissonDistribution;

public class Distributions {


    public static int getPoisson(double lambda) {
        double L = Math.exp(-lambda);
        double p = 1.0;
        int k = 0;

        do {
            k++;
            p *= Math.random();
        } while (p > L);
        return k - 1;
    }

    public static int getBinomial(int n, double p) {
        int x = 0;
        for (int i = 0; i < n; i++) {
            if (Math.random() < p)
                x++;
        }
        return x;
    }

//    public static int apachePoisson(int p) {
//        PoissonDistribution poissonDistribution = new PoissonDistribution(1400);
//        return poissonDistribution.sample();
//    }
}


