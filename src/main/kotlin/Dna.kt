class Dna(private val sequence: String) {

    init {
        require(sequence.all { it in "ACGT" }) {
            "Invalid DNA sequence: $sequence"
        }
    }

    // Count occurrences of each valid nucleotide
    val nucleotideCounts: Map<Char, Int>
        get() = mapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0)
            .mapValues { (nucleotide, _) -> sequence.count { it == nucleotide } }
}