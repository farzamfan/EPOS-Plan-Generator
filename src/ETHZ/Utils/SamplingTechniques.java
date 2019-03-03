package ETHZ.Utils;

import ETHZ.Utils.Action;


public class SamplingTechniques {

    public static Integer[] rank;

    public static Action[][] getTopNRankedSchedules(Action[][] finalList, int n){

        if(finalList!=null){
            Action[][] topNRankedSchedules;
            rank = new Integer[n];
            if(finalList.length>=n){
                topNRankedSchedules = new Action[n][];
                for(int i = 0; i<n;i++){
                    topNRankedSchedules[i] = finalList[i];
                    rank[i] = i;
                }
            }else{
                topNRankedSchedules = new Action[finalList.length][];
                for(int i = 0; i<finalList.length;i++){
                    topNRankedSchedules[i] = finalList[i];
                    rank[i] = i;
                }
            }
            return topNRankedSchedules;
        }else{
            return null;
        }
    }

    public static Action[][] getNRankedSchedulesWithMoreCloserToBestRating(Action[][] finalList, int n){
        if(finalList!=null){
            Action[][] NRankedSchedules;
            rank = new Integer[n];
            if(finalList.length>=n){
                NRankedSchedules = new Action[n][];
                NRankedSchedules[0] = finalList[0];
                for(int i =1;i<n;i++){
                    NRankedSchedules[i] = finalList[(finalList.length/(n-i))-1];
                    rank[i] = (finalList.length/(n-i))-1;
                }
            }else{
                NRankedSchedules = new Action[finalList.length][];
                for(int i = 0; i<finalList.length;i++){
                    NRankedSchedules[i] = finalList[i];
                    rank[i] = i;
                }
            }
            return NRankedSchedules;
        }else{
            return null;
        }
    }

    public static Action[][] getNRankedSchedulesWithMoreCloserToWorstRating(Action[][] finalList, int n){
        if(finalList!=null){
            Action[][] NRankedSchedules;
            rank = new Integer[n];
            if(finalList.length>=n){
                NRankedSchedules = new Action[n][];
                NRankedSchedules[0] = finalList[0];
                for(int i =1;i<n;i++){
                    NRankedSchedules[i] = finalList[(finalList.length-(finalList.length/(n-i)))];
                    rank[i] = (finalList.length-(finalList.length/(n-i)));
                }
            }else{
                NRankedSchedules = new Action[finalList.length][];
                for(int i = 0; i<finalList.length;i++){
                    NRankedSchedules[i] = finalList[i];
                    rank[i] = i;
                }
            }
            return NRankedSchedules;
        }else{
            return null;
        }
    }

    public static Action[][] getNRankedEvenlySpreadSchedules(Action[][] finalList, int n){
        if(finalList!=null){
            Action[][] topNRankedSchedules;
            rank = new Integer[n];
            if(finalList.length>=n){
                topNRankedSchedules = new Action[n][];
                int step = finalList.length/n;
                int k=0;
                for(int i = 0; i<finalList.length;i+=step){
                    if (k<n) {
                        topNRankedSchedules[k] = finalList[i];
                        rank[k] = i;
                        k++;
                    }
                }
            }else{
                topNRankedSchedules = new Action[finalList.length][];
                for(int i = 0; i<finalList.length;i++){
                    topNRankedSchedules[i] = finalList[i];
                    rank[i] = i;
                }
            }
            return topNRankedSchedules;
        }else{
            return null;
        }
    }

}