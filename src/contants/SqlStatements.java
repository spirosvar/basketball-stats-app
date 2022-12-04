package contants;

public class SqlStatements {

    /*
     *   Player SQL Statements
     */
    public static final String UPDATE_PLAYER = "UPDATE players SET fullname=?, team_id=?, stats_id=?, nationality=?, age=?, position=? WHERE player_id = ?";
    public static final String INSERT_PLAYER = "INSERT INTO player (player_id, fullname, team_id, stats_id, nationality, age, position) VALUES(?, ?, ?, ?, ?, ?, ?)";
    public static final String FETCH_PLAYER_BY_NAME = "SELECT * from players WHERE fullname = ?";
    public static final String DELETE_PLAYER_BY_NAME = "DELETE FROM players WHERE fullname = ?";

    /*
     *   Team SQL Statements
     */
    public static final String UPDATE_TEAM = "UPDATE teams SET  WHERE name = ?";
    public static final String INSERT_TEAM = "INSERT INTO teams (team_id, name, town, league_id, league_rank) VALUES (?, ?, ?, ?, ?)";
    public static final String FETCH_TEAM_BY_NAME = "SELECT * FROM teams WHERE name = ?";
    public static final String DELETE_TEAM_BY_NAME = "DELETE FROM teams WHERE name = ?";

    public static final String FETCH_TEAM_BY_PLAYER_NAME = "SELECT * from teams WHERE team_id = (SELECT p.team_id FROM players p WHERE p.fullname = ?";
    public static final String FETCH_TEAM_BY_ID = "SELECT * from teams WHERE team_id = ?";
    /*
     *   League SQL Statements
     */
    public static final String UPDATE_LEAGUE = "UPDATE leagues SET nationality = ?, division = ?, name = ?  WHERE name = ?";
    public static final String INSERT_LEAGUE = "INSERT INTO leagues (league_id, nationality, division, name) VALUES (?, ?, ?, ?)";
    public static final String FETCH_LEAGUE_BY_NAME = "SELECT * FROM leagues WHERE name = ?";
    public static final String DELETE_LEAGUE_BY_NAME = "DELETE FROM leagues WHERE name = ?";
    public static final String FETCH_LEAGUE_BY_ID = "SELECT * FROM leagues WHERE league_id = ?";

    /*
     *   Player-stats SQL Statements
     */
    public static final String UPDATE_PLAYER_STATS = "UPDATE player_stats SET rebounds = ?, assists = ?, points = ?, turnovers = ?, steals = ?, blocks = ?, made_shots = ?, total_shots = ?," +
            " games_playes = ? WHERE name = ?";
    public static final String INSERT_PLAYER_STATS = "INSERT INTO player_stats (stats_id, rebounds, assists, points, turnovers, steals, blocks, made_shots, total_shots, games_playes) " +
            "VALUES (? , ? , ? , ? , ?, ?, ?, ?, ?, ?)";
    public static final String FETCH_PLAYER_STATS_BY_NAME = "SELECT * FROM player_stats WHERE stats_id = (SELECT p.player_id FROM players p WHERE p.name = ?";
    public static final String DELETE_PLAYER_STATS_BY_NAME = "DELETE FROM player_stats WHERE stats_id = (SELECT p.player_id FROM players p WHERE p.name = ?";

    /*
     *   Coach SQL Statements
     */
    public static final String UPDATE_COACH = "UPDATE coaches SET fullname = ?, nationality = ?, team_id = ?, league_id = ? WHERE coach_id = ?";
    public static final String INSERT_COACH = "INSERT INTO coaches (fullname , nationality , team_id, league_id, coach_id) VALUES (? , ?, ?, ?, ?)";
    public static final String FETCH_COACH_BY_NAME = "SELECT * FROM coaches WHERE fullname = ?";
    public static final String DELETE_COACH_BY_NAME = "DELETE FROM coaches WHERE fullname = ?";

    /*
     * Top10 statements
     */
    public static final String TOP_10_SCORERS = "SELECT * FROM players WHERE stats_id IN (SELECT stats_id FROM player_stats ORDER BY points DESC LIMIT 10";
    public static final String TOP_10_ASSISTS = "SELECT * FROM players WHERE stats_id IN (SELECT stats_id FROM player_stats ORDER BY assists DESC LIMIT 10";
    public static final String TOP_10_REBOUNDS = "SELECT * FROM players WHERE stats_id IN (SELECT stats_id FROM player_stats ORDER BY rebounds DESC LIMIT 10";
}
