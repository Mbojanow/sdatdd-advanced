package pl.sdacademy.sdatddadvanced.mocks;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CarTest {

    //mock obiektu car w sposób PROGRAMATYWNY (bez adnotacji)

    @Test
    void justPlayingWithMockito() {
        Car mock = Mockito.mock(Car.class);

        System.out.println(mock.getDoorsNum());
        System.out.println(mock.getWheelsNum());
        System.out.println(mock.getModel());
        System.out.println(mock.getFeatures());

        mock.setDoorsNum(3);
        mock.getFeatures().add("klima");
        System.out.println(mock.getDoorsNum());
        System.out.println(mock.getFeatures());
    }
}