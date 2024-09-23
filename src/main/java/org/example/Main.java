package org.example;

interface Engine {
    void start();
}

class PetrolEngine implements Engine {
    public void start() {
        System.out.println("Petrol engine started");

    }
}

class Car {
    private Engine engine; // Loosely coupled through interface

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void startCar() {
        engine.start();
    }
}

public class Main {
    public static void main(String[] args) {
        Engine engine = new PetrolEngine();
        Car car = new Car(engine); // Passing engine via constructor
        car.startCar();
    }
}