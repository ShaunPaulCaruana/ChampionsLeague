import java.util.List;

public class Group {

    private String GroupName;
    private List<Team> GroupTeams;

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public List<Team> getGroupTeams() {
        return GroupTeams;
    }

    public void setGroupTeams(List<Team> groupTeams) {
        GroupTeams = groupTeams;
    }

    public Group(String groupName, List<Team> groupTeams) {
        GroupName = groupName;
        GroupTeams = groupTeams;
    }

    @Override
    public String toString() {
        return "Group{" +
                "GroupName='" + GroupName + '\'' +
                ", GroupTeams=" + GroupTeams +
                '}';
    }
}
