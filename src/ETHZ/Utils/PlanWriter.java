package ETHZ.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlanWriter {

    public void createPlanFormat(String algFiles) throws IOException {

        int k=0;
        int j=0;
        String [] files;
        String pathname = algFiles+"/allAggregates/";
        System.out.println(pathname);
        File path = new File(pathname);
        System.out.println(pathname);
        files = path.list();
        for (String f:files) {

            if (f.equals(new String(".DS_Store"))){
                continue;
            }

            String csvFile = pathname+f;
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            List<String> lines = new ArrayList<>();
            reader.readLine();
            String line = null;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            String writerPath1 = algFiles + "/planfiles/day"+j;
            File plans = new File(algFiles + "/planfiles/day"+j);
            plans.mkdirs();
            PrintWriter writer1 = new PrintWriter(writerPath1 + "/agent_" +k+ ".plans", "UTF-8");

            for (String L : lines) {
                StringBuilder L2 = new StringBuilder(L.substring(L.indexOf(";")+1).replaceAll(",",".").replaceAll(";", ",").replaceFirst(",",":"));
                writer1.println(L2);
            }
            j++;
            if (j==4){
                k++;
                j=0;
            }
            writer1.close();
        }

    }

    public void createAggregates(String detailedCSVs) throws Exception
    {
        String command = "Rscript /Users/farzamf/Projects/ETHZ/I-EPOS-PlanGenerator/aggregateCSV.R" + " " + detailedCSVs;
        System.out.println(command);
        Process p = Runtime.getRuntime().exec(command);
        int code = p.waitFor();

        switch (code) {
            case 0:
                System.out.println("writing aggregates done!");
                break;
            case 1:
                System.out.println("error writing aggregates");

        }
    }
}

