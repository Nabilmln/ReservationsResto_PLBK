package model;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private int id;
    private int capacity;
    private boolean reserved;
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1, 2));
        tables.add(new Table(2, 4));
        tables.add(new Table(3, 6));
    }

    public Table(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.reserved = false;
    }

    public int getId() { return id; }
    public int getCapacity() { return capacity; }
    public boolean isReserved() { return reserved; }
    public void setReserved(boolean status) { this.reserved = status; }

    public static Table findAvailableTable(int guests) {
        return tables.stream()
                .filter(t -> !t.isReserved() && t.getCapacity() >= guests)
                .findFirst()
                .orElse(null);
    }
}
