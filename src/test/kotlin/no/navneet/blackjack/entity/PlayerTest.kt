package no.navneet.blackjack.entity

import no.navneet.blackjack.stub.DeckStub.deckWithAllCardAndTopCardsEqualTo17
import no.navneet.blackjack.stub.DeckStub.deckWithCollectiveValueEqualsTo21
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PlayerTest {

    @Test
    fun `hasBlackJack - deck has score 21 - expect blackjack true`(){
        val player = Player("arbitrary Name", deckWithCollectiveValueEqualsTo21())

        val result = player.hasBlackJack()

        assertThat(result).isTrue
    }

    @Test
    fun `hasBlackJack - deck does not have score 21 - expect blackjack false`(){
        val player = Player("arbitrary Name", deckWithAllCardAndTopCardsEqualTo17())

        val result = player.hasBlackJack()

        assertThat(result).isFalse

    }

}