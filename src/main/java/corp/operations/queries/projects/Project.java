package corp.operations.queries.projects;

public class Project {
    private String projectName = "";
    private String clientName = "";
    private int projectPrice = 0;
    private int monthCount = 0;

    public Project(String clientName, int monthCount, String projectName) {
        this.clientName = clientName;
        this.monthCount = monthCount;
    }

    public Project(String projectName, int projectPrice) {
        this.projectName = projectName;
        this.projectPrice = projectPrice;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getProjectPrice() {
        return projectPrice;
    }

    public String getClientName() {
        return clientName;
    }

    public int getMonthCount() {
        return monthCount;
    }
}
