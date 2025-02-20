public class SRP {
}

// Solid Principles

// 1. Single Responsibility Principle
// The Single Responsibility Principle states that a class should have only one reason to change, meaning that a class should have only one job.
// In the context of the Parking Lot system, the ParkingLot class should be responsible for managing parking spots, parking floors, and parking displays.
// The ParkingSpot class should be responsible for managing parking spots, and the ParkingDisplayBoard class should be responsible for managing parking displays.
// The ParkingAttendant class should be responsible for processing tickets.
// The Admin class should be responsible for managing parking floors, parking spots, parking displays, and customer info panels.
// The Account class should be responsible for managing user accounts.

// Example


// Problem in below code
// The UserManager class has multiple responsibilities, such as adding users, removing users, writing user data to the database, and reading user data from the database.
class UserManager {
    public void addUser() {
        // Logic to add a user
    }
    public void removeUser() {
        // Logic to remove a user
    }
    public void writeToDatabase() {
        // Logic to write user data to the database
    }

    public void readFromDatabase() {
        // Logic to read user data from the database
    }
}

/* Solution to above problem
The UserManager class should be split into two classes: UserManager and DatabaseManager.
The UserManager class should be responsible for adding and removing users, while the DatabaseManager class should be responsible for reading and writing user data to the database.
*/
class UserManager1  {
    public void addUser()
    {
        // Logic to add a user
    }

    public void removeUser()
    {
        // Logic to remove a user
    }
}

class DatabaseManager {
    public void writeToDatabase()
    {
        // Logic to write user data to the database
    }

    public void readFromDatabase()
    {
        // Logic to read user data from the database
    }
}

/* Points to remember
 SRP: Focuses on ensuring that a class has only one reason to change.
 Cohesion: Refers to how closely related and focused the responsibilities of a class are.
 Coupling: Refers to how dependent a class is on other classes.
 */

