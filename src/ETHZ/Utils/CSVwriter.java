package ETHZ.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVwriter {
    public void writeCSV(String[] folders, int j,String[] devices, String mainFolder, String[] algCase) {
            for (int i = 0; i < devices.length; i++) {
                //System.out.print(devices[i]+"\n");
                String toFile = "";
                String applianceName = "";
                switch (i) {
                    case 1:
                        applianceName = mainFolder + algCase[0] + algCase[1] + algCase[2] + "/detailedCSV/" + folders[j] + "/" + "Hob";
                        break;
                    case 2:
                        applianceName = mainFolder + algCase[0] + algCase[1] + algCase[2] + "/detailedCSV/" + folders[j] + "/" + "Oven";
                        break;
                    case 3:
                        applianceName = mainFolder + algCase[0] + algCase[1] + algCase[2] + "/detailedCSV/" + folders[j] + "/" + "TumbleDryer";
                        break;
                    case 4:
                        applianceName = mainFolder + algCase[0] + algCase[1] + algCase[2] + "/detailedCSV/" + folders[j] + "/" + "WashingMachine";
                        break;
                    case 5:
                        applianceName = mainFolder + algCase[0] + algCase[1] + algCase[2] + "/detailedCSV/" + folders[j] + "/" + "Computer";
                        break;
                    case 6:
                        applianceName = mainFolder + algCase[0] + algCase[1] + algCase[2] + "/detailedCSV/" + folders[j] + "/" + "Kettle";
                        break;
                    case 7:
                        applianceName = mainFolder + algCase[0] + algCase[1] + algCase[2] + "/detailedCSV/" + folders[j] + "/" + "DishWasher";
                        break;
                    case 8:
                        applianceName = mainFolder + algCase[0] + algCase[1] + algCase[2] + "/detailedCSV/" + folders[j] + "/" + "Shower";
                        break;
                    default:
                        applianceName = mainFolder + algCase[0] + algCase[1] + algCase[2] + "/detailedCSV/" + folders[j] + "/" + "Shower";
                        break;
                }
                toFile = devices[i];

                File fileName = new File(applianceName + "-schedules.csv");
                fileName.getParentFile().getParentFile().mkdirs();
                fileName.getParentFile().mkdir();
                FileWriter fileWriter = null;

                try {
                    fileWriter = new FileWriter(fileName);
                    fileWriter.append(toFile);
                } catch (Exception e) {

                } finally {
                    try {
                        fileWriter.flush();
                        fileWriter.close();
                    } catch (IOException e) {
                        System.out.println("Error while flushing/closing fileWriter !!!");
                        e.printStackTrace();
                    }
                }
            }
    }

}
