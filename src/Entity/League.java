package Entity;


import java.util.Objects;

/*
 *  Represents the LEAGUE table in database.
 */
public class League {
    private int league_id;
    private String nationality;
    private int division;

    public League() {
    }

    public League(int league_id, String nationality, int division) {
        this.league_id = league_id;
        this.nationality = nationality;
        this.division = division;
    }

    public int getLeague_id() {
        return league_id;
    }

    public void setLeague_id(int league_id) {
        this.league_id = league_id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        League league = (League) o;
        return league_id == league.league_id && division == league.division && Objects.equals(nationality, league.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(league_id, nationality, division);
    }

    @Override
    public String toString() {
        return "League{" +
                "league_id=" + league_id +
                ", nationality='" + nationality + '\'' +
                ", division=" + division +
                '}';
    }
}
