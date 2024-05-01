package corp.operations.queries.clients;

public class Client {
    private final String name;
    private final int projectCount;

    public Client(String name, int projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    public String getName() {
        return name;
    }

    public int getProjectCount() {
        return projectCount;
    }
}
