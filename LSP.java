public class LSP {
}

/*
3. Liskov Substitution Principle (LSP)
The Liskov Substitution Principle states that objects of a superclass should be replaceable with objects of its subclasses without
affecting the functionality of the program.
This principle means that a subclass should behave in a way that it can substitute for its parent class without causing issues in the system.
If a subclass breaks the behavior expected from the parent class, it violates LSP.
*/

// Problem in below code

class Car {
    public void start() {
        System.out.println("Engine started");
    }

    public void stop() {
        System.out.println("Accelerating");
    }

    public void refuel() {
        System.out.println("Refueling");
    }
}


class ElectricCar extends Car {
    public void start() {
        System.out.println("Electric engine started");
    }

    public void stop() {
        System.out.println("Electric engine stopped");
    }

    public void refuel() {
        throw new UnsupportedOperationException("Electric cars cannot be refueled");
    }

    public void reCharge() {
        System.out.println("Car is recharging");
    }
}

// The ElectricCar class violates the Liskov Substitution Principle because it does not behave as expected when substituted for the Car class.

class Client {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.stop();
        car.refuel();

        Car electricCar = new ElectricCar();
        electricCar.start();
        electricCar.stop();
        electricCar.refuel(); // This will throw an UnsupportedOperationException
    }
}

// Break The Hierarchy for Adhering to LSP

abstract class Vehicle {
    public void start() {
        System.out.println("Vehicle is starting");
    }

    public void stop() {
        System.out.println("Vehicle is stopping");
    }

    // Abstract method for fuel/energy behavior
    public abstract void refuel();
}

class CarCopy extends Vehicle {
    @Override
    public void refuel() {
        System.out.println("Car is refueling with gasoline");
    }
}

class ElectricCarNew extends Vehicle {
    @Override
    public void refuel() {
        // Call recharge() instead of refueling with gasoline
        recharge();
    }

    // Electric cars need to recharge instead of refuel
    private void recharge() {
        System.out.println("Electric car is recharging");
    }
}


// Using Composition to Follow Liskov Substitution Principle (LSP)

class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

// Problems with inheritance

class Penguin extends Bird {
    @Override
    public void fly() {
        // Penguins can't fly, so this breaks the substitution
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}

// Solution: Using Composition to Follow LSP

interface Flyable {
    void fly();
}

class BirdNew {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

// Class for flying birds that uses the Flyable interface
 class Sparrow extends Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

// Class for non-flying birds like Penguin
class PenguinCopy extends Bird {
    // Penguins do not implement Flyable, so no fly() method is needed
}

