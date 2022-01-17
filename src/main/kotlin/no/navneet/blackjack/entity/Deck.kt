package no.navneet.blackjack.entity

data class Deck(
    val cards: MutableList<Card> = ArrayList()
) {
    fun drawCard(): Card? {
        return cards.removeLastOrNull()
    }

    fun addCard(card: Card): Deck {
        cards.add(card)
        return this
    }

    fun score(): Int {
        return cards.sumOf { it.value }
    }

    companion object {
        fun newDeckWithAllCards(): Deck {
            return Deck(
                Card.values()
                    .toList()
                    .shuffled()
                    .toMutableList()
            )
        }
    }
}