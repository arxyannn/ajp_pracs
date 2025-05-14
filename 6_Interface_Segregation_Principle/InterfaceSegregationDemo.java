// File: InterfaceSegregationDemo.java
// Apply Interface Segregation Principle
// Create separate interfaces for print, scan, and fax operations and implement only required ones.

// Separate interfaces
interface Printer {
    void print(String document);
}

interface Scanner {
    void scan(String document);
}

interface Fax {
    void fax(String document);
}

// Class that only needs print functionality
class BasicPrinter implements Printer {
    @Override
    public void print(String document) {
        System.out.println("Printing: " + document);
    }
}

// Class that needs print and scan
class MultiFunctionPrinter implements Printer, Scanner {
    @Override
    public void print(String document) {
        System.out.println("MFP Printing: " + document);
    }

    @Override
    public void scan(String document) {
        System.out.println("MFP Scanning: " + document);
    }
}

// Class that needs all three
class OfficeMachine implements Printer, Scanner, Fax {
    @Override
    public void print(String document) {
        System.out.println("OfficeMachine Printing: " + document);
    }

    @Override
    public void scan(String document) {
        System.out.println("OfficeMachine Scanning: " + document);
    }

    @Override
    public void fax(String document) {
        System.out.println("OfficeMachine Faxing: " + document);
    }
}

public class InterfaceSegregationDemo {
    public static void main(String[] args) {
        Printer printer = new BasicPrinter();
        printer.print("Report.pdf");

        MultiFunctionPrinter mfp = new MultiFunctionPrinter();
        mfp.print("Resume.docx");
        mfp.scan("Resume.docx");

        OfficeMachine office = new OfficeMachine();
        office.print("Invoice.xlsx");
        office.scan("Invoice.xlsx");
        office.fax("Invoice.xlsx");
    }
}
