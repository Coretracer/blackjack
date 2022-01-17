package no.navneet.blackjack.game

import no.navneet.blackjack.entity.Deck
import no.navneet.blackjack.entity.Player
import no.navneet.blackjack.entity.Result

object Executor {
    fun executeGame(deck: Deck?): Result.Finished {
        val sam = Player("Sam")
        val dealer = Player("Dealer")
        val game = deck
            ?.let { Game(sam, dealer, it) }
            ?: Game(sam, dealer)
        val result = game.play() as Result.Finished
        return result
    }
}