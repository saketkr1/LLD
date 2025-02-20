public class DIP {
}

/*
5. Dependency Inversion Principle (DIP)
- High-level modules should not depend on low-level modules. Both should depend on abstractions.
- Abstractions should not depend on details. Details should depend on abstractions.
 */

class EmailService {
    public void sendEmail(String message, String receiver) {
        // Code to send email
        System.out.println("Email sent to " + receiver + " with Message=" + message);
    }
}

class NotificationService {
    private EmailService emailService;

    public NotificationService() {
        emailService = new EmailService();
    }

    public void send(String message, String receiver) {
        emailService.sendEmail(message, receiver);
    }
}

/*
In this design, the NotificationService is tightly coupled to EmailService, violating DIP.
If we want to use a different service for notifications, we would need to modify the NotificationService class directly.

Why This Violates DIP?
Tight Coupling: ThThe NotificationService class is directly dependent on the EmailService class, which is a low-level module.
This violates the Dependency Inversion Principle because high-level modules should not depend on low-level modules.
*/

// Refactoring Code to Follow DIP

interface NotificationSender {
  void send(String message, String receiver);
}


// EmailService that implements NotificationSender
class EmailServiceCopy implements NotificationSender {
    @Override
    public void send(String message, String receiver) {
        System.out.println("Sending email: " + message);
    }
}

// SMSService that implements NotificationSender
class SMSService implements NotificationSender {
    @Override
    public void send(String message, String receiver) {
        System.out.println("Sending SMS: " + message);
    }
}

// NotificationService depends on NotificationSender interface
class NotificationServiceCopy {
    private NotificationSender notificationSender;

    // Constructor takes a NotificationSender, allowing for flexibility
    public NotificationServiceCopy(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    public void send(String message) {
        notificationSender.send(message, "");
    }
}
