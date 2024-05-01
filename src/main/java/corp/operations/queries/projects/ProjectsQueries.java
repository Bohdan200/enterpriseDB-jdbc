package corp.operations.queries.projects;

import corp.database.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static corp.prefs.Prefs.FIND_LONGEST_PROJECT_SQL_FILE_PATH;
import static corp.prefs.Prefs.PRINT_PROJECT_PRICES_SQL_FILE_PATH;

public class ProjectsQueries {
    public List<Project> findLongestProject() {
        List<Project> longestProjectList = new ArrayList<>();

        try {
            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(FIND_LONGEST_PROJECT_SQL_FILE_PATH))
            );

            Statement DB = Database.getInstance().getStatement();
            ResultSet rs = DB.executeQuery(sql);

            while(rs.next()) {
                String clientName = rs.getString("name");
                int monthCount = rs.getInt("month_count");

                Project project = new Project(clientName, monthCount, "");
                longestProjectList.add(project);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        return longestProjectList;
    }

    public List<Project> printProjectPrices() {
        List<Project> projectPricesList = new ArrayList<>();

        try {
            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(PRINT_PROJECT_PRICES_SQL_FILE_PATH))
            );

            Statement DB = Database.getInstance().getStatement();
            ResultSet rs = DB.executeQuery(sql);

            while(rs.next()) {
                String projectName = rs.getString("name");
                int projectPrice = rs.getInt("price");

                Project project = new Project(projectName, projectPrice);
                projectPricesList.add(project);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        return projectPricesList;
    }
}
