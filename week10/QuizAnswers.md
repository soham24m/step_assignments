# Week 10 — Part B Quiz

| Q | Answer | Why |
|---|--------|-----|
| 1 | **D** | `==` compares references (two separate `new String` objects → false); `equals()` compares content → true. |
| 2 | **B** | `"Java Lab"` reversed is `"baL avaJ"`. |
| 3 | **B** | `new Student("Ravi")` matches the one-argument constructor directly (which then chains via `this(...)`). |
| 4 | **D** | `w1` and `w2` reference the same object, so both show 700. |
| 5 | **C** | `count` is shared (static); three objects were created, so 3. |
| 6 | **A** | The loop prints every element: `45 78 92 60 85`. |
| 7 | **B** | `continue` skips `i == 3`: `1 2 4 5`. |
| 8 | **A** | Java is pass-by-value; `x` stays 5. |
| 9 | **C** | `250 / 3.0` = `83.33333333333333`. |
| 10 | **B** | Polymorphism: `Card.pay(500)` → 500 + 10 = `Paid 510.0 by card`. |
| 11 | **B** | Strings are immutable; `name` stays `"java"` and a new `"JAVA"` object is created. |
| 12 | **B** | `s1`/`s2` share one pooled object; `new String("hello")` creates a second → 2 objects. |
| 13 | **A** | `"Campus".length()` = 6; `charAt(2)` = `m`. |
| 14 | **A** | In `user@domain.com`, `@` is at index 4. |
| 15 | **B** | The default constructor sets title to `"Unknown"` and price to `0.0`. |
| 16 | **A** | Output: `Title: Java Programming, Price: 450.0`. |
| 17 | **B** | `w1`/`w2` share one object, `w3` is another → 2 objects. |
| 18 | **C** | Both references see the same object: 700 and 700. |
| 19 | **C** | Only `s1`'s object changes: `s1 name: Anu`, `s2 name: Ravi`. |
| 20 | **C** | Static counter incremented three times → `Total visitors: 3`. |
