# Week 10 — Part C Concept Questions

## Question 1 — String immutability and performance
In Java a `String` object cannot be changed after creation; every "modification" (concatenation, `replace`, `toUpperCase`, …) creates a new `String` object and leaves the original unchanged. This makes strings thread-safe, cacheable in the String pool, and safe as keys in hash-based collections. The cost appears when a string is modified repeatedly (e.g. in a loop): each step allocates a new object and copies characters, giving roughly O(n²) time and lots of garbage. The impact is mitigated by using a mutable builder, `StringBuilder` (or `StringBuffer` when thread-safety is needed), which modifies one internal buffer in place using `append()`, `insert()` and `reverse()`, and calling `toString()` once at the end.

## Question 2 — `this` keyword and name shadowing
When a constructor parameter has the same name as an instance variable, the parameter **shadows** the field inside the constructor, so a plain `name = name;` just assigns the parameter to itself. `this` refers to the current object, so `this.name` unambiguously means the instance variable and `name` means the parameter. Example:
```java
class Student {
    String name;
    Student(String name) { this.name = name; } // field = parameter
}
```
`this(...)` can also call another constructor of the same class, as in `Student() { this("Unknown", "Not assigned"); }`, avoiding duplicated initialisation code.

## Question 3 — Object vs reference variable
An **object** is the actual instance created with `new` and stored on the heap, holding the data. A **reference variable** is a variable (on the stack) that stores the address/handle of an object, not the object itself. When one reference is assigned to another (`Wallet w2 = w1;`), no new object is created. Only the reference is copied, so both variables point to the **same** object. Changes made through either variable (e.g. `w2.add(200)`) are visible through the other, and the object remains alive until no references to it remain, at which point it is eligible for garbage collection.

## Question 4 — Static vs instance variables
An **instance variable** belongs to each object, so every object has its own copy and its own state. A **static variable** belongs to the class and is shared by all objects, existing once regardless of how many instances are created. Use a static variable for data that is common to the whole class, for example a `visitorCount` that is incremented in every `Visitor` constructor to track the total number of visitors. Use an instance variable for data that differs per object, for example the `name` of each `Visitor` or the `balance` of each `Wallet`, since each object needs its own independent value.

## Question 5 — `for` vs `while` vs `do-while`
- **for**: best when the number of iterations is known in advance; initialisation, condition and update sit on one line. Example: iterating over an array by index or printing 1 to 10.
- **while**: best when the number of iterations is unknown and the condition should be checked *before* the first run, possibly executing zero times. Example: reading input until end of file, or extracting digits while `n > 0`.
- **do-while**: best when the body must execute **at least once** and the condition is checked afterwards. Example: showing a menu and repeating until the user chooses "Exit", or re-prompting until valid input is entered.

## Question 6 — Pass-by-value
Java is always pass-by-value: a method receives a **copy** of the argument. For a **primitive**, the copy is the value itself, so changes inside the method do not affect the caller's variable (`change(int n) { n = 10; }` leaves `x` as 5). For an **object**, the copy is the value of the *reference*, so the method and the caller refer to the same object. The method can therefore modify the object's state (e.g. `list.add(...)`, `wallet.add(...)`) and the caller will see it, but reassigning the parameter to a new object (`p = new Wallet(0)`) does not change the caller's reference.

## Question 7 — Integer division and type casting
When both operands are integers, Java performs integer division and discards the fractional part (truncating toward zero): `7 / 2` is `3`, not `3.5`. If a precise result is needed, at least one operand must be a floating-point type *before* the division happens. An explicit cast, such as `(double) total / count`, converts one operand first so the division is done in floating point. Writing `(double) (total / count)` is wrong because the truncation has already occurred. In the quiz example, `total / count` with `double count` gives `83.33333333333333`.

## Question 8 — Encapsulation
Encapsulation bundles data and the methods that operate on it into one class and restricts direct access to that data. In Java, fields are declared `private` so outside code cannot read or modify them directly. Access is provided through public **getters** (controlled reading) and **setters** (controlled writing), and setters can validate input, for example rejecting a negative balance or marks above 100. This keeps objects in a valid state, lets the internal representation change without breaking other code, and makes it easier to maintain and debug since all changes go through known methods.

## Question 9 — `==` vs `equals()`
For objects, `==` compares **references**, i.e. whether both variables point to the same object in memory. `equals()` is intended to compare **logical content**. By default `Object.equals()` behaves like `==`, but classes such as `String` override it to compare contents. For example, `new String("hello") == new String("hello")` is `false`, while `.equals()` returns `true`. Overriding `equals()` in your own class (e.g. comparing `id` or `name`) lets two different objects with equal data be treated as equal. When doing so, `hashCode()` should also be overridden to keep hash-based collections consistent.

## Question 10 — Overloading vs overriding
**Overloading** means several methods in the same class share a name but differ in parameter lists; it is resolved at **compile time** (static polymorphism). **Overriding** means a subclass provides its own implementation of a method inherited from its superclass with the same signature; it is resolved at **run time** based on the actual object type (dynamic polymorphism).
```java
// Overloading
int add(int a, int b)       { return a + b; }
double add(double a, double b) { return a + b; }

// Overriding
class Payment { void pay(double amt) { System.out.println("Paid " + amt); } }
class Card extends Payment {
    @Override void pay(double amt) { System.out.println("Paid " + (amt * 1.02) + " by card"); }
}
Payment p = new Card();
p.pay(500); // Card's version runs at run time
```
