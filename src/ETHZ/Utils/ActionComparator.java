package ETHZ.Utils;

import java.util.Comparator;

public class ActionComparator implements Comparator<Action> {
    public int compare(Action a, Action b){
        return Integer.compare(a.getWindowStart(),b.getWindowStart());
    }
}
