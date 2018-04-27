package global;

import adapter.CarController;
import adapter.CarListAdapter;
import adapter.CarManager;
import builder.CarBuilder;
import builder.CarDirectorBuilder;
import builder.LuxuryCarBuilder;
import builder.SedanCarBuilder;
import chainOfResponsibility.Calculate10;
import chainOfResponsibility.Calculate2;
import chainOfResponsibility.Calculate5;
import decorator.ArmedCar;
import decorator.SportCar;
import decorator.component.Gun;
import factory.CarFactory;
import iterator.CarContainer;
import iterator.IIterator;
import models.car.Car;
import models.car.CarType;
import models.car.engine.MediumEngine;
import models.car.engine.SmallEngine;
import singleton.UserSession;
import state.Engine;

public class Pattern {

    /*
     * Test all design pattern
     */

    public static void main(String[] args) {

        builderPattern();
        singletonPattern();
        adapterPattern();
        decoratorPattern();
        iteratorPattern();
        statePattern();
        factoryPattern();
        bridgePattern();

        chainOfResponsibility();
    }

    private static void chainOfResponsibility() {

        System.out.println("----Chain of responsibility----");

        int amount = 13;

        Calculate10 calculate10 = new Calculate10();
        Calculate5 calculate5 = new Calculate5();
        Calculate2 calculate2 = new Calculate2();

        calculate10.setNextCalculate(calculate5);
        calculate5.setNextCalculate(calculate2);

        System.out.println("The amount to calculate : " + amount);
        calculate10.calculate(amount);


        System.out.println("----********** ---- ********----");
    }

    private static void iteratorPattern() {
        CarContainer container = new CarContainer();
        IIterator iterator = container.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void decoratorPattern() {
        Car luxuryCar = CarFactory.createCar(CarType.LUXURY, new MediumEngine());
        ArmedCar car = new ArmedCar(luxuryCar, new Gun());
        car.decorate();

        Car sedanCar = CarFactory.createCar(CarType.SEDAN, new SmallEngine());
        SportCar sportCar = new SportCar(sedanCar);
        sportCar.decorate();
    }

    private static void bridgePattern() {
        Car luxuryCar = CarFactory.createCar(CarType.LUXURY, new MediumEngine());
        Car sedanCar = CarFactory.createCar(CarType.SEDAN, new SmallEngine());

        luxuryCar.startEngine();
        sedanCar.startEngine();

    }

    private static void builderPattern() {
        CarBuilder carBuilder = new LuxuryCarBuilder();
        CarDirectorBuilder director = new CarDirectorBuilder(carBuilder);
        director.buildCar();
        System.out.println(director.getCar().toString());

        carBuilder = new SedanCarBuilder();
        director = new CarDirectorBuilder(carBuilder);
        director.buildCar();
        System.out.println(director.getCar().toString());
    }

    private static void factoryPattern() {
        Car luxuryCar = CarFactory.createCar(CarType.LUXURY);
        Car sedanCar = CarFactory.createCar(CarType.SEDAN);

        System.out.println("created : " + luxuryCar.getName());
        System.out.println("created : " + sedanCar.getName());

    }

    private static void singletonPattern() {
        UserSession session = UserSession.getInstance();
        session.addData(1, "abcd");
        session.addData(2, "cdef");
        System.out.println(session.getDataMap());
    }

    private static void adapterPattern() {
        CarController carController = new CarController();
        CarListAdapter carListAdapter = new CarListAdapter(CarManager.getInstance());
        carController.importAllCar(carListAdapter.getListCarImport());
    }

    private static void statePattern() {
        Engine engine = new Engine();
        int i = 0;
        while (i < 5) {
            engine.nexState();
            i++;
        }
    }

}