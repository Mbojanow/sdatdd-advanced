package pl.sdacademy.sdatddadvanced.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseStore2 {

    private final List<String> data = new ArrayList<>();
    private final DatabaseConnection databaseConnection;

    public DatabaseStore2(final DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void clean() {
        data.clear();
    }

    public void addData(final String ...values) {
        if (!tryOpenDatabaseConnectionIfClosed()) {
            throw new DatabaseStoreException("Connection is not opened. Cannot add data");
        }
        data.addAll(Arrays.asList(values));
    }

    private boolean tryOpenDatabaseConnectionIfClosed() {
        if (databaseConnection.isOpened()) {
            databaseConnection.open();
        }
        return databaseConnection.isOpened();
    }

    public List<String> removeData(final String ...toRemove) {
        if (!tryOpenDatabaseConnectionIfClosed()) {
            throw new DatabaseStoreException("Connection is not opened. Cannot remove data");
        }
        data.removeAll(Arrays.asList(toRemove));
        return data;
    }

    public List<String> getData() {
        return data;
    }
}
