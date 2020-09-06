package pl.sdacademy.sdatddadvanced.mocks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CarTest {

  @Test
  void playingWithMocks() {
    final Car mock = Mockito.mock(Car.class);
    System.out.println(mock.getDoorsNum());
    System.out.println(mock.getFeatures());
    System.out.println(mock.getWheelsNum());

    mock.setDoorsNum(4);
    System.out.println(mock.getDoorsNum());
  }
}