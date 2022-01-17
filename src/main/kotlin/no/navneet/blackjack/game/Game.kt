package no.navneet.blackjack.game

import no.navneet.blackjack.entity.Deck
import no.navneet.blackjack.entity.Player
import no.navneet.blackjack.entity.Result
import no.navneet.blackjack.entity.Result.Finished
import no.navneet.blackjack.entity.Result.Unfinished
import no.navneet.blackjack.game.Evaluation.doesBothPlayerHave22Score
import no.navneet.blackjack.game.Evaluation.getWinnerBasedOnScore
import no.navneet.blackjack.game.Evaluation.getWinnerIfPlayerScoreAboveLimit
import no.navneet.blackjack.game.Evaluation.whoHasBlackJack
import no.navneet.blackjack.game.GameAction.actionsDuringDealerTurn
import no.navneet.blackjack.game.GameAction.actionsDuringSamTurn
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Game(
    val sam: Player,
    val dealer: Player,
    private val deck: Deck = Deck.newDeckWithAllCards()
) {

    private var result: Result = Unfinished

    init {
        GameAction.giveCardToPlayer(deck, sam)
        GameAction.giveCardToPlayer(deck, dealer)
        GameAction.giveCardToPlayer(deck, sam)
        GameAction.giveCardToPlayer(deck, dealer)
        logger.debug("Game initialized, sam has ${sam.deck.cards} cards, dealer has ${dealer.deck.cards} cards")
        result = checkResult()
        logger.debug("Result after first serve ${result.javaClass}")
    }

    private fun checkResult(): Result {

        val playerWithBlackJack = whoHasBlackJack(sam, dealer)

        return if (playerWithBlackJack != null) {
            Finished(playerWithBlackJack.name, sam, dealer)
        } else if (doesBothPlayerHave22Score(sam, dealer)) {
            Finished(dealer.name, sam, dealer)
        } else {
            Unfinished
        }
    }

    fun play(): Result {
        result = playAndGetResult()
        logger.debug("final result \n ${(result as Finished).getFormattedOutput()}")
        return result
    }

    fun playAndGetResult(): Result {
        if (result is Finished) {
            return result
        }

        actionsDuringSamTurn(sam, deck)
        getWinnerIfPlayerScoreAboveLimit(sam, dealer)
            ?.let {
                return Finished(it.name, sam, dealer)
            }

        actionsDuringDealerTurn(sam, dealer, deck)
        getWinnerIfPlayerScoreAboveLimit(dealer, sam)?.let {
            return Finished(it.name, sam, dealer)
        }

        val winner = getWinnerBasedOnScore(sam, dealer)
        return Finished(winner.name, sam, dealer)
    }

    fun getResult(): Result {
        return result
    }


    companion object {
        val logger: Logger = LoggerFactory.getLogger(Game::class.java)
    }
}

