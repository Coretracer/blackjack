package no.navneet.blackjack.entity

class Player(val name: String, val deck: Deck = Deck()) {
    fun hasBlackJack(): Boolean {
        return deck.score() == 21
    }
}