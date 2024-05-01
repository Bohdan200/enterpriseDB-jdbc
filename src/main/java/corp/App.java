package corp;

import corp.operations.init.DatabaseInitService;
import corp.operations.populate.DatabasePopulateService;
import corp.operations.queries.DatabaseQueryService;

public class App {
    public static void main(String[] args) {
        DatabaseInitService.init();
        DatabasePopulateService.populate();
        new DatabaseQueryService().makeQueries();
    }
}