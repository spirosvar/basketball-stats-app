package Entity;


/*
 *  Represents the TEAMS table in database.
 */
public class Team {

    private int id;
    private String league;
    private String nationality;
    private int wins;
    private String losses;

    public int getTeam_id() {
        return id;
    }

    public void setTeam_id(int id) {
        this.id = id;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }
}
