package Entity;

import java.util.Objects;

/*
 *  Represents the PLAYERS table in database.
 */
public class Player {

    private int id;

    private String fullname;
    private Team team;

    private PlayerStats playerStats;

    private String nationality;

    private int age;

    private String position;

    public Player() {
    }

    public Player(int id, String fullname, Team team, PlayerStats playerStats, String nationality, int age, String position) {
        this.id = id;
        this.fullname = fullname;
        this.team = team;
        this.playerStats = playerStats;
        this.nationality = nationality;
        this.age = age;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public PlayerStats getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(PlayerStats playerStats) {
        this.playerStats = playerStats;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && age == player.age && Objects.equals(fullname, player.fullname) && Objects.equals(team, player.team) && Objects.equals(playerStats, player.playerStats) && Objects.equals(nationality, player.nationality) && Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullname, team, playerStats, nationality, age, position);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", team=" + team +
                ", playerStats=" + playerStats +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                '}';
    }
}
