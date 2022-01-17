package no.navneet.blackjack

import no.navneet.blackjack.input.CardReader
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class IntegrationTest {
    @Test
    fun `Integration test - with input string - must run`(){
        val cardString = " C2, D9, C4, H3, S5, C9, C7, DK, S9, H2, H6, CA, C5, D4, CK, C6, D3, D2, HA, DA, DQ, D8, S6, H7, HQ, H5, S10, H4, S2, CQ, S7, CJ, H10, C8, D10, S3, C10, D5, H8, HK, S4, SA, D6, SQ, D7, DJ, HJ, S8, SK, SJ, H9, C3"
        val cards = CardReader().createCardsFromString(cardString)
        assertThat(cards.size).isEqualTo(52)
    }
}