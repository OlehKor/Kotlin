import kotlin.random.Random
import kotlin.math.floor

class DndCharacter {

    val strength: Int by lazy(::ability)
    val dexterity: Int by lazy(::ability)
    val constitution: Int by lazy(::ability)
    val intelligence: Int by lazy(::ability)
    val wisdom: Int by lazy(::ability)
    val charisma: Int by lazy(::ability)
    val hitpoints: Int by lazy { 10 + modifier(constitution) }

    companion object {

        fun ability(): Int = List(4) { Random.nextInt(1, 7) }
            .sortedDescending()
            .take(3)
            .sum()

        fun modifier(score: Int): Int = floor((score - 10) / 2.0).toInt()
    }
}