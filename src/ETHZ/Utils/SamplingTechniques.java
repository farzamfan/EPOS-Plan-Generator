package ETHZ.Utils;

import ETHZ.Utils.Action;


public class SamplingTechniques {

    public static Float[] rank;

    public static Action[][] getTopNRankedSchedules(Action[][] finalList, int n){

        if(finalList!=null){
            Action[][] topNRankedSchedules;
            rank = new Float[n];
            if(finalList.length>=n){
                topNRankedSchedules = new Action[n][];
                for(int i = 0; i<n;i++){
                    topNRankedSchedules[i] = finalList[i];
                    rank[i] = (float) i/finalList.length;
                }
            }else{
                topNRankedSchedules = new Action[finalList.length][];
                for(int i = 0; i<finalList.length;i++){
                    topNRankedSchedules[i] = finalList[i];
                    rank[i] = (float) i/finalList.length;
                }
            }
            return topNRankedSchedules;
        }else{
            return null;
        }
    }

    public static Action[][] getWorstNRankedSchedules(Action[][] finalList, int n){

        if(finalList!=null){
            Action[][] NRankedSchedules;
            rank = new Float[n];
            if(finalList.length>=n){
                NRankedSchedules = new Action[n][];
                for(int i = 0; i<n;i++){
                    NRankedSchedules[i] = finalList[finalList.length - (i+1)];
                    rank[i] = (float) (finalList.length - (i+1))/finalList.length;
                }
            }else{
                NRankedSchedules = new Action[finalList.length][];
                for(int i = 0; i<finalList.length;i++){
                    NRankedSchedules[i] = finalList[finalList.length - (i+1)];
                    rank[i] = (float) (finalList.length - (i+1))/finalList.length;
                }
            }
            return NRankedSchedules;
        }else{
            return null;
        }
    }

    public static Action[][] getNRankedSchedulesWithMoreCloserToBestRating(Action[][] finalList, int n){
        if(finalList!=null){
            Action[][] NRankedSchedules;
            rank = new Float[n];
            if(finalList.length>=n){
                NRankedSchedules = new Action[n][];
                NRankedSchedules[0] = finalList[0];
                rank[0] = (float) 0;
                for(int i =1;i<n;i++){
                    NRankedSchedules[i] = finalList[(finalList.length/(n-i))-1];
                    rank[i] = (float) ((finalList.length/(n-i))-1)/finalList.length;
                }
            }else{
                NRankedSchedules = new Action[finalList.length][];
                for(int i = 0; i<finalList.length;i++){
                    NRankedSchedules[i] = finalList[i];
                    rank[i] = (float) i/finalList.length;
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
            rank = new Float[n];
            if(finalList.length>=n){
                NRankedSchedules = new Action[n][];
                NRankedSchedules[0] = finalList[finalList.length-1];
                rank[0] = (float) (finalList.length-1)/finalList.length;
                for(int i=0;i<n-1;i++){
                    NRankedSchedules[i+1] = finalList[(finalList.length-(finalList.length/(n-i)))];
                    rank[i+1] = (float) (finalList.length-(finalList.length/(n-i)))/finalList.length;
                }
            }else{
                NRankedSchedules = new Action[finalList.length][];
                for(int i = 0; i<finalList.length;i++){
                    NRankedSchedules[i] = finalList[i];
                    rank[i] = (float) i/finalList.length;
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
            rank = new Float[n];
            if(finalList.length>=n){
                topNRankedSchedules = new Action[n][];
                int step = finalList.length/n;
                int k=0;
                for(int i = 0; i<finalList.length;i+=step){
                    if (k<n) {
                        topNRankedSchedules[k] = finalList[i];
                        rank[k] = (float) i/finalList.length;
                        k++;
                    }
                }
            }else{
                topNRankedSchedules = new Action[finalList.length][];
                for(int i = 0; i<finalList.length;i++){
                    topNRankedSchedules[i] = finalList[i];
                    rank[i] = (float) i/finalList.length;
                }
            }
            return topNRankedSchedules;
        }else{
            return null;
        }
    }

}