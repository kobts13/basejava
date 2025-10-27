package ru.javawebinar.basejava.util;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.sql.ABlockOfCode;
import ru.javawebinar.basejava.sql.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlHelper {
    private final ConnectionFactory connectionFactory;

    private SqlHelper(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public SqlHelper(String dbUrl, String dbUser, String dbPassword) {
        this(() -> DriverManager.getConnection(dbUrl, dbUser, dbPassword));
    }

    public <T> T execute(String sql, ABlockOfCode<T> block) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            return block.execute(ps);
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }
}
