package corp.operations.populate;

import corp.database.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;

import static corp.prefs.Prefs.POPULATE_DB_SQL_FILE_PATH;

public class DatabasePopulateService {
    public static void main(String[] args) {
       populate();
    }

    public static void populate() {
        try {
            String sqlAll = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(POPULATE_DB_SQL_FILE_PATH))
            );

            Statement DB = Database.getInstance().getStatement();
            String[] sqlParts = sqlAll.split("\n\n");

            for (String sql : sqlParts) {
                DB.executeUpdate(sql);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
