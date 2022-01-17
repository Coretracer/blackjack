package no.navneet.blackjack.game

import no.navneet.blackjack.entity.Card
import no.navneet.blackjack.stub.DeckStub.deckWithThisTopCard
import no.navneet.blackjack.stub.DeckStub.deckWithAllCardAndTopCardsEqualTo17
import no.navneet.blackjack.stub.DeckStub.deckWithAllCardAndTopCardsMoreThan17
import no.navneet.blackjack.stub.DeckStub.emptyDeck
import no.navneet.blackjack.stub.PlayerStub.playerDealer
import no.navneet.blackjack.stub.PlayerStub.playerSam
import no.navneet.blackjack.stub.PlayerStub.samWithCardsValuesEqualTo17
import no.navneet.blackjack.stub.PlayerStub.samWithCardsValuesMoreThan17
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GameActionTest {

    private val arbitraryCard: Card = Card.C3

    @Test
    fun `giveCardToPlayer - With non empty deck - Card should now be owned by player()`() {
        val deck = deckWithThisTopCard(arbitraryCard)
        val sam = playerSam()

        GameAction.giveCardToPlayer(deck, sam)

        assertThat(deck.cards).doesNotContain(arbitraryCard)
        assertThat(sam.deck.cards).contains(arbitraryCard)
    }

    @Test
    fun `giveCardToPlayer - With empty deck - Player should not have additional card()`() {
        val deck = emptyDeck()
        val sam = playerSam()

        GameAction.giveCardToPlayer(deck, sam)

        assertThat(deck.cards).isEmpty()
        assertThat(sam.deck.cards).isEmpty()
    }

    @Test
    fun `actionsDuringSamTurn - Deck contains top cards greater than 17 - Sam cards value greater than 17`() {
        val deck = deckWithAllCardAndTopCardsMoreThan17()
        val sam = playerSam()

        GameAction.actionsDuringSamTurn(sam, deck)

        assertThat(sam.deck.score()).isGreaterThan(17)
    }

    @Test
    fun `actionsDuringSamTurn - Deck contains top cards equals to 17 - Sam cards value equals to 17`() {
        val deck = deckWithAllCardAndTopCardsEqualTo17()
        val sam = playerSam()

        GameAction.actionsDuringSamTurn(sam, deck)

        assertThat(sam.deck.score()).isEqualTo(17)
    }

    @Test
    fun `actionsDuringDealerTurn - Sam with cards values 17 - Dealer should have cards more than 17`() {
        val deck = deckWithAllCardAndTopCardsEqualTo17()
        val sam = samWithCardsValuesEqualTo17()
        val dealer = playerDealer()

        GameAction.actionsDuringDealerTurn(sam, dealer, deck)

        assertThat(dealer.deck.score()).isGreaterThan(17)
    }
    @Test
    fun `actionsDuringDealerTurn - Sam with cards values greater than 17 - Dealer should have cards greater than 17`() {
        val deck = deckWithAllCardAndTopCardsEqualTo17()
        val sam = samWithCardsValuesMoreThan17()
        val dealer = playerDealer()

        GameAction.actionsDuringDealerTurn(sam, dealer,  deck)

        assertThat(dealer.deck.score()).isGreaterThan(17)
    }

}