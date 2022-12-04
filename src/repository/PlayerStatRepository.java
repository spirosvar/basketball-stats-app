package repository;

import entity.PlayerStats;

import java.sql.*;
import java.util.logging.Logger;

import static contants.SqlStatements.*;

public class PlayerStatRepository {


    private final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private Connection connection;

    /**
     * inserts a player-stats into the PLAYERS table
     *
     * @param playerStatsEntity, Player instance
     * @return TRUE if the player-stats record is persisted successfully, else false.
     */
    public boolean insertPlayerStats(PlayerStats playerStatsEntity) {
        log.info("insertPlayerStats: insert new player-stats record");
        try {
            startConn();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PLAYER_STATS);
            preparedStatement.setInt(1, playerStatsEntity.getId());
            preparedStatement.setInt(2, playerStatsEntity.getRebounds());
            preparedStatement.setInt(3, playerStatsEntity.getAssists());
            preparedStatement.setInt(4, playerStatsEntity.getPoints());
            preparedStatement.setInt(5, playerStatsEntity.getTurnovers());
            preparedStatement.setInt(6, playerStatsEntity.getSteals());
            preparedStatement.setInt(7, playerStatsEntity.getBlocks());
            preparedStatement.setInt(8, playerStatsEntity.getMadeShots());
            preparedStatement.setInt(9, playerStatsEntity.getTotalShots());
            preparedStatement.setInt(10, playerStatsEntity.getGames_played());
            preparedStatement.executeQuery();
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            log.severe("insertPlayerStats: an exception has occurred= " + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * updates a player-stats into the PLAYERS table
     *
     * @param playerStatsEntity, playerStats instance
     * @return TRUE if the player-stats record is updated successfully, else false.
     */
    public boolean updatePlayerStats(PlayerStats playerStatsEntity) {
        log.info("updatePlayerStats: update player-stats record with id= " + playerStatsEntity.getId());
        try {
            startConn();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PLAYER_STATS);
            preparedStatement.setInt(1, playerStatsEntity.getRebounds());
            preparedStatement.setInt(2, playerStatsEntity.getAssists());
            preparedStatement.setInt(3, playerStatsEntity.getPoints());
            preparedStatement.setInt(4, playerStatsEntity.getTurnovers());
            preparedStatement.setInt(5, playerStatsEntity.getSteals());
            preparedStatement.setInt(6, playerStatsEntity.getBlocks());
            preparedStatement.setInt(7, playerStatsEntity.getMadeShots());
            preparedStatement.setInt(8, playerStatsEntity.getTotalShots());
            preparedStatement.setInt(9, playerStatsEntity.getGames_played());
            preparedStatement.setInt(10, playerStatsEntity.getId());
            preparedStatement.executeQuery();
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            log.severe("updatePlayerStats: an exception has occurred= " + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * deletes a player-stats from the PLAYERS table
     *
     * @param name, Player-stats
     * @return TRUE if the player-stats record is deleted successfully, else false.
     */
    public boolean deletePlayerStatsByPlayerName(String name) {
        log.info("deletePlayerStatsByPlayerName: update player-stats record for player= " + name);
        try {
            startConn();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PLAYER_STATS_BY_NAME);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            log.severe("deletePlayerStatsByPlayerName: an exception has occurred= " + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * returns a player based on the provided name
     *
     * @param name, Player name
     * @return TRUE if the requested player-stats record is found, else false.
     */
    public PlayerStats getStatsByPlayerName(String name) {
        log.info("getStatsByPlayerName: fetch stats for player= " + name);
        try {
            startConn();
            PreparedStatement preparedStatement = connection.prepareStatement(FETCH_PLAYER_STATS_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            PlayerStats playerStats = new PlayerStats();
            while (resultSet.next()) {
                playerStats.setId(resultSet.getInt(1));
                playerStats.setId(resultSet.getInt(1));
            }
            connection.commit();
            connection.close();

        } catch (SQLException e) {
            log.severe("getStatsByPlayerName: an exception has occurred= " + e.getMessage());
            return null;
        }
        return new PlayerStats();
    }

    private void startConn() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgres://dblabs.iee.ihu.gr:5432/it17512", "it175120", "Peri658072@");
    }

}
