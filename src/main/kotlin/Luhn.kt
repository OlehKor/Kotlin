object Luhn {
    fun isValid(candidate: String): Boolean =
        candidate.filterNot { it == ' ' }  // Step 1: Remove all spaces
            .takeIf { it.length > 1 && it.all(Char::isDigit) }  // Step 2: Validate the input
            ?.reversed()  // Reverse string
            ?.mapIndexed { index, c ->
                c.digitToInt().let {
                    if (index % 2 == 1) (it * 2).let { d -> if (d > 9) d - 9 else d }
                    else it
                }
            }  // Step 3: Luhn transformation
            ?.sum()  // Sum the transformed digits
            ?.rem(10) == 0  // Step 4: Check divisibility by 10
}