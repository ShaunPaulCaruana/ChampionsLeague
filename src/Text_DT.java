import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Text_DT {

    List<Team> loadFromFile() {

        String filePath = "/Users/shaun/Desktop/CL_Project_Items/CL_Project_Dataset.csv";
        BufferedReader br = null;
        String line = "";
        String splitBy = ",";
        //Team teamInsert = new Team();
        List<Team> teamList = new ArrayList<Team>();

        try {

            br = new BufferedReader((new FileReader(filePath)));

            while ((line = br.readLine()) != null) {
               String[] teamDetails = line.split(splitBy);
                //System.out.println(teamDetails[0] + " " + teamDetails[1] + " " + teamDetails[2] + "\n"); //preview file
                Team teamInsert = new Team();
                teamInsert.setName(teamDetails[0]);
                teamInsert.setCountry(teamDetails[1]);
                teamInsert.setScore(Double.parseDouble(teamDetails[2]));
                teamList.add(teamInsert);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        Collections.sort(teamList, new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                return Double.compare(o2.getScore(),o1.getScore());
            }
        });

        return teamList;
    }
}
