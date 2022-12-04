package repository;

import entity.Coach;

import java.sql.*;
import java.util.logging.Logger;

import static contants.SqlStatements.*;

public class CoachRepository {

    private final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private LeagueRepository leagueRepository = new LeagueRepository();

    private TeamRepository teamRepository = new TeamRepository();

    private Connection connection;

    /**
     * inserts a coach into the PLAYERS table
     *
     * @param coachEntity, Player instance
     * @return TRUE if the player record is persisted successfully, else false.
     */
    public boolean insertCoach(Coach coachEntity) {
        log.info("insertCoach: persist new coach: " + coachEntity);
        try {
            startConn();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COACH);
            preparedStatement.setInt(1, coachEntity.getCoach_id());
            preparedStatement.setString(2, coachEntity.getFullname());
            preparedStatement.setString(3, coachEntity.getNationality());
            preparedStatement.setInt(4, teamRepository.findTeamByName(coachEntity.getTeam().getName()).getId()); // getTeamByTeamName
            preparedStatement.setInt(5, leagueRepository.getLeagueByName(coachEntity.getLeague().getName()).getLeague_id()); // getLeagueByName
            preparedStatement.executeUpdate();
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            log.severe("insertCoach: Exception occured: " + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * updates a coach records in COACHES table
     *
     * @param coachEntity, Coach instance
     * @param connection,  Connection instance
     * @return TRUE if the player record is updated successfully, else false.
     */
    public boolean updateCoach(Coach coachEntity, Connection connection) {
        log.info("updateCoach: update coach with id: " + coachEntity.getCoach_id());
        try {
            startConn();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COACH);
            preparedStatement.setString(1, coachEntity.getFullname());
            preparedStatement.setString(2, coachEntity.getNationality());
            preparedStatement.setInt(3, teamRepository.findTeamByName(coachEntity.getTeam().getName()).getId()); // getTeamByTeamName
            preparedStatement.setInt(4, leagueRepository.getLeagueByName(coachEntity.getLeague().getName()).getLeague_id()); // getLeagueByName
            preparedStatement.setInt(5, coachEntity.getCoach_id());
            preparedStatement.executeUpdate();
            preparedStatement.executeUpdate();
            connection.commit();
            connection.close();

        } catch (SQLException e) {
            log.severe("updateCoach: Exception occured: " + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * deletes a coach record from the COACHES table
     *
     * @param name,       Coach name
     * @param connection, Connection instance
     * @return TRUE if the coach record is deleted successfully, else false.
     */
    public boolean deleteCoachByName(String name, Connection connection) {
        log.info("deleteCoachByName: delete coach with name: " + name);
        try {
            startConn();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COACH_BY_NAME);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            log.severe("deleteCoachByName: Exception occurred: " + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * returns a coach record based on the provided name
     *
     * @param name,       Coach name
     * @param connection, Connection instance
     * @return TRUE if the requested coach record is found, else false.
     */
    public Coach getCoachByName(String name, Connection connection) {
        log.info("getCoachByName: find coach with name: " + name);
        Coach coach = new Coach();
        try {
            startConn();
            PreparedStatement preparedStatement = connection.prepareStatement(FETCH_COACH_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                coach.setCoach_id(resultSet.getInt(1));
                coach.setFullname(resultSet.getString(2));
                coach.setNationality(resultSet.getString(3));
                coach.setTeam(teamRepository.findTeamById(resultSet.getInt(4)));
                coach.setLeague(leagueRepository.getById(resultSet.getInt(5)));
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            log.severe("getCoachByName: Exception occurred: " + e.getMessage());
            return null;
        }
        return coach;
    }

    private void startConn() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgres://dblabs.iee.ihu.gr:5432/it17512", "it175120", "Peri658072@");
    }
}
