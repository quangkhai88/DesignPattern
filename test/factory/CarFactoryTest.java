package factory;

import models.car.Car;
import models.car.CarType;
import models.car.LuxuryCar;
import models.car.engine.MediumEngine;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CarFactoryTest {

    @Test
    public void testGetCarType() {
        assertTrue(CarFactory.createCar(CarType.LUXURY) instanceof LuxuryCar);
    }

    @Test
    public void testGetCarTypeAndEngine() {
        Car car = CarFactory.createCar(CarType.LUXURY, new MediumEngine());
        assertTrue(car instanceof LuxuryCar);
        assertTrue(car.getEngine() instanceof MediumEngine);
    }

}
