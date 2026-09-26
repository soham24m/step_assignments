# Week 8 — Inheritance & Polymorphism (Category C)

Each Java file is self-contained and reads the problem input from standard input. The examples use a shared interface for each domain and distinct concrete classes for the type-specific rules, so transaction, loan, delivery, grading, and fare calculations can be performed through polymorphic calls.

Compile all solutions with:

```bash
javac week8/*.java -d out
```

Then run one solution, for example:

```bash
java -cp out PaymentSystemFeeCalculation
```

## Delivery sample discrepancy

`DeliveryFeeCalculator` follows the written business rules. For the supplied sample, those formulas produce `EXPRESS: 24.00`, `INTERNATIONAL: 145.00`, and `Total: 184.00`; the PDF's printed values (29.00, 155.00, and 199.00) do not match the stated formulas.
