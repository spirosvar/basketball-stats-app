package repository;

import entity.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static contants.SqlStatements.*;

/*
 * This calls stores all db statements for the player entity
 */
public class PlayerRepository {

    private final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private Connection connection;

    private TeamRepository teamRepository = new TeamRepository();

    private PlayerStatRepository playerStatRepository = new PlayerStatRepository();

    private Player player = new Player();

    /**
     * inserts a player into the PLAYERS table
     *
     * @param playerEntity, Player instance
     * @return TRUE if the player record is persisted successfully, else false.
     */
    public boolean insertPlayer(Player playerEntity) {
        log.info("insertPlayer: persist new record into DB: " + playerEntity);
        try {
            startConn();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PLAYER);
            preparedStatement.setInt(1, playerEntity.getId());
            preparedStatement.setString(2, playerEntity.getFullname());
            preparedStatement.setInt(3, teamRepository.findTeamByName(playerEntity.getTeam().getName()).getId());
            preparedStatement.setInt(4, playerStatRepository.getStatsByPlayerName(playerEntity.getFullname()).getId());
            preparedStatement.setString(5, playerEntity.getNationality());
            preparedStatement.setString(6, playerEntity.getPosition());
            preparedStatement.executeQuery();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            log.severe("insertPlayer: Exception occurred: " + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * updates a player into the PLAYERS table
     *
     * @param playerEntity, Player instance
     * @return TRUE if the player record is persisted successfully, else false.
     */
    public boolean updatePlayer(Player playerEntity) {

        try {
            startConn();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PLAYER);
            preparedStatement.setString(1, playerEntity.getFullname());
            preparedStatement.setInt(2, teamRepository.findTeamByName(playerEntity.getTeam().getName()).getId());
            preparedStatement.setInt(3, playerStatRepository.getStatsByPlayerName(playerEntity.getFullname()).getId());
            preparedStatement.setString(4, playerEntity.getNationality());
            preparedStatement.setInt(5, playerEntity.getAge());
            preparedStatement.setString(6, playerEntity.getPosition());
            preparedStatement.setInt(7, playerEntity.getId());
            preparedStatement.executeQuery();
            connection.commit();
            connection.close();

        } catch (SQLException e) {
            log.severe("updatePlayer: Exception occurred: " + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * deletes a player from the PLAYERS table
     *
     * @param name,       Player name
     * @return TRUE if the player record is deleted successfully, else false.
     */
    public boolean deletePlayerByName(String name, Connection connection) {
        log.info("deletePlayerByName: delete player with name: " + name);
        try {
            startConn();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PLAYER_BY_NAME);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            connection.commit();
            connection.close();

        } catch (SQLException e) {
            log.severe("deletePlayerByName: Exception occured: " + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * returns a player based on the provided name
     *
     * @param name,       Player name
     * @param connection, Connection instance
     * @return TRUE if the requested player record is found, else false.
     */
    public Player getPlayerByName(String name, Connection connection) {
        log.info("getPlayerByName: get player with name: " + name);
        try {
            startConn();
            PreparedStatement preparedStatement = connection.prepareStatement(FETCH_PLAYER_BY_NAME);
            preparedStatement.setString(1, name);
            connection.commit();
            connection.close();

        } catch (SQLException e) {
            log.severe("getPlayerByName: Exception occurred: " + e.getMessage());
            return null;
        }
        return new Player();
    }

    public List<Player> getTop10Scorers() {
        log.info("getTop10Scorers: get top10 players in scoring");
        List<Player> top10Scorers = new ArrayList<>();
        try {
            startConn();
            PreparedStatement preparedStatement = connection.prepareStatement(TOP_10_SCORERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                player.setId(resultSet.getInt(1));
                player.setFullname(resultSet.getString(2));
                player.setTeam(teamRepository.findTeamById(resultSet.getInt(3)));
                player.setPlayerStats(playerStatRepository.getStatsByPlayerName(player.getFullname()));
                player.setNationality(resultSet.getString(5));
                player.setAge(resultSet.getInt(6));
                player.setPosition(resultSet.getString(7));
                top10Scorers.add(player);
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            log.severe("getTop10Scorers: Exception has occurred= " + e.getMessage());
            return null;
        }
        return top10Scorers;
    }

    public List<Player> getTop10Assists() {
        log.info("getTop10Assists: get top10 players in assists");
        List<Player> top10Assists = new ArrayList<>();
        try {
            startConn();
            PreparedStatement preparedStatement = connection.prepareStatement(TOP_10_ASSISTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                player.setId(resultSet.getInt(1));
                player.setFullname(resultSet.getString(2));
                player.setTeam(teamRepository.findTeamById(resultSet.getInt(3)));
                player.setPlayerStats(playerStatRepository.getStatsByPlayerName(player.getFullname()));
                player.setNationality(resultSet.getString(5));
                player.setAge(resultSet.getInt(6));
                player.setPosition(resultSet.getString(7));
                top10Assists.add(player);
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            log.severe("getTop10Assists: Exception has occurred= " + e.getMessage());
            return null;
        }
        return top10Assists;
    }

    public List<Player> getTop10Rebounds() {
        log.info("getTop10Rebounds: get top10 players in assists");
        List<Player> top10Rebounds = new ArrayList<>();
        try {
            startConn();
            PreparedStatement preparedStatement = connection.prepareStatement(TOP_10_REBOUNDS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                player.setId(resultSet.getInt(1));
                player.setFullname(resultSet.getString(2));
                player.setTeam(teamRepository.findTeamById(resultSet.getInt(3)));
                player.setPlayerStats(playerStatRepository.getStatsByPlayerName(player.getFullname()));
                player.setNationality(resultSet.getString(5));
                player.setAge(resultSet.getInt(6));
                player.setPosition(resultSet.getString(7));
                top10Rebounds.add(player);
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            log.severe("getTop10Rebounds: Exception has occurred= " + e.getMessage());
            return null;
        }
        return top10Rebounds;
    }

    private void startConn() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgres://dblabs.iee.ihu.gr:5432/it17512", "it175120", "Peri658072@");
    }
}
