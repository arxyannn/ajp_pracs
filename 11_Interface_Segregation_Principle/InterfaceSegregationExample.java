// Separate interfaces
interface Printer {
    void print(String document);
}

interface Scanner {
    void scan(String document);
}

interface FaxMachine {
    void fax(String document);
}

// Class that implements only printing
class SimplePrinter implements Printer {
    public void print(String document) {
        System.out.println("Printing: " + document);
    }
}

// Class that implements print, scan, and fax
class MultiFunctionPrinter implements Printer, Scanner, FaxMachine {
    public void print(String document) {
        System.out.println("Printing: " + document);
    }

    public void scan(String document) {
        System.out.println("Scanning: " + document);
    }

    public void fax(String document) {
        System.out.println("Faxing: " + document);
    }
}

// Test class
public class InterfaceSegregationExample {
    public static void main(String[] args) {
        Printer printer = new SimplePrinter();
        printer.print("Test Document");

        MultiFunctionPrinter mfp = new MultiFunctionPrinter();
        mfp.print("Report");
        mfp.scan("Report");
        mfp.fax("Report");
    }
}