package Entity;

import java.util.Objects;

public class Coach {
    private int coach_id;
    private String fullname;
    private String nationality;
    private Team team;
    private League league;

    public int getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Coach() {
    }

    public Coach(int coach_id, String fullname, String nationality, Team team, League league) {
        this.coach_id = coach_id;
        this.fullname = fullname;
        this.nationality = nationality;
        this.team = team;
        this.league = league;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return coach_id == coach.coach_id && Objects.equals(fullname, coach.fullname) && Objects.equals(nationality, coach.nationality) && Objects.equals(team, coach.team) && Objects.equals(league, coach.league);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coach_id, fullname, nationality, team, league);
    }

    @Override
    public String toString() {
        return "Coach{" +
                "coach_id=" + coach_id +
                ", fullname='" + fullname + '\'' +
                ", nationality='" + nationality + '\'' +
                ", team=" + team +
                ", league=" + league +
                '}';
    }
}
