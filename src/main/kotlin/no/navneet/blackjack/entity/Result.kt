package no.navneet.blackjack.entity

sealed class Result {
    object Unfinished : Result()
    class Finished(val winnerName: String, private val player1: Player, private val player2: Player) : Result() {
        fun getFormattedOutput(): String {
            return """
                [${winnerName}]
                ${player1.name}: ${player1.deck.cards.toString().replace("[", "").replace("]", "")}
                ${player2.name}: ${player2.deck.cards.toString().replace("[", "").replace("]", "")}
            """.trimIndent()
        }
    }
}
