package ETHZ.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlanWriter {

    public void createPlanFormat(String algFiles) throws IOException {

        int k=0;

        String [] files;
        String pathname = algFiles+"/allAggregates/";
        File path = new File(pathname);
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

            String writerPath1 = algFiles + "/planfiles/";
            File plans = new File(algFiles + "/planfiles/");
            plans.mkdir();
            PrintWriter writer1 = new PrintWriter(writerPath1 + "/agent_" +k+ ".plans", "UTF-8");

            for (String L : lines) {
                StringBuilder L2 = new StringBuilder(L.substring(L.indexOf(";")+1).replaceAll(",",".").replaceAll(";", ",").replaceFirst(",",":"));
                writer1.println(L2);
            }
            k++;
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

