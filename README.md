College Canteen Smart Order Processing System
Overview

This project simulates a real-world college canteen using Java multithreading. It models how multiple activities such as order placement, food preparation, payment processing, and notifications occur simultaneously. The system demonstrates how concurrency improves efficiency and responsiveness in everyday environments.

Objective

The objective of this project is to apply core multithreading concepts in Java, including thread creation, synchronization, inter-thread communication, and thread prioritization, to represent a practical real-life system.

Features
Concurrent execution of multiple threads
Synchronized access to a shared resource (OrderQueue)
Inter-thread communication using wait() and notify()
Simulation of real-time delays using sleep()
Use of thread priorities to manage critical operations
System Components
Threads
OrderThread: Responsible for placing food orders into the system
ChefThread: Retrieves and prepares orders (assigned high priority)
PaymentThread: Simulates payment processing
NotificationThread: Sends periodic updates to users (assigned low priority)
Shared Resource
OrderQueue
A common data structure that stores incoming orders. Since multiple threads access it, synchronization is applied to ensure safe and consistent operations.
Inter-Thread Communication
The ChefThread waits when there are no orders available using wait()
The OrderThread notifies the ChefThread using notify() when a new order is placed
Technologies Used
Java
Multithreading concepts (Thread class, synchronization, wait/notify)
Visual Studio Code
How to Run
Compile the program
javac CanteenSystem.java
Run the program
java CanteenSystem
Sample Output
OrderThread placed: Burger
ChefThread preparing: Burger
PaymentThread processing payment...
NotificationThread sending pickup notification...
Key Concepts Demonstrated
Thread creation using the Thread class
Setting thread names using setName()
Assigning priorities using setPriority()
Synchronization using synchronized methods
Inter-thread communication using wait() and notify()
Simulating execution delays using sleep()
Limitations
Does not fully capture real-world unpredictability such as human decisions or dynamic priorities
Runs continuously due to infinite loops in some threads
Limited to console-based output without a graphical interface
Future Enhancements
Introduce multiple chef threads for better scalability
Implement a graphical user interface using JavaFX or Swing
Integrate a database for persistent order storage
Add priority-based order handling for urgent requests
Author

Samuthrika Shree S