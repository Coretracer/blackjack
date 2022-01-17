package no.navneet.blackjack.stub

import no.navneet.blackjack.entity.Deck
import no.navneet.blackjack.entity.Player
import no.navneet.blackjack.stub.CardStub.blackJackCards
import no.navneet.blackjack.stub.CardStub.cardsWithCollectiveValueEqualsTo17
import no.navneet.blackjack.stub.CardStub.cardsWithCollectiveValueEqualsTo22
import no.navneet.blackjack.stub.CardStub.cardsWithCollectiveValueMoreThan17
import no.navneet.blackjack.stub.CardStub.cardsWithCollectiveValueMoreThan21

object PlayerStub {

    fun playerSam():Player{
        return Player("Sam")
    }

    fun playerDealer():Player{
        return Player("Dealer")
    }

    fun samWithCardsValuesEqualTo17():Player{
       return Player("Sam", Deck(cardsWithCollectiveValueEqualsTo17()))
    }

    fun samWithCardsValuesMoreThan17():Player{
        return Player("Sam", Deck(cardsWithCollectiveValueMoreThan17()))
    }

    fun samWithCardsValuesMoreThan22():Player{
        return Player("Sam", Deck(cardsWithCollectiveValueEqualsTo22()))
    }

    fun dealerWithCardsValuesMoreThan17():Player{
        return Player("Dealer", Deck(cardsWithCollectiveValueMoreThan17()))
    }

    fun dealerWithCardsValuesEqualsTo17():Player{
        return Player("Dealer", Deck(cardsWithCollectiveValueEqualsTo17()))
    }

    fun dealerWithCardsValuesMoreThan21():Player{
        return Player("Dealer", Deck(cardsWithCollectiveValueMoreThan21()))
    }

    fun dealerWithCardsValuesMoreThan22():Player{
        return Player("Dealer", Deck(cardsWithCollectiveValueEqualsTo22()))
    }

    fun playerWithBlackJackCards(name:String):Player{
        return Player(name, Deck(blackJackCards()))
    }
    fun playerWithoutBlackJackCards(name:String):Player{
        return Player(name, Deck(cardsWithCollectiveValueEqualsTo17()))
    }

}