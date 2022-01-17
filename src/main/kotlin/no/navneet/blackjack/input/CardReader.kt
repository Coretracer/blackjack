package no.navneet.blackjack.input

import no.navneet.blackjack.entity.Card
import no.navneet.blackjack.entity.Deck
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

class CardReader() {

    fun createDeck(args: Array<String>): Deck? {
        return if (args.isNotEmpty()) {
            val filename = args[0]
            logger.debug("Input file name $filename")

            val cardString = readFile(args[0])
            logger.debug("Card string $cardString")

            val cards = createCardsFromString(cardString)
            return Deck(cards)
        } else {
            null
        }
    }

    fun createCardsFromString(cardString: String): MutableList<Card> {
        return cardString
            .split(",")
            .toList()
            .map { Card.valueOf(it.trim()) }
            .toMutableList()
    }


    private fun readFile(fileName: String): String {
        return File(fileName).readText(Charsets.UTF_8)
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(CardReader::class.java)
    }
}