package no.navneet.blackjack.stub

import no.navneet.blackjack.entity.Card
import no.navneet.blackjack.entity.Deck
import no.navneet.blackjack.stub.CardStub.cardsWithCollectiveValueEqualsTo17
import no.navneet.blackjack.stub.CardStub.cardsWithCollectiveValueMoreThan17

object DeckStub {

    fun emptyDeck(): Deck {
        return Deck()
    }

    fun deckWithThisTopCard(arbitraryCard: Card): Deck {
        return deckWithTheseCardInTop(listOf(arbitraryCard))
    }


    fun deckWithAllCardAndTopCardsMoreThan17(): Deck {
        val cards = cardsWithCollectiveValueMoreThan17()
        return deckWithTheseCardInTop(cards)
    }

    fun deckWithAllCardAndTopCardsEqualTo17(): Deck {
        val cards = cardsWithCollectiveValueEqualsTo17()
        return deckWithTheseCardInTop(cards)
    }


    fun deckWithCollectiveValueEqualsTo21(): Deck {
        return Deck(CardStub.cardsWithCollectiveValueEqualsTo21())
    }

    fun deckWhereSamScoreMoreThan21(): Deck {
        val cards = listOf(Card.CA, Card.C5, Card.C9, Card.D2, Card.C2)
        return deckWithTheseCardInTop(cards)
    }

   fun deckWhereSamScoreLessThan21AndDealerScoreMoreThan21(): Deck {
        val cards = listOf(Card.DA, Card.C8, Card.D9, Card.C9, Card.D2, Card.C2)
        return deckWithTheseCardInTop(cards)
    }

    fun deckWhereSamScoreHigherThanDealer(): Deck {
        val cards = listOf(Card.D8, Card.H9, Card.D9, Card.C9, Card.D2, Card.C2)
        return deckWithTheseCardInTop(cards)
    }

    fun deckWhereSamScoreLowerThanDealer(): Deck {
        val cards = listOf(Card.H9, Card.C8, Card.D9, Card.C9, Card.D2, Card.C2)
        return deckWithTheseCardInTop(cards)
    }


    fun deckThatGiveSamBlackJack():Deck{
        val cards = listOf(Card.C5, Card.C10, Card.D2, Card.CA)
        return deckWithTheseCardInTop(cards)
    }

    fun deckThatDoesNotGiveBlackJackToAnyone():Deck{
        val cards = listOf(Card.C5, Card.C9, Card.D2, Card.C2)
        return deckWithTheseCardInTop(cards)
    }

    fun deckThatGiveSamDealerBlackJack():Deck{
        val cards = listOf( Card.C10,Card.C5,Card.CA, Card.D2)
        return deckWithTheseCardInTop(cards)
    }

    fun deckThatGiveSamAndDealerBlackJack():Deck{
        val cards = listOf( Card.C10,Card.D10,Card.CA, Card.DA)
        return deckWithTheseCardInTop(cards)
    }

    private fun deckWithTheseCardInTop(cards: List<Card>): Deck {
        val deck = Deck.newDeckWithAllCards()
        removeTheseCardFromDeck(deck, cards)
        addTheseCardOnTopOfTheDeck(deck, cards)
        return deck
    }

    private fun removeTheseCardFromDeck(deck: Deck, cards: List<Card>) {
        cards.forEach {
            deck.cards.remove(it)
        }
    }

    private fun addTheseCardOnTopOfTheDeck(deck: Deck, cards: List<Card>) {
        cards.forEach {
            deck.cards.add(it)
        }
    }

}