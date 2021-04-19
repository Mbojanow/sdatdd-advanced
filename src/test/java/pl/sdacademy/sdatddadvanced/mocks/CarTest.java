package pl.sdacademy.sdatddadvanced.mocks;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

class CarTest {

    @Test
    void mockPractice() {
        final Car golf = new Car(3, 2, "Golf", List.of());
        System.out.println(golf.getDoorsNum());
        golf.setDoorsNum(3);
        System.out.println(golf.getDoorsNum());

        final Car mock = Mockito.mock(Car.class);
        System.out.println(mock.getDoorsNum());
        mock.setDoorsNum(3);
        System.out.println(mock.getDoorsNum());
    }
}
