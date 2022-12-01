package Entity;

import java.util.Objects;

/*
 *  Represents the PLAYER-STATS table in database.
 */
public class PlayerStats {

    private int id;

    private int rebounds;

    private int points;

    private int assists;

    private int turnovers;

    private int games_played;

    private int steals;

    private int blocks;

    private int madeShots;

    private int totalShots;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(int turnovers) {
        this.turnovers = turnovers;
    }

    public int getGames_played() {
        return games_played;
    }

    public void setGames_played(int games_played) {
        this.games_played = games_played;
    }

    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public int getMadeShots() {
        return madeShots;
    }

    public void setMadeShots(int madeShots) {
        this.madeShots = madeShots;
    }

    public int getTotalShots() {
        return totalShots;
    }

    public void setTotalShots(int totalShots) {
        this.totalShots = totalShots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerStats that = (PlayerStats) o;
        return id == that.id && rebounds == that.rebounds && points == that.points && assists == that.assists && turnovers == that.turnovers && games_played == that.games_played && steals == that.steals && blocks == that.blocks && madeShots == that.madeShots && totalShots == that.totalShots;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rebounds, points, assists, turnovers, games_played, steals, blocks, madeShots, totalShots);
    }

    @Override
    public String toString() {
        return "PlayerStats{" +
                "id=" + id +
                ", rebounds=" + rebounds +
                ", points=" + points +
                ", assists=" + assists +
                ", turnovers=" + turnovers +
                ", games_played=" + games_played +
                ", steals=" + steals +
                ", blocks=" + blocks +
                ", madeShots=" + madeShots +
                ", totalShots=" + totalShots +
                '}';
    }
}
