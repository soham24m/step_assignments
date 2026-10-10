# Week 9 — Part B Quiz (Abstraction, Abstract Class vs Interface)

| Q | Answer | Why |
|---|--------|-----|
| 1 | **C** | Abstraction hides *how* an operation works and exposes only *what* it does. |
| 2 | **C** | An abstract class cannot be instantiated directly (it need not have abstract methods, and Java allows only single class inheritance). |
| 3 | **B** | A concrete subclass must implement all inherited abstract methods, otherwise it must itself be declared `abstract` or compilation fails. |
| 4 | **C** | `private` is illegal for abstract methods because a private method cannot be overridden by a subclass. |
| 5 | **C** | Interface fields are implicitly `public static final`. |
| 6 | **C** | A class can implement any number of interfaces. |
| 7 | **D** | Interface methods are implicitly `public`, so implementations must be `public`. |
| 8 | **C** | Interfaces carry no instance state, which avoids the diamond-problem ambiguity of conflicting inherited data. |
| 9 | **D** | Conflicting default methods cause a compile-time error until the class overrides the method. |
| 10 | **B** | Abstract classes can have constructors, which run (via `super()`) when a subclass object is created. |
