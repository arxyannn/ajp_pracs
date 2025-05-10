import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
    void update(float price);
}

// Concrete Observer: PriceAlert
class PriceAlert implements Observer {
    public void update(float price) {
        System.out.println("PriceAlert: Stock price changed to " + price);
    }
}

// Concrete Observer: DisplayBoard
class DisplayBoard implements Observer {
    public void update(float price) {
        System.out.println("DisplayBoard: New stock price is " + price);
    }
}

// Subject Class
class StockPriceTracker {
    private List<Observer> observers = new ArrayList<>();
    private float stockPrice;

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void setStockPrice(float price) {
        this.stockPrice = price;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockPrice);
        }
    }
}

// Main class
public class StockObserverDemo {
    public static void main(String[] args) {
        StockPriceTracker tracker = new StockPriceTracker();

        Observer alert = new PriceAlert();
        Observer board = new DisplayBoard();

        tracker.addObserver(alert);
        tracker.addObserver(board);

        tracker.setStockPrice(100.5f);
        tracker.setStockPrice(103.2f);
    }
}
