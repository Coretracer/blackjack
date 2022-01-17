package no.navneet.blackjack.entity

import no.navneet.blackjack.stub.PlayerStub.dealerWithCardsValuesEqualsTo17
import no.navneet.blackjack.stub.PlayerStub.samWithCardsValuesEqualTo17
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ResultOutputFormatTest {

    @Test
    fun `getFormattedOutput - both player has cards - valid output`() {

        val expectedOutput = """
            [sam]
            Sam: C10, C7
            Dealer: C10, C7
        """.trimIndent()

        val formattedResultString = Result.Finished(
            "sam",
            samWithCardsValuesEqualTo17(),
            dealerWithCardsValuesEqualsTo17()
        ).getFormattedOutput()

        assertThat(formattedResultString).isEqualTo(expectedOutput)
    }
}