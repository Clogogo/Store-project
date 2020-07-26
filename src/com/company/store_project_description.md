Object-oriented programming

Final project 2020

You have to write a java solution for a store.
Part 1
The solution needs to have at least following features:
◦ Item: Name, ID (incremental ID by 1 for each product),
Price.
◦ Store Basket: ID (incremental ID by 1 for each
basket), Net Amount, Total Amount, VAT, List of items, Date and Time of purchase, Address of the store, name of cashier.
◦ Cashier: Name, Surname, Username and Password (insert from code five fixed cashiers).
◦ Manager: Name, Surname, Username and Password (insert from code one fixed manager).
The program must:
 Present a Menu for the cashier after he has logged in with
username and password.
 Menu should be available in 2 languages. Menu:
◦ New Basket
◦ Insert item in basket
◦
◦
◦
◦
Remove item from basket
Print information for basket with a certain ID
Apply discount to basket with 10% for Christmas promotion Exit
Extend four classes: Item, StoreBasket, Store, Cashier.
For the classes Item and StoreBasket make sure you use a static int field for the incremental ID of the objects of these classes. Introduce inheritance in the project design with the following:
There are several types of items:
a. Items with discount which have an additional feature called Discount. The discount amount should be inserted periodically by the manager.
b.Items which have an additional feature more than ItemWithDiscount called DiscountIndependence. Let the manager define the amount of DiscountIndependence. The overall discount is calculated as Discount + DiscountIndependence.
c. Items in offer which has an additional feature more than Item called BuyMorePayLess. Let the manager define this feature. For example if you buy three you pay two or if you buy five you pay three. (Hint: use two parameters for this). The maximum that one customer can buy of this item is 10 items.
 
d. So called ItemTakeItAll, which has an additional feature more than ItemWithDiscount which is N, the minimum number of items to be purchased. (Ex. N=5 or N=10) with the lowered price. The number N should be defined by the manager.
Define the following methods in all the above classes:
a. calculateDiscount( ) : Calculates the discount for each of these classes
b. printInfo( ): Prints all the information of the Item
There are different types of store baskets:
a.Basket for loyal customers, for old customers, with an additional feature which is the accumulation of points for the customer. 5 Euro count for 1 point bonus.
b. Basket for employees which is reserved to Employees of the market. Each of these baskets has an additional feature that accumulates points for the employee. 15 Euro count for a bonus of 1point.
User, Cashier, Customer classes:
The class User has: Name Surname, ID, Username, Password, Address, PhoneNumber
Classes inheriting from User:
a. Cashier: has an additional feature called InternalPhoneNumber
b. Manager: has an additional feature more than the user called InternalPhoneNumber, PIN to start the software at the beginning of the day. Every manager has his own PIN to start the software. The start can be made after the login.
Cashier class
a. Cashier has these fields: baseSalary and hoursOfWork.
b. hoursOfWork is calculated based on the first login time and the last logout time of the day.
c. Bonus is calculated as follows: for every hour overtime a bonus of 10 euro is given (8 hours is the normal work time).
Customer class
A customer is a User. There are these types of customers:
a. Simple customer: no bonus!
b. Loyal customer: The customer gets a bonus for every basket corresponding to the type of customer. For each amount of 100 points, the customer gets a bonus of 10 Euro for future purchases.
    
c. Employee as a customer: The customer gets a bonus for every basket corresponding to the type of customer. For 100 bonus points, they get a bonus in their salary of 50 Euro.
Define the following methods in all the above customer classes:
a. calculateBonus( ): Calculates the bonus for each of these classes
b. printInfo( ): Prints all the information of the specific user
Part 2
1. Define a Payable interface and make the classes for baskets and internal employees implement this interface by defining a method that calculates the payment to be done.
2. Handle input correctness and check the validity of the input types, strings, int, etc with exceptions.
3. Use ArrayList within the Store class to keep all the StoreBaskets being currently served. Use ArrayList within the Store class to keep all the StoreBaskets that have been already served and paid. Use ArrayList within StoreBasket to keep all the items of the basket. Handle all operations polymorphically. Use Streams with lambda expressions.
4. Update menu if needed to call the methods implemented in this project.
5. Bonus : create additional functionality to get 5 bonus points.
Defence process and grading:
You can gain 30 (+ 5 bonus) points for the successful defence.
Each student defends the project individually, each defence takes 12-15 minutes. Book your time slot in Doodle (April, 1st, 9:00- 13:45). The link will be sent on the 31st of March.
Home tasks, lab assignments, tests are graded < 36 points – Final project solution is not needed. 0 for the course. See you in September!
Solution is not submitted in Moodle by the deadline defined in Moodle. 0 for the course. See you in September!
There are 2 or more similar solutions submitted in Moodle by different students– all team members get 0 for the course. See you in September!
It is submitted and even works! – congratulation, you can come to defend it – 1 point is guaranteed.
 
Solution does not correspond to the principles of Object-Oriented Programming – minus 29 points.
Code style does not correspond to the Coding conventions – minus 5 points.
One business rule (discount rate, condition, customer type, etc) is not taken into account, not implemented – minus 5 points.
Solution has unhandled errors/ exceptions – minus 5 points. Solution is not localized – minus 5 points.
Solution is graded < 16 points – 0 for the course. See you in September!
5 theoretical questions will be asked (based on the tests, you have successfully passed) – minus 2 points for each incorrectly answered question.
All questions regarding this project can be asked in Moodle Forum. E-mails and personal messages in Moodle or other social networks will be ignored.
Home reading:
Internationalization and Localization in Java 8 https://www.baeldung.com/java-8-localization
Java Timer https://www.journaldev.com/1050/java-timer-timertask-example
Java Localization – Formatting Messages https://www.baeldung.com/java-localization-messages-formatting Coding conventions https://en.wikibooks.org/wiki/Java_Programming/Coding_conventions https://www.oracle.com/technetwork/java/codeconvtoc-136057.html
        