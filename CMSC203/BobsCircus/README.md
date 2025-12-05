# Bob’s Circus Management System – CMSC203 Assignment 6

A menu-driven, command-line application that models the operations of Bob’s Circus using object-oriented programming principles. The project demonstrates inheritance, interfaces, aggregation, polymorphism, exception handling, sorting, searching, and dynamic data management using ArrayLists.

## Features
- Add and manage **Animals**, **Persons**, and **Buildings**
- Generate **tickets** with weekday discounts, customer-type discounts, and seat-location pricing
- Sort animals by **age** or **name**
- Search animals by **name**
- Display all animals, persons, and buildings in the system
- Fully menu-driven command-line interface

## OOP Concepts Demonstrated
- **Inheritance** (`Clerk`, `Acrobatic` extend `Person`)
- **Interfaces** (`Animal`, `Building`)
- **Polymorphism**
- **Aggregation** via the `Circus` manager class
- **Method overriding**
- **Exception handling**
- **Selection sort**
- **Searching ArrayLists**

## src/
Contains the full implementation:
- `CircusDriverApp.java`
- `Circus.java`
- `Ticket.java`
- `Clerk.java`
- `Acrobatic.java`
- `Dog.java`
- `Horse.java`
- `Bird.java`
- `Lion.java`
- `Arena.java`
- `TicketingOffice.java`
- `CustomInputMismatchException.java`
- `DayOfWeek.java`

## dist/
Standalone console executable:
- `BobsCircus.exe` (Launch4j-wrapped)

## How to Run
### Windows (EXE)
1. Navigate to the `dist/` folder.
2. Double-click **BobsCircus.exe**.
3. The console window will display the menu.