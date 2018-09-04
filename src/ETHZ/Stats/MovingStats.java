package ETHZ.Stats;

import java.util.Random;

public class MovingStats {

    double[] series;
    double[] rollingAverage;

    int windowBegin;
    int windowEnd;
    int windowBeginStride;
    int windowEndStride;
    int windowSize;

    public MovingStats(double[] series){
        this.series = series;
    }


    public double[] randomData(int size){

        int w=0;
        double[] dataset = new double[size];

        Random r = new Random();
        for (int q = 0;q<size;q++){
            dataset[w] = r.nextGaussian();
            w++;
        }

        return dataset;
    }

    public double[] movingAverage(int start, int size, String mode){

        rollingAverage = new double[series.length];
        windowBegin = start;
        windowEnd = windowBegin + size;
        double sum=0;
        int j=0;

        while (windowEnd < series.length)
        {
            for(int i=0;i<size;i++)
            {
                sum += series[windowBegin];
                windowBegin++;
            }

            windowEnd = windowBegin;
            System.out.println((double) sum / size);
            rollingAverage[j] = (double) sum / size;
            j++;
        }

        return null;
    }
}