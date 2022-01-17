package no.navneet.blackjack

import no.navneet.blackjack.entity.Player
import no.navneet.blackjack.entity.Result
import no.navneet.blackjack.game.Game
import no.navneet.blackjack.input.CardReader

fun main(args: Array<String>) {
    val cardReader = CardReader()
    val deck = cardReader.createDeck(args)
    val sam = Player("Sam")
    val dealer = Player("Dealer")
    val game = deck
        ?.let { Game(sam, dealer, it) }
        ?: Game(sam, dealer)
    val result= game.play() as Result.Finished
    println(result.getFormattedOutput())
}