public class ISP {
}

/*
4. Interface Segregation Principle (ISP)
The Interface Segregation Principle states that a client should not be forced to implement an interface that it does not use.
This principle deals with the disadvantages of implementing big interfaces.
When a class implements an interface, it should not be forced to implement methods that it does not use.
instead, the interface should be broken down into smaller, more specific interfaces so that the client can implement only the methods that it needs.
 */

interface Printer {
    void printDocument(String document);
    void scanDocument(String document);
    void faxDocument(String document);
    void stapleDocument(String document);
}

class BasicPrinter implements Printer {
    @Override
    public void printDocument(String document) {
        System.out.println("Printing document: " + document);
    }

    @Override
    public void scanDocument(String document) {
        // This printer can't scan, so we throw an exception
        throw new UnsupportedOperationException("Basic printer can't scan documents.");
    }

    @Override
    public void faxDocument(String document) {
        // This printer can't fax, so we throw an exception
        throw new UnsupportedOperationException("Basic printer can't fax documents.");
    }

    @Override
    public void stapleDocument(String document) {
        // This printer can't staple, so we throw an exception
        throw new UnsupportedOperationException("Basic printer can't staple documents.");
    }
}

class AdvancedPrinter implements Printer {
    @Override
    public void printDocument(String document) {
        System.out.println("Printing document: " + document);
    }

    @Override
    public void scanDocument(String document) {
        System.out.println("Scanning document: " + document);
    }

    @Override
    public void faxDocument(String document) {
        System.out.println("Faxing document: " + document);
    }

    @Override
    public void stapleDocument(String document) {
        System.out.println("Stapling document: " + document);
    }
}

// Why This is a Problem
// The BasicPrinter class implements the Printer interface, but it doesn't support scanning, faxing, or stapling documents.
// This violates the Interface Segregation Principle because the BasicPrinter class is forced to implement methods that it doesn't need or use.

// Restructuring the code to follow ISP

interface Printer1 {
    void printDocument(String document);
}

interface Fax {
    void faxDocument(String document);
}

interface Scanner {
    void scanDocument(String document);
}

class BasicPrinter1 implements Printer1 {
    public void printDocument(String document) {
        System.out.println("Printing document: " + document);    }
}

class AdvancedPrinter1 implements Printer1, Fax, Scanner  {
    public void printDocument(String document) {
       System.out.println("Printing document: " + document);
    }

    public void scanDocument(String document) {
        System.out.println("Scanning document: " + document);
    }

    public void faxDocument(String document) {
        System.out.println("Faxing document: " + document);
    }

    public void stapleDocument(String document) {
        System.out.println("Stapling document: " + document);
    }
}