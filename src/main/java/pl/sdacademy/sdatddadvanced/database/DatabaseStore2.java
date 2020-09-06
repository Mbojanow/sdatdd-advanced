package pl.sdacademy.sdatddadvanced.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import pl.sdacademy.sdatddadvanced.arguments.enums.User;
import pl.sdacademy.sdatddadvanced.exceptions.EmailAlreadyTakenException;
import pl.sdacademy.sdatddadvanced.exceptions.UserRepository;

public class DatabaseStore2 {

    private final List<String> data = new ArrayList<>();
    private final DatabaseConnection databaseConnection;
    private final UserRepository userRepository;

    public DatabaseStore2(final DatabaseConnection databaseConnection, final UserRepository userRepository) {
        this.databaseConnection = databaseConnection;
        this.userRepository = userRepository;
    }

    public void clean() {
        data.clear();
    }

    public void addData(final String ...values) {
        if (!tryOpenDatabaseConnectionIfClosed()) {
            throw new DatabaseStoreException("Connection is not opened. Cannot add data");
        }
        Stream.of(values).forEach(value -> {
            try {
                userRepository.add(
                    User.builder().firstName(value).build()
                );
            } catch (EmailAlreadyTakenException e) {
                e.printStackTrace();
            }
        });
    }

    private boolean tryOpenDatabaseConnectionIfClosed() {
        if (!databaseConnection.isOpened()) {
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
