import java.util.*

package Excersise2

//С установкой начальных значений в конструкторе, закрытыми полями и методами чтения значений. Проверяйте значение suit – в случае ошибки выводите на экран соответствующее сообщение.
class Card constructor(_rank: Int, _suit: String) {
    private var rank: Int = 0
    private lateinit var suit: String

    enum class Ranks constructor(val value: Int) {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13),
        ACE(14), JOCKER(15)
    }

    enum class Suits(val value: Int) {
        CLUBS(0), DIAMONDS(1), SPADES(2), HEARTS(3)
    }

    init {
        try {
            if (IsRankValid(_rank))
                rank = _rank
            else throw ExceptionInInitializerError("Not valid rank!")
            if (IsSuitValid(_suit))
                suit = _suit
            else throw ExceptionInInitializerError("Not valid suit!")
        } catch (e: ExceptionInInitializerError) {
            System.out.println(e.message)
        }
    }

    private fun IsSuitValid(suit: String?): Boolean {
        for (s in Suits.values()) {
            if (suit!!.equals(s.name)) return true
        }
        return false
    }

    private fun IsRankValid(rank: Int) = ((rank > 2) && (rank <= 15))

    override fun toString() = "Rank:\t${GetRankString()} \tSuit:\t ${this.suit}"

    override fun equals(obj: Any?): Boolean {
        try {
            val card = obj as Card?
            return rank == card!!.rank && suit!!.equals(card.suit)
        } catch (e: Exception) {
            System.out.println(e.message)
        }
        return false
    }

    override fun hashCode() = rank + suit!!.hashCode()

    private fun GetRankString(): String {
        for (r in Ranks.values())
            if (r.value == rank)
                return r.name
        return "NotARank"
    }

    fun IsCardFromStandartDeck(): Boolean {
        return try {
            rank <= 15 && rank > 1 && IsSuitValid(suit)
        } catch (e: Exception) {
            false
        }
    }

    fun IsStrongerThan(card: Card): Boolean {
        return try {
            if (suit == card.suit) rank > card.rank else throw Exception(
                    "Can`t compare strength of cards with different suits!\t" + suit + " & " + card.suit)
        } catch (e: Exception) {
            System.out.println(e.message)
            false
        }
    }

    fun Compare(card: Card): Int {
        return try {
            val firstCardI = GetSuitIndex(suit)
            val secondCardI = GetSuitIndex(card.suit)
            if (firstCardI > secondCardI) return 1 else if (firstCardI < secondCardI) return -1
            0
        } catch (e: Exception) {
            System.out.println(e.message)
            -1025635
        }
    }

    private fun GetSuitIndex(suit: String?): Int {
        try {
            for (s in Suits.values())
                if (suit.uppercase() == s.name) return s.value
            throw Exception("No such suit exists:\t$suit")
        } catch (e: Throwable) {
            throw e
            return -1
        }
    }

    fun Compare(firstCard: Card, secondCard: Card) = firstCard.Compare(secondCard)
}