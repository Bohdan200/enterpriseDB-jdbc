package corp.operations.queries.workers;

import corp.database.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static corp.prefs.Prefs.FIND_MAX_SALARY_WORKER_SQL_FILE_PATH;
import static corp.prefs.Prefs.FIND_YOUNGEST_ELDEST_WORKERS_SQL_FILE_PATH;

public class WorkersQueries {
    public List<Worker> findMaxSalaryWorker() {
        List<Worker> maxSalaryWorkerList = new ArrayList<>();

        try {
            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(FIND_MAX_SALARY_WORKER_SQL_FILE_PATH))
            );

            Statement DB = Database.getInstance().getStatement();
            ResultSet rs = DB.executeQuery(sql);

            while(rs.next()) {
                String name = rs.getString("name");
                int salary = rs.getInt("salary");

                Worker worker = new Worker(name, salary);
                maxSalaryWorkerList.add(worker);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        return maxSalaryWorkerList;
    }

    public List<Worker> findYoungestAndEldestWorkers() {
        List<Worker> youngestAndEldestWorkersList = new ArrayList<>();

        try {
            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(FIND_YOUNGEST_ELDEST_WORKERS_SQL_FILE_PATH))
            );

            Statement DB = Database.getInstance().getStatement();
            ResultSet rs = DB.executeQuery(sql);

            while(rs.next()) {
                String name = rs.getString("name");
                String type = rs.getString("type");
                LocalDate birthday = LocalDate.parse(rs.getString("birthday"));

                Worker worker = new Worker(name, type, birthday);
                youngestAndEldestWorkersList.add(worker);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        return youngestAndEldestWorkersList;
    }
}
