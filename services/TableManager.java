package services;

import model.Table;
import java.util.ArrayList;
import java.util.List;

public class TableManager {
    private final List<Table> tables;

    public TableManager() {
        this.tables = new ArrayList<>();
        tables.add(new Table(1, 2));
        tables.add(new Table(2, 4));
        tables.add(new Table(3, 6));
    }

    public Table findAvailableTable(int guests) {
        return tables.stream()
                .filter(t -> !t.isReserved() && t.getCapacity() >= guests)
                .findFirst()
                .orElse(null);
    }

    public void reserveTable(Table table) {
        table.setReserved(true);
    }

    public void releaseTable(Table table) {
        table.setReserved(false);
    }
}
