package no.navneet.blackjack.stub

import no.navneet.blackjack.entity.Card

object CardStub {
    fun cardsWithCollectiveValueEqualsTo17():MutableList<Card>{
        return  mutableListOf(Card.C10, Card.C7)
    }

    fun cardsWithCollectiveValueMoreThan17():MutableList<Card>{
        return  mutableListOf(Card.C10, Card.C9)
    }

    fun cardsWithCollectiveValueMoreThan21():MutableList<Card>{
        return  mutableListOf(Card.C10, Card.C9, Card.D10)
    }

    fun cardsWithCollectiveValueEqualsTo22():MutableList<Card>{
        return  mutableListOf(Card.C10, Card.C2, Card.D10)
    }

    fun blackJackCards():MutableList<Card>{
        return  mutableListOf(Card.C10, Card.CA)
    }

    fun cardsWithCollectiveValueEqualsTo21():MutableList<Card>{
        return  mutableListOf(Card.C10, Card.CA)
    }
}