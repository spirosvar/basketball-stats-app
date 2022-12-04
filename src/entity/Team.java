package entity;


import java.util.Objects;

/*
 *  Represents the TEAMS table in database.
 */
public class Team {

    private int id;

    private String name;

    private String town;

    private League league;

    private int leagueRank;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public int getLeagueRank() {
        return leagueRank;
    }

    public void setLeagueRank(int leagueRank) {
        this.leagueRank = leagueRank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id && leagueRank == team.leagueRank && Objects.equals(name, team.name) && Objects.equals(town, team.town) && Objects.equals(league, team.league);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, town, league, leagueRank);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", town='" + town + '\'' +
                ", league=" + league.getName() +
                ", leagueRank=" + leagueRank +
                '}';
    }
}
