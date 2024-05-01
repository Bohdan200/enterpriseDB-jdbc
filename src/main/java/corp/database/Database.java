package corp.database;

import corp.prefs.Prefs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final Database INSTANCE = new Database();
    private final Connection connection;

    private Database() {
        try {
            Prefs prefs = new Prefs();
            String dbUrl = prefs.getString(Prefs.DB_JDBC_CONNECTION_URL);
            String dbUser = prefs.getString(Prefs.DB_JDBC_CONNECTION_USER);
            String dbPass = prefs.getString(Prefs.DB_JDBC_CONNECTION_PASSWORD);

            connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Statement getStatement() throws SQLException {
        return connection.createStatement();
    }

    public static Database getInstance() {
        return INSTANCE;
    }
}
