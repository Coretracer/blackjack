package no.navneet.blackjack

import no.navneet.blackjack.entity.Deck
import no.navneet.blackjack.game.Executor
import no.navneet.blackjack.input.CardReader
import no.navneet.blackjack.stub.CardString
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class IntegrationTest {
    @Test
    fun `Integration test - with input string - must run`(){
        val cards = CardReader().createCardsFromString(CardString.sampleCardString)
        assertThat(cards.size).isEqualTo(52)
    }

    @Test
    fun `Integration test - with input string - match output`(){
        val cards = CardReader().createCardsFromString(CardString.sampleCardString)
        val deck = Deck(cards)
        val expectedOutput = """
            [Sam]
            Sam: C3, SJ, S8
            Dealer: H9, SK, HJ
        """.trimIndent()

        val result = Executor.executeGame(deck)
        assertThat((result.getFormattedOutput())).isEqualTo(expectedOutput)
    }
}