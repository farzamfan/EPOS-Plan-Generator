package ETHZ.Scheduler;

import ETHZ.Utils.Action;
import ETHZ.Utils.CSVwriter;
import ETHZ.Utils.PlanWriter;

import java.util.ArrayList;
import java.util.List;

public class Plan {

    public static void main(String[] args) throws Exception {
        Plan plan = new Plan();
        plan.PlanFromRun();
//        plan.planFromFiles();
    }

    public void planFromFiles() throws Exception {
        List<String[]> dev = new ArrayList<>();

        String raw = "/Users/farzamf/Projects/ETHZ/P-EPOS/datasets/v7";
        String main = "/Users/farzamf/Projects/ETHZ/P-EPOS/datasets/v8/";
        String[] alg = {"EvenDist-", "5", "/"};

        PlanGenerator planGenerator = new PlanGenerator(raw,main,alg);
        List allPlans =  planGenerator.readFromFile();
        for (int i=0;i<allPlans.size();i++) { dev.add(planGenerator.createPlan((List) allPlans.get(i))); }

//        CSVwriter csVwriter = new CSVwriter();
//        int t=0;
//        for (String[] devices : dev) {
//            csVwriter.writeCSV(PlanGenerator.folders,t,devices,main,alg);
//            t++;
//        }
//
//        PlanWriter planWriter = new PlanWriter();
//        planWriter.createAggregates(main + alg[0]+alg[1]+alg[2]);
//        planWriter.createPlanFormat(main + alg[0]+alg[1]+alg[2]);

    }

    public void PlanFromRun() throws Exception {
        String raw = "/Users/farzamf/Projects/ETHZ/P-EPOS/datasets/v7";
        String main = "/Users/farzamf/Projects/ETHZ/P-EPOS/datasets/v8/";
        String[] alg = {"EvenDist-", "5", "/"};

        PlanGenerator planGenerator = new PlanGenerator(raw,main,alg);
        Action[] actions = new Action[1];

        //this is the most important part that needs to be connected to the app
        Action action = planGenerator.createAction("Kettle","12:00","14:00","00:30","13:00",false);
        actions[0] = action;

        Schedule schedule = new Schedule(actions);
        schedule.makeScheduleList();
        schedule.compileCombinations();
        schedule.sortSchedulesByRating();

        List<String[]> ret = planGenerator.ActionToString(schedule.getFinalDetails());
        List<String[]> dev = new ArrayList<>();
        dev.add(planGenerator.createPlan(ret));

        CSVwriter csVwriter = new CSVwriter();
        int t=0;
        for (String[] devices : dev) {
            csVwriter.writeCSV(new String[]{"USER"},t,devices,main,alg);
            t++;
        }

        PlanWriter planWriter = new PlanWriter();
        planWriter.createAggregates(main + alg[0]+alg[1]+alg[2]);
        planWriter.createPlanFormat(main + alg[0]+alg[1]+alg[2]);


    }

}
