package no.navneet.blackjack.game

import no.navneet.blackjack.entity.Result
import no.navneet.blackjack.game.Evaluation.doesBothPlayerHave22Score
import no.navneet.blackjack.game.Evaluation.getWinnerBasedOnScore
import no.navneet.blackjack.game.Evaluation.getWinnerIfPlayerScoreAboveLimit
import no.navneet.blackjack.game.Evaluation.whoHasBlackJack
import no.navneet.blackjack.stub.PlayerStub.dealerWithCardsValuesEqualsTo17
import no.navneet.blackjack.stub.PlayerStub.dealerWithCardsValuesMoreThan17
import no.navneet.blackjack.stub.PlayerStub.dealerWithCardsValuesMoreThan21
import no.navneet.blackjack.stub.PlayerStub.dealerWithCardsValuesMoreThan22
import no.navneet.blackjack.stub.PlayerStub.playerWithBlackJackCards
import no.navneet.blackjack.stub.PlayerStub.playerWithoutBlackJackCards
import no.navneet.blackjack.stub.PlayerStub.samWithCardsValuesEqualTo17
import no.navneet.blackjack.stub.PlayerStub.samWithCardsValuesMoreThan17
import no.navneet.blackjack.stub.PlayerStub.samWithCardsValuesMoreThan22
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class EvaluationTest {
    @Test
    fun `getWinnerBasedOnScore - Sams score more than Dealer - Sam should win`() {
        val sam = samWithCardsValuesMoreThan17()
        val dealer = dealerWithCardsValuesEqualsTo17()

        val winner = getWinnerBasedOnScore(sam, dealer)

        assertThat(winner).isEqualTo(sam)
    }

    @Test
    fun `getWinnerBasedOnScore - Sams score less than Dealer - Dealer should win`() {
        val sam = samWithCardsValuesEqualTo17()
        val dealer = dealerWithCardsValuesMoreThan17()

        val winner = getWinnerBasedOnScore(sam, dealer)

        assertThat(winner).isEqualTo(dealer)
    }

    @Test
    fun `getWinnerIfPlayerScoreAboveLimit - Dealer score more than upper limit (21) - Sam should win`() {
        val sam = samWithCardsValuesEqualTo17()
        val dealer = dealerWithCardsValuesMoreThan21()

        val result = getWinnerIfPlayerScoreAboveLimit(dealer, sam)

        assertThat(result!!.name).isEqualTo(sam.name)
    }

    @Test
    fun `getWinnerIfPlayerScoreAboveLimit - Dealer score less than upper limit (21) - Result should be null`() {
        val sam = samWithCardsValuesEqualTo17()
        val dealer = dealerWithCardsValuesEqualsTo17()

        val result = getWinnerIfPlayerScoreAboveLimit(dealer, sam)

        assertThat(result).isNull()
    }

    @Test
    fun `doesBothPlayerHave22Score - Both has score 22 - Expect true`() {
        val sam = samWithCardsValuesMoreThan22()
        val dealer = dealerWithCardsValuesMoreThan22()

        val result = doesBothPlayerHave22Score(dealer, sam)

        assertThat(result).isTrue
    }

    @Test
    fun `doesBothPlayerHave22Score - One of the player does not have score 22 - Expect false`() {
        val sam = samWithCardsValuesEqualTo17()
        val dealer = dealerWithCardsValuesMoreThan22()

        val result = doesBothPlayerHave22Score(dealer, sam)

        assertThat(result).isFalse
    }


    @Test
    fun `whoHasBlackJack - Player1 has blackJack - Player1 Should win`() {
        val player1 = playerWithBlackJackCards("player1")
        val player2 = playerWithoutBlackJackCards("player2")

        val result = whoHasBlackJack(player1, player2)

        assertThat(result).isEqualTo(player1)
    }

    @Test
    fun `whoHasBlackJack - Player1 does not have blackjack but player2 has - Player2 Should win`() {
        val player1 = playerWithoutBlackJackCards("player1")
        val player2 = playerWithBlackJackCards("player2")

        val result = whoHasBlackJack(player1, player2)

        assertThat(result).isEqualTo(player2)
    }

    @Test
    fun `whoHasBlackJack - both player does not have blackjack - no one should win`() {
        val player1 = playerWithoutBlackJackCards("player1")
        val player2 = playerWithoutBlackJackCards("player2")

        val result = whoHasBlackJack(player1, player2)

        assertThat(result).isNull()
    }
}