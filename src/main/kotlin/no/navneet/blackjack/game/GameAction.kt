package no.navneet.blackjack.game

import no.navneet.blackjack.entity.Deck
import no.navneet.blackjack.entity.Player

object GameAction {
    fun giveCardToPlayer(deck: Deck, player: Player) {
        deck.drawCard()?.let {
            player.deck.addCard(it)
        }
    }


    fun actionsDuringSamTurn(sam: Player, deck: Deck) {
        while (sam.deck.score() < 17) {
            giveCardToPlayer(deck, sam)
        }
    }

    fun actionsDuringDealerTurn(sam: Player, dealer: Player, deck: Deck) {
        while (dealer.deck.score() <= sam.deck.score()) {
            giveCardToPlayer(deck, dealer)
        }
    }


}