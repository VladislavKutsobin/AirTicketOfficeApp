# Example Air ticket office application
=========================================
### Task
implement a console ticket office application for searching/buying tickets, that has the following entities:
* Flight;
* Passenger;
* Ticket.

As a data store is used text files: flights.csv, passengers.csv, tickets.csv.

The user can add, delete, search flights by params or see all flights. Also, user can add, delete, see all information
about passengers.
What about tickets. After adding user information to passengers.csv, user can buy ticket, or if ticket was bought
earlier you can return your ticket.

##### Layers:

* model - POJO classes;
* repository - classes that implement access to csv files and have implementation methods;
* controller - processing requests from the user;
* view - all data necessary for working with the console.

----
For run application you should use AppRunner file.