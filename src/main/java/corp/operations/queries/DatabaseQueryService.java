package corp.operations.queries;

import corp.operations.queries.clients.Client;
import corp.operations.queries.clients.ClientsQueries;
import corp.operations.queries.projects.Project;
import corp.operations.queries.projects.ProjectsQueries;
import corp.operations.queries.workers.Worker;
import corp.operations.queries.workers.WorkersQueries;

import java.util.List;

public class DatabaseQueryService {
    public static void main(String[] args) {
        new DatabaseQueryService().makeQueries();
    }

    public void makeQueries() {
        System.out.println("Clients with the maximum number of projects were found:");
        List<Client> clients = new ClientsQueries().findMaxProjectsClient();
        for (Client client : clients) {
            System.out.println("name: " + client.getName() + "; project_count: " + client.getProjectCount() + ";");
        }

        System.out.println("Workers with the maximum salary were found:");
        List<Worker> workers = new WorkersQueries().findMaxSalaryWorker();
        for (Worker worker : workers) {
            System.out.println("name: " + worker.getName() + "; salary: " + worker.getSalary() + ";");
        }

        System.out.println("The youngest and eldest workers were found:");
        List<Worker> olderWorkers = new WorkersQueries().findYoungestAndEldestWorkers();
        for (Worker worker : olderWorkers) {
            System.out.println("name: " + worker.getName() + "; type: " + worker.getType() + "; birthday: " + worker.getBirthday() + ";");
        }

        System.out.println("Projects with the longest duration were found:");
        List<Project> projects = new ProjectsQueries().findLongestProject();
        for (Project project : projects) {
            System.out.println("client name: " + project.getClientName() + "; month count: " + project.getMonthCount() + ";");
        }

        System.out.println("Projects with this prices were found:");
        List<Project> projectPrices = new ProjectsQueries().printProjectPrices();
        for (Project project : projectPrices) {
            System.out.println("project name: " + project.getProjectName() + "; project price: " + project.getProjectPrice() + ";");
        }
    }
}
