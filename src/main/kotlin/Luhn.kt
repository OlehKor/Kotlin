object Luhn {

    fun isValid(candidate: String): Boolean {
        // Step 1: Remove all spaces
        val sanitized = candidate.replace(" ", "")

        // Step 2: Validate the input
        if (sanitized.length <= 1 || !sanitized.all { it.isDigit() }) return false

        // Step 3: Apply Luhn Algorithm
        val sum = sanitized.reversed()
            .mapIndexed { index, char ->
                val digit = char.digitToInt()

                // Double every second digit from the right
                if (index % 2 == 1) {
                    val doubled = digit * 2
                    if (doubled > 9) doubled - 9 else doubled
                } else {
                    digit
                }
            }
            .sum()

        // Step 4: Check divisibility by 10
        return sum % 10 == 0
    }
}