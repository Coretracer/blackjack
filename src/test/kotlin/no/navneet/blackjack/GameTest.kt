package no.navneet.blackjack

import no.navneet.blackjack.entity.Player
import no.navneet.blackjack.entity.Result
import no.navneet.blackjack.game.Game
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GameTest {

    @Test
    fun testGame(){
        val sam = Player("sam")
        val dealer = Player("dealer")
        val game = Game(sam,dealer)
        val result = game.play()
        assertThat(result).isInstanceOf(Result.Finished::class.java)
    }
}