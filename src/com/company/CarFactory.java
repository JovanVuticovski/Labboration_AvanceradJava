package com.company;

public class CarFactory {

    public Car createCar(CarType carType){
        return switch (carType){
            case COMFORT -> new Bmw();
            case SWEDISH -> new Volvo();
            case ELECTRIC -> new Minicooper();
            case EXPENSIVE -> new Audi();
        };
    }
}
