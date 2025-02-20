public class OpenClose {
}

// 2. Open Close Principle

// Open close principle states that the code should be open for extension but closed for modification.

// This means that a class should be easily extendable without modifying the class itself.

class Invoice {
    private double amount;
    public Invoice(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void generateInvoice() {
        System.out.println("Invoice amount: " + amount);
    }

    public void applyDiscount() {
        System.out.println("Discount applied");
    }
}

// Above class is not following open close principle because if we want to add a new type of invoice, we have to modify the Invoice class.
// Extending the Code: Why It Doesn’t Follow OCP

class InvoiceCopy {
    private double amount;
    public InvoiceCopy(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    // Adding new logic for international invoices
    public void generateInvoice(String type) {
        if (type.equals("INTERNATIONAL")) {
            System.out.println("International Invoice amount: " + amount);
        } else {
            System.out.println("Invoice amount: " + amount);
        }
        System.out.println("Invoice amount: " + amount);
    }

    public void applyDiscount() {
        System.out.println("Discount applied");
    }
}

// Refactoring the Code to Follow OCP

// To follow the open close principle, we can refactor the code by creating an Invoice interface and implementing it in the Invoice class.
// We can then create a new class, InternationalInvoice, that extends the Invoice class and implements the generateInvoice method for international invoices.

interface InvoiceGenerator {
    void generateInvoice(double amount);
}

class BasicInvoice implements InvoiceGenerator {
    @Override
     public void generateInvoice(double amount) {
        System.out.println("Invoice amount: " + amount);
    }
}

class InternationalInvoice extends BasicInvoice {
    @Override
    public void generateInvoice(double amount) {
        System.out.println("International Invoice amount: " + amount);
    }
}

class InvoiceFinal {
    private double amount;
    private InvoiceGenerator invoiceGenerator;

    public InvoiceFinal(double amount, InvoiceGenerator invoiceGenerator) {
        this.amount = amount;
        this.invoiceGenerator = invoiceGenerator;
    }

    public void generateInvoice() {
        invoiceGenerator.generateInvoice(amount);
    }

    public void applyDiscount() {
        System.out.println("Discount applied");
    }
}

// How does this follow the open close principle?

// The InvoiceGenerator interface is open for extension, as we can create new classes that implement the interface.

class DetailedInvoice implements InvoiceGenerator {
    @Override
    public void generateInvoice(double amount) {
        System.out.println("Generating detailed invoice with breakdown for amount: " + amount);
    }
}