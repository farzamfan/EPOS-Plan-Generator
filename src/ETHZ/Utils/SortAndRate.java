package ETHZ.Utils;

import ETHZ.Utils.Action;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static ETHZ.Utils.SamplingTechniques.rank;

public class SortAndRate implements Comparator<Action[]> {

    public int compare(Action[] a, Action[] b) {
        double aRating = 0;
        double bRating = 0;
        for (int i = 0; i < a.length; i++) {
            aRating += a[i].getRating();
        }
        for (int i = 0; i < b.length; i++) {
            bRating += b[i].getRating();
        }
        bRating /= b.length;
        aRating /= a.length;
        return Double.compare(bRating, aRating);
    }

    public static long[] getCombination(long i, Action[] lists, int index, long[] indeces) {
        indeces[index] = (i - 1) % lists[index].versions.length;
        long passOn = (((i - 1) - indeces[index]) / lists[index].versions.length) + 1;
        if (index + 1 < lists.length) {
            indeces = getCombination(passOn, lists, index + 1, indeces);
        }
        return indeces;
    }

    public static Action[][] sortSchedulesByRating(Action[][] schedulesList) {
        Action[][] finalList;
        List<Action[]> ratedListToPass = Arrays.asList(schedulesList);
        Collections.sort(ratedListToPass, new SortAndRate());
        Collections.reverse(ratedListToPass);
        finalList = ratedListToPass.toArray(new Action[ratedListToPass.size()][]);
        return finalList;
    }

    public static String singlePlan(int c, String[][][] data, int devIndex, int j) {
        StringBuilder planBuilder = new StringBuilder(2880);
        String dataToReturn = String.valueOf(rank[j]);
        planBuilder.append(dataToReturn);
        for (int i = 0; i < data[c][devIndex].length; i++) {
            if (!data[c][devIndex][i].equals("0")) {
                planBuilder.append("," + data[c][devIndex][i]);
            } else {
                planBuilder.append("," + data[c][devIndex][i]);
            }
        }
        dataToReturn = planBuilder.toString();
        return dataToReturn;
    }
}
