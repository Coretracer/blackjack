package no.navneet.blackjack.entity

import no.navneet.blackjack.entity.Deck.Companion.newDeckWithAllCards
import no.navneet.blackjack.stub.DeckStub.deckWithThisTopCard
import no.navneet.blackjack.stub.DeckStub.emptyDeck
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DeckTest {

    private val arbitraryCard: Card = Card.C3

    @Test
    fun `drawCard - non empty deck - should get top card`(){
        val deck = deckWithThisTopCard(arbitraryCard)

        val topCard = deck.drawCard()!!

        assertThat(topCard).isEqualTo(arbitraryCard)
    }

    @Test
    fun `drawCard - empty deck - should get empty result`(){
        val deck = emptyDeck()

        val topCard = deck.drawCard()

        assertThat(topCard).isNull()
    }

    @Test
    fun `addCard - add arbitrary card - deck should should have this card`(){
        val deck = emptyDeck()

        deck.addCard(arbitraryCard)

        assertThat(deck.drawCard()).isEqualTo(arbitraryCard)
    }

    @Test
    fun `score - deck with all cards - deck should should have this card`(){
        val deck = newDeckWithAllCards()

        val sumOfScoreOfAllCards = deck.score()

        assertThat(sumOfScoreOfAllCards).isEqualTo(SUM_OF_SCORE_OF_ALL_CARDS)
    }

    @Test
    fun `newDeckWithAllCards - deck with all cards - must contains all cards`(){
        val allCards = Card.values()

        val deck = newDeckWithAllCards()

        assertThat(deck.cards).containsAll(allCards.asIterable())
    }


    companion object{
        private const val SUM_OF_SCORE_OF_ALL_CARDS = 380
    }
}