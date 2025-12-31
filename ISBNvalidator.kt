fun isValidISBN10(isbn: String): Boolean {
    val cleaned = isbn.replace("-", "").replace(" ", "")
    if (cleaned.length != 10) return false

    var sum = 0
    for (i in 0 until 9) {
        val c = cleaned[i]
        if (!c.isDigit()) return false
        sum += (c - '0') * (10 - i)
    }

    // Check digit can be 'X' representing 10
    val lastChar = cleaned[9]
    sum += when {
        lastChar == 'X' || lastChar == 'x' -> 10
        lastChar.isDigit() -> lastChar - '0'
        else -> return false
    }

    return sum % 11 == 0
}

fun main() {
    val isbnList = listOf(
        "0-306-40615-2",
        "0-321-14653-0",
        "0-123-45678-9",
        "0-8044-2957-X",
        "123456789X"
    )

    for (isbn in isbnList) {
        println("ISBN: $isbn -> ${if (isValidISBN10(isbn)) "Valid" else "Invalid"}")
    }
}
