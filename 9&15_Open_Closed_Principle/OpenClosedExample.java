// Interface (abstraction)
interface PaymentMethod {
    void pay(double amount);
}

// Existing class (no need to change this later)
class CreditCardPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

// New functionality added by extension
class UPIPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI.");
    }
}

// High-level class that uses abstraction
class PaymentProcessor {
    private PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(double amount) {
        paymentMethod.pay(amount);
    }
}

// Main method
public class OpenClosedExample {
    public static void main(String[] args) {
        PaymentProcessor processor1 = new PaymentProcessor(new CreditCardPayment());
        processor1.processPayment(250.00);

        PaymentProcessor processor2 = new PaymentProcessor(new UPIPayment());
        processor2.processPayment(100.00);
    }
}