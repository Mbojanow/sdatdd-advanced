package pl.sdacademy.sdatddadvanced.database;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DatabaseStore2Test {

    @Mock
    private DatabaseConnection databaseConnection;

    @InjectMocks
    private DatabaseStore2 databaseStore2;

    @Test
    void shouldRemoveData() {
        Mockito.when(databaseConnection.isOpened()).thenReturn(false, true);
        // tylko dla metody zwracającej 'void'
        // implikuje że mockito sprawdza czy taka metoda zotała wywołana
        Mockito.doNothing().when(databaseConnection).open();

        List<String> data = databaseStore2.removeData("asd");

        assertThat(data).isEmpty();
        Mockito.verify(databaseConnection, Mockito.times(2)).isOpened();
    }

}