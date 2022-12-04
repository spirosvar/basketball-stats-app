package repository;

import entity.Team;

import java.sql.*;
import java.util.logging.Logger;

import static contants.SqlStatements.*;

public class TeamRepository {

    private final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private Connection connection;
    private LeagueRepository leagueRepository = new LeagueRepository();


    /**
     * deletes a team from the PLAYERS table
     *
     * @param name,       Player name
     * @param connection, Connection instance
     * @return TRUE if the team record is deleted successfully, else false.
     */
    public boolean deleteTeamByName(String name, Connection connection) {
        log.info("deleteTeamByName: delete team with name " + name);
        try {
            startConn();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TEAM_BY_NAME);
            preparedStatement.setString(1, name);
            preparedStatement.executeQuery();
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            log.severe("Exception occured: " + e.getMessage());
            return false;
        }
        return true;
    }

    public Team findTeamByPlayerName(String name) throws SQLException {
        log.info("findTeamByPlayerName: find team for player: " + name);
        startConn();
        PreparedStatement preparedStatement = connection.prepareStatement(FETCH_TEAM_BY_PLAYER_NAME);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        Team team = new Team();
        while (resultSet.next()) {
            team.setId(resultSet.getInt(1));
            team.setName(resultSet.getString(2));
            team.setTown(resultSet.getString(3));
            team.setLeague(leagueRepository.getById(resultSet.getInt(4)));
            team.setLeagueRank(resultSet.getInt(5));
        }
        connection.close();
        return team;
    }

    public Team findTeamById(int id) throws SQLException {
        log.info("findTeamById: find team with id: " + id);
        PreparedStatement preparedStatement = connection.prepareStatement(FETCH_TEAM_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Team team = new Team();
        while (resultSet.next()) {
            team.setId(id);
            team.setName(resultSet.getString(2));
            team.setTown(resultSet.getString(3));
            team.setLeague(leagueRepository.getById(resultSet.getInt(4)));
            team.setLeagueRank(resultSet.getInt(5));
        }
        connection.close();
        return team;
    }

    /**
     * Returns a TEAMS record from the DB based on the provided name
     *
     * @param name TEAM name
     * @return instance of {@code Team}
     * @throws SQLException
     */
    public Team findTeamByName(String name) throws SQLException {
        log.info("findTeamByName: find team with id: " + name);
        PreparedStatement preparedStatement = connection.prepareStatement(FETCH_TEAM_BY_NAME);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        Team team = new Team();
        while (resultSet.next()) {
            team.setId(resultSet.getInt(1));
            team.setName(name);
            team.setTown(resultSet.getString(3));
            team.setLeague(leagueRepository.getById(resultSet.getInt(4)));
            team.setLeagueRank(resultSet.getInt(5));
        }
        return team;
    }

    private void startConn() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgres://dblabs.iee.ihu.gr:5432/it17512", "it175120", "Peri658072@");
    }
}
