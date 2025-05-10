// Implement Observer Design Pattern
// Create a subject-observer structure where multiple observers get notified when the subject's state changes.


import java.util.*;

// Observer interface
interface Observer {
    void update(float temperature);
}

// Concrete Observer
class CelsiusDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Temperature in Celsius: " + temperature);
    }
}

// Subject class
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

// Main class to test the observer pattern
public class ObserverExample {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        Observer display1 = new CelsiusDisplay();
        Observer display2 = new CelsiusDisplay(); // Another observer

        station.addObserver(display1);
        station.addObserver(display2);

        // Change temperature
        station.setTemperature(25.5f);
        station.setTemperature(30.0f);
    }
}