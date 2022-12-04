package repository;

import entity.League;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static contants.SqlStatements.*;

public class LeagueRepository {

    private final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private League league = new League();

    private Connection connection;


    /**
     * returns a League based on the provided name
     *
     * @param name,       League name
     * @return TRUE if the requested League record is found, else false.
     */
    public League getLeagueByName(String name) {
        log.info("getLeagueByName: get league with name: " + name);
        try {
            startConn();
            PreparedStatement preparedStatement = connection.prepareStatement(FETCH_LEAGUE_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                league.setLeague_id(resultSet.getInt(1));
                league.setNationality(resultSet.getString(2));
                league.setDivision(resultSet.getInt(3));
                league.setName(resultSet.getString(4));
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            log.severe("getLeagueByName: Exception occurred: " + e.getMessage());
            return null;
        }
        return league;
    }

    public League getById(int id) throws SQLException {
        log.info("getLeagueByName: get league with id: " + id);
        PreparedStatement preparedStatement = connection.prepareStatement(FETCH_LEAGUE_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            league.setLeague_id(id);
            league.setNationality(rs.getString(2));
            league.setDivision(rs.getInt(3));
            league.setName(rs.getString(4));
        }
        return league;
    }

    public List<League> getAll() throws SQLException {
        log.info("getAll: find all leagues stored in database");
        PreparedStatement preparedStatement = connection.prepareStatement(FETCH_LEAGUE_BY_ID);
        ResultSet rs = preparedStatement.executeQuery();
        List<League> allLeagues = new ArrayList<>();
        while (rs.next()){
            league.setLeague_id(rs.getInt("league_id"));
            league.setNationality(rs.getString("nationality"));
            league.setDivision(rs.getInt("division"));
            league.setName(rs.getString("name"));
            allLeagues.add(league);
        }
        return allLeagues;
    }

    private void startConn() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgres://dblabs.iee.ihu.gr:5432/it17512", "it175120", "Peri658072@");
    }
}
