package corp.operations.queries.clients;

import corp.database.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static corp.prefs.Prefs.FIND_MAX_PROJECTS_CLIENT_SQL_FILE_PATH;

public class ClientsQueries {
    public List<Client> findMaxProjectsClient() {
        List<Client> maxProjectsClientList = new ArrayList<>();

        try {
            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(FIND_MAX_PROJECTS_CLIENT_SQL_FILE_PATH))
            );

            Statement DB = Database.getInstance().getStatement();
            ResultSet rs = DB.executeQuery(sql);

            while(rs.next()) {
                String name = rs.getString("name");
                int projectCount = rs.getInt("project_count");

                Client client = new Client(name, projectCount);
                maxProjectsClientList.add(client);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        return maxProjectsClientList;
    }
}
