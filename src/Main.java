import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static boolean validInGroup(Team team, Group group){

        List<Team> teamsInGroup = group.getGroupTeams();
        List<String> countriesInGroup = new ArrayList<>();

        for (Team aTeamsInGroup : teamsInGroup) {
            countriesInGroup.add(aTeamsInGroup.getCountry());
        }

        for (int i = 0; i < countriesInGroup.size(); i++) {
            if(countriesInGroup.contains(team.getCountry()))
                return false;
        }

        if (countriesInGroup.contains("RUS") || countriesInGroup.contains("UKR"))
        {
            if (team.getCountry().equals("RUS") || team.getCountry().equals("UKR"))
            {
                return false;
            }
        }

        return true;
    }

    private static List<Group> changeLastTeam(Team team, List<Group> groups){
        String country = team.getCountry();
        boolean eligible = false;
        boolean checkDone = false;
        Group selectedGroup = null;

        //selecting the team without the nationality
        for (int i = 0; !checkDone; i++) {
            List<Team> teams = groups.get(i).getGroupTeams();

            for (Team tm : teams)
            {
                eligible = tm.getCountry().equals(country);
            }

            if (!eligible)
            {
                checkDone = true;
                selectedGroup = groups.get(i);
            }

        }

        //replace the team with another one in the selected group
        Team cTeam = selectedGroup.getGroupTeams().get(3); //good team

        List<Team> teams = selectedGroup.getGroupTeams();
        teams.set(3, team);

        Group groupL = groups.get(7);
        List<Team> teams2 = groupL.getGroupTeams();
        teams2.add(cTeam);

        return groups;
    }

    private static List<List<Team>> assignPots(List<Team> teams){

        List<List<Team>> listOfPots = new ArrayList<>();

        int n;
        List<Team> Pot1 = new ArrayList<Team>();
        for (n = 0; Pot1.size() != 8; n++){
            Pot1.add(teams.get(n));
        }
        listOfPots.add(Pot1);

        List<Team> Pot2 = new ArrayList<Team>();
        for (n = 8; Pot2.size() != 8; n++){
            Pot2.add(teams.get(n));
        }
        listOfPots.add(Pot2);

        List<Team> Pot3 = new ArrayList<Team>();
        for (n = 16; Pot3.size() != 8; n++){
            Pot3.add(teams.get(n));
        }
        listOfPots.add(Pot3);

        List<Team> Pot4 = new ArrayList<Team>();
        for (n = 24; Pot4.size() != 8; n++){
            Pot4.add(teams.get(n));
        }
        listOfPots.add(Pot4);

        return listOfPots;
    }

    private static Team randomTeamFromPot(List<Team> pot){
        Team tm = pot.get(new Random().nextInt(pot.size()));
        return tm;
    }

    private static List<Group> assignGroupsFromPots(List<List<Team>> pots){

        List<Team> groupTeams = new ArrayList<Team>();
        List<Group> groups = new ArrayList<Group>();

        Group groupA = new Group("A", groupTeams);
        groups.add(groupA);
        Group groupB = new Group("B", groupTeams);
        groups.add(groupB);
        Group groupC = new Group("C", groupTeams);
        groups.add(groupC);
        Group groupD = new Group("D", groupTeams);
        groups.add(groupD);
        Group groupE = new Group("E", groupTeams);
        groups.add(groupE);
        Group groupF = new Group("F", groupTeams);
        groups.add(groupF);
        Group groupG = new Group("G", groupTeams);
        groups.add(groupG);
        Group groupH = new Group("H", groupTeams);
        groups.add(groupH);

        //extract teams from the pots (random)
        for (int i = 0; i < 8; i++) {
            groupTeams = new ArrayList<Team>();
            for (int j = 0; j < 4; j++) {
                //random from pot
                Team tm = randomTeamFromPot(pots.get(j));
                if (validInGroup(tm, groups.get(i))) {
                    groupTeams.add(tm);
                    groups.get(i).setGroupTeams(groupTeams);
                    pots.get(j).remove(tm);
                }
                else{
                    j--;
                }
            }
        }
        return groups;
    }

    private static List<Group> assignGroups(List<Team> teams){

        int i;
        List<Team> groupTeams = new ArrayList<Team>();
        List<Group> groups = new ArrayList<Group>();

        Group groupA = new Group("A", groupTeams);
        groups.add(groupA);

        for (i = 0; 4 > groupTeams.size(); i++){
            if(validInGroup(teams.get(i),groupA)) {
                groupTeams.add(teams.get(i));
                groupA.setGroupTeams(groupTeams);
                teams.remove(i);
                i = (32 / 4) - 1;
            }
            else {
                i = i - 2;
            }
        }

        groupTeams = new ArrayList<Team>();
        Group groupB = new Group("B", groupTeams);
        groups.add(groupB);

        for (i = 0; 4 > groupTeams.size(); i++){
            if(validInGroup(teams.get(i),groupB)) {
                groupTeams.add(teams.get(i));
                groupB.setGroupTeams(groupTeams);
                teams.remove(i);
                i = (28 / 4) - 1;
            }
            else {
                i = i - 2;
            }
        }

        groupTeams = new ArrayList<Team>();
        Group groupC = new Group("C", groupTeams);
        groups.add(groupC);

        for (i = 0; 4 > groupTeams.size(); i++){
            if(validInGroup(teams.get(i),groupC)) {
                groupTeams.add(teams.get(i));
                groupC.setGroupTeams(groupTeams);
                teams.remove(i);
                i = (24 / 4) - 1;
            }
            else {
                i = i - 2;
            }
        }

        groupTeams = new ArrayList<Team>();
        Group groupD = new Group("D", groupTeams);
        groups.add(groupD);

        for (i = 0; 4 > groupTeams.size(); i++){
            if(validInGroup(teams.get(i),groupD)) {
                groupTeams.add(teams.get(i));
                groupD.setGroupTeams(groupTeams);
                teams.remove(i);
                i = (20 / 4) - 1;
            }
            else {
                i = i - 2;
            }
        }

        groupTeams = new ArrayList<Team>();
        Group groupE = new Group("E", groupTeams);
        groups.add(groupE);

        for (i = 0; 4 > groupTeams.size(); i++){
            if(validInGroup(teams.get(i),groupE)) {
                groupTeams.add(teams.get(i));
                groupE.setGroupTeams(groupTeams);
                teams.remove(i);
                i = (16 / 4) - 1;
            }
            else {
                i = i - 2;
            }
        }

        groupTeams = new ArrayList<Team>();
        Group groupF = new Group("F", groupTeams);
        groups.add(groupF);

        for (i = 0; 4 > groupTeams.size(); i++){
            if(validInGroup(teams.get(i),groupF)) {
                groupTeams.add(teams.get(i));
                groupF.setGroupTeams(groupTeams);
                teams.remove(i);
                i = (12 / 4) - 1;
            }
            else {
                i = i - 2;
            }
        }

        groupTeams = new ArrayList<Team>();
        Group groupG = new Group("G", groupTeams);
        groups.add(groupG);

        for (i = 0; 4 > groupTeams.size(); i++){
            if(validInGroup(teams.get(i),groupG)) {
                groupTeams.add(teams.get(i));
                groupG.setGroupTeams(groupTeams);
                teams.remove(i);
                i = (8 / 4) - 1;
            }
            else {
                i = i - 2;
            }
        }

        groupTeams = new ArrayList<Team>();
        Group groupH = new Group("H", groupTeams);
        groups.add(groupH);
        int check = 0;

        for (i = 0; 4 > groupTeams.size(); i = 0){
            if(validInGroup(teams.get(i),groupH)) {
                groupTeams.add(teams.get(i));
                groupH.setGroupTeams(groupTeams);
                teams.remove(i);
            }
            else if(teams.size() == 1 || check > 0){
                check = 0;
                groups = changeLastTeam(teams.get(i), groups);
                teams.remove(i);
            }
            else{
                check++;
            }
        }

        return groups;
    }

    public static void main(String[] args) {

        Text_DT text_dt = new Text_DT();

        List<Team> teams = text_dt.loadFromFile();
        List<List<Team>> pots = assignPots(teams);
        List<Group> groups = assignGroupsFromPots(pots);

        for (int i = 0; i < groups.size(); i++){
            System.out.println("\n"+groups.get(i));
        }

    }
}
