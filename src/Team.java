import java.util.Collections;
import java.util.Comparator;

public class Team{

    private String name;
    private String country;
    private double score;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team() {
        this.name = name;
        this.country = country;
        this.score = score;
    }

    @Override
    public String toString(){
        return("\n"+this.getName()+ " "+this.getCountry()+" "+this.getScore());
    }

}
