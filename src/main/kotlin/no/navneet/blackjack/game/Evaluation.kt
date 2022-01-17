package no.navneet.blackjack.game

import no.navneet.blackjack.entity.Player

object Evaluation {
    private const val MAX_SCORE_TO_BE_IN_GAME = 21

    //document tie breaker
    fun getWinnerBasedOnScore(sam: Player, dealer: Player): Player {
        return when (dealer.deck.score() > sam.deck.score()) {
            true -> dealer
            false -> sam
        }
    }

    fun getWinnerIfPlayerScoreAboveLimit(player1: Player, player2: Player): Player? {
        return when (player1.deck.score() > MAX_SCORE_TO_BE_IN_GAME) {
            true -> player2
            else -> null
        }
    }

    fun doesBothPlayerHave22Score(player1: Player, player2: Player): Boolean {
        return player1.deck.score() == 22 && player2.deck.score() == 22
    }


    fun whoHasBlackJack(player1: Player, player2: Player): Player? {
        return if (player1.hasBlackJack()) {
            player1
        } else if (player2.hasBlackJack()) {
            player2
        } else {
            null
        }
    }
}