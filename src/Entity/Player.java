package Entity;

/*
 *  Represents the PLAYERS table in database.
 */
public class Player {

    private String name;
    private Team team;
    private int id;

    public Player(){}

    public Player(String name, Team team, int id){
        this.team = team;
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
