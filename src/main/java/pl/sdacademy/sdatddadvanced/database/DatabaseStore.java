package pl.sdacademy.sdatddadvanced.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseStore {

    private List<String> data = new ArrayList<>();
    private final DatabaseConnection databaseConnection;

    public DatabaseStore(final DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void clean() {
        data.clear();
    }

    public void addData(final String ...values) {
        if (!databaseConnection.isOpened()) {
            throw new DatabaseStoreException("Connection is not opened. Cannot add data");
        }
        data.addAll(Arrays.asList(values));
    }

    public List<String> removeData(final String ...toRemove) {
        if (!databaseConnection.isOpened()) {
            throw new DatabaseStoreException("Connection is not opened. Cannot remove data");
        }
        data.removeAll(Arrays.asList(toRemove));
        return data;
    }

    public List<String> getData() {
        return data;
    }
}
