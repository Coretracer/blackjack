package no.navneet.blackjack.game

import no.navneet.blackjack.stub.DeckStub
import no.navneet.blackjack.stub.DeckStub.deckThatGiveSamBlackJack
import no.navneet.blackjack.stub.DeckStub.deckWhereSamScoreHigherThanDealer
import no.navneet.blackjack.stub.DeckStub.deckWhereSamScoreLessThan21AndDealerScoreMoreThan21
import no.navneet.blackjack.stub.DeckStub.deckWhereSamScoreLowerThanDealer
import no.navneet.blackjack.stub.DeckStub.deckWhereSamScoreMoreThan21
import no.navneet.blackjack.stub.PlayerStub.playerDealer
import no.navneet.blackjack.stub.PlayerStub.playerSam

object GameStub {
    fun gameWhereSamWinsWithFirstTwoCard():Game{
        val deck = deckThatGiveSamBlackJack()
        return Game(playerSam(),playerDealer(),deck )
    }

    fun gameWhereSamScoreMoreThan21():Game{
        val deck = deckWhereSamScoreMoreThan21()
        return Game(playerSam(),playerDealer(), deck)
    }


    fun gameWhereSamScoreLessThan21AndDealerScoreMoreThan21():Game{
        val deck = deckWhereSamScoreLessThan21AndDealerScoreMoreThan21()
        return Game(playerSam(),playerDealer(), deck)
    }


    fun gameWhereSamScoreHigherThanDealer():Game{
        val deck = deckWhereSamScoreHigherThanDealer()
        return Game(playerSam(),playerDealer(), deck)
    }

    fun gameWhereSamScoreLowerThanDealer():Game{
        val deck = deckWhereSamScoreLowerThanDealer()
        return Game(playerSam(),playerDealer(), deck)
    }
}