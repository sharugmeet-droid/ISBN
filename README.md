# ISBN Verifier – Kotlin

This Kotlin program validates **ISBN-10 numbers** for books.  
It checks for the **correct format** and **check digits** to ensure the ISBN is valid.

---

## How It Works

1. Remove all **hyphens and spaces** from the input.
2. Ensure the cleaned string is **10 characters long**.
3. Calculate the **weighted sum** for the first 9 digits:
   - Multiply each digit by its **position weight** (10 down to 2)
4. Check the **10th digit** (check digit):
   - Can be a digit (0-9) or `'X'` (represents 10)
5. The ISBN is valid if the **sum modulo 11** equals 0.

---

## Example Usage

```kotlin
val isbn = "0-306-40615-2"
println(isValidISBN10(isbn)) // Output: true
