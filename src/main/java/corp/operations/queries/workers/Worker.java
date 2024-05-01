package corp.operations.queries.workers;

import java.time.LocalDate;

public class Worker {
    private final String name;
    private int salary = 0;
    private LocalDate birthday;
    private String type = "";

    public Worker(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public Worker(String name, String type, LocalDate birthday) {
        this.name = name;
        this.type = type;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getType() {
        return type;
    }
}
