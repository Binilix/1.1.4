package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {
    Util util = new Util();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {
        Connection conn = util.getConnection();
        PreparedStatement statement = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Users(" +
                "id SERIAL PRIMARY KEY, " +
                "name TEXT, " +
                "lastName TEXT, " +
                "age INT)");
        statement.executeUpdate();

    }

    public void dropUsersTable() throws SQLException {
        Connection conn = util.getConnection();
        String sql = "DROP TABLE IF EXISTS Users";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.executeUpdate();


    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        Connection conn = util.getConnection();
        String sql = "INSERT INTO Users (name, lastname, age) Values(?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, lastName);
        statement.setInt(3, age);
        statement.executeUpdate();
    }

    public void removeUserById(long id) throws SQLException {
        Connection conn = util.getConnection();
        String sql = "DELETE FROM Users WHERE ID = (?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setLong(1, id);
        statement.executeUpdate();

    }

    public List<User> getAllUsers() throws SQLException {
        List schedule = new ArrayList();
        Connection conn = util.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong(1));
            user.setName(resultSet.getString(2));
            user.setLastName(resultSet.getString(3));
            user.setAge(resultSet.getByte(4));
            schedule.add(user);
        }
        return schedule;
    }

    public void cleanUsersTable() throws SQLException {
        Connection conn = util.getConnection();
        String sql = "DELETE FROM Users";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.executeUpdate();


    }
}
