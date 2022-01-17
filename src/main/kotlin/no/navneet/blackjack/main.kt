package no.navneet.blackjack

import no.navneet.blackjack.game.Executor.executeGame
import no.navneet.blackjack.input.CardReader

fun main(args: Array<String>) {
    val cardReader = CardReader()
    val deck = cardReader.createDeck(args)
    val result = executeGame(deck)
    println(result.getFormattedOutput())
}