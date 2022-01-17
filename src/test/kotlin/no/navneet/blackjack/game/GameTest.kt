package no.navneet.blackjack.game

import no.navneet.blackjack.entity.Result
import no.navneet.blackjack.game.GameStub.gameWhereSamScoreHigherThanDealer
import no.navneet.blackjack.game.GameStub.gameWhereSamScoreLessThan21AndDealerScoreMoreThan21
import no.navneet.blackjack.game.GameStub.gameWhereSamScoreLowerThanDealer
import no.navneet.blackjack.game.GameStub.gameWhereSamScoreMoreThan21
import no.navneet.blackjack.game.GameStub.gameWhereSamWinsWithFirstTwoCard
import no.navneet.blackjack.stub.DeckStub.deckThatDoesNotGiveBlackJackToAnyone
import no.navneet.blackjack.stub.DeckStub.deckThatGiveSamAndDealerBlackJack
import no.navneet.blackjack.stub.DeckStub.deckThatGiveSamBlackJack
import no.navneet.blackjack.stub.DeckStub.deckThatGiveSamDealerBlackJack
import no.navneet.blackjack.stub.PlayerStub.playerDealer
import no.navneet.blackjack.stub.PlayerStub.playerSam
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GameTest {

    @Test
    fun `checkResult - deck that gives sam blackJack - Sam should win `() {
        val sam = playerSam()
        val dealer = playerDealer()
        val deck = deckThatGiveSamBlackJack()

        val game = Game(sam, dealer, deck)

        assertThat((game.getResult() as Result.Finished).winnerName).isEqualTo(sam.name)
    }

    @Test
    fun `checkResult - deck that gives dealer blackJack - Dealer should win `() {
        val sam = playerSam()
        val dealer = playerDealer()
        val deck = deckThatGiveSamDealerBlackJack()

        val game = Game(sam, dealer, deck)

        assertThat((game.getResult() as Result.Finished).winnerName).isEqualTo(dealer.name)
    }

    @Test
    fun `checkResult - both has blackjack - Sam should win `() {
        val sam = playerSam()
        val dealer = playerDealer()
        val deck = deckThatGiveSamAndDealerBlackJack()

        val game = Game(sam, dealer, deck)

        assertThat((game.getResult() as Result.Finished).winnerName).isEqualTo(sam.name)
    }

    @Test
    fun `checkResult - both does not have blackjack - game should be unfinished `() {
        val sam = playerSam()
        val dealer = playerDealer()
        val deck = deckThatDoesNotGiveBlackJackToAnyone()

        val game = Game(sam, dealer, deck)

        assertThat(game.getResult()).isInstanceOf(Result.Unfinished::class.java)
    }

    @Test
    fun `play - Finished game - should result Finished result`(){
        val game = gameWhereSamWinsWithFirstTwoCard()

        game.play()

        assertThat(game.getResult()).isInstanceOf(Result.Finished::class.java)
    }

    @Test
    fun `play - Game with Sam score above limit (21) - Dealer should win`(){
        val game = gameWhereSamScoreMoreThan21()

        game.play()

        assertThat((game.getResult() as Result.Finished).winnerName).isEqualTo(game.dealer.name)
    }

    @Test
    fun `play - Game where Dealer cross limit but not Sam - Dealer should win`(){
        val game = gameWhereSamScoreLessThan21AndDealerScoreMoreThan21()

        game.play()

        assertThat((game.getResult() as Result.Finished).winnerName).isEqualTo(game.sam.name)
    }

    @Test
    fun `play - Game where Sam has higher score than dealer and both are within upper limit - Sam should win`(){
        val game = gameWhereSamScoreHigherThanDealer()

        game.play()

        assertThat((game.getResult() as Result.Finished).winnerName).isEqualTo(game.sam.name)
    }

    @Test
    fun `play - Game where Sam has lower score than dealer and both are within upper limit - Dealer should win`(){
        val game = gameWhereSamScoreLowerThanDealer()

        game.play()

        assertThat((game.getResult() as Result.Finished).winnerName).isEqualTo(game.dealer.name)
    }
}