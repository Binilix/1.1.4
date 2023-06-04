package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDaoJDBCImpl user = new UserDaoJDBCImpl();
        user.createUsersTable();
        user.saveUser("Nikita", "Stupakov", Byte.parseByte("24"));
        user.saveUser("Nikita", "Stupakov", Byte.parseByte("26"));
        System.out.println(user.getAllUsers());
        user.cleanUsersTable();
        user.dropUsersTable();
    }
}
