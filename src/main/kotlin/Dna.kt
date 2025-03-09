class Dna(private val sequence: String) {

    init {
        if (!isValid(sequence)) {
            throw IllegalArgumentException("Invalid DNA sequence: $sequence")
        }
    }

    // Count occurrences of each valid nucleotide
    val nucleotideCounts: Map<Char, Int>
        get() {
            val counts = mutableMapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0)

            for (nucleotide in sequence) {
                counts[nucleotide] = counts[nucleotide]!! + 1
            }

            return counts.toMap() // Return an immutable map
        }

    private fun isValid(sequence: String): Boolean {
        return sequence.all { it in "ACGT" }
    }
}