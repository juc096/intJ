import kotlin.test.assertFalse
import kotlin.test.assertTrue

enum class DayOfTheWeek {
    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
    companion object {
        fun getDay(i : Int) : DayOfTheWeek {
            return DayOfTheWeek.values()[i]
        }
        fun getDay(str : String) : DayOfTheWeek {
            return DayOfTheWeek.valueOf(str)
        }
    }
}

sealed class AcceptedCurrency {
    abstract val number : Float
    abstract val scale : Float
}

data class Currency1(override val number : Float , override val scale : Float = 1.toFloat()) : AcceptedCurrency()
data class Currency2(override val number : Float , override val scale : Float = 4.toFloat()) : AcceptedCurrency()

data class Dollar(override val number : Float , override val scale : Float = 1.toFloat()) : AcceptedCurrency()
data class Penny(override val number : Float , override val scale : Float = 100.toFloat()) : AcceptedCurrency()
data class Nickel(override val number : Float , override val scale : Float = 20.toFloat()) : AcceptedCurrency()
data class Dime(override val number : Float , override val scale : Float = 10.toFloat()) : AcceptedCurrency()
data class Quarter(override val number : Float , override val scale : Float = 4.toFloat()) : AcceptedCurrency()

/*
    extension function to convert another currency to the same type as the calling object, factoring in exchange rate
 */
inline fun AcceptedCurrency.convert(aCur : AcceptedCurrency) : Float {
    return (this.scale/aCur.scale) * aCur.number
}
/*
    overload the plus operator to do currency sum
    in cases where currencies are not the same, we use the exchange rate (i.e. scale)
    return value is the same currency as the left operand (e.g. penny + dollar -> penny)
 */
operator fun AcceptedCurrency.plus(aCur : AcceptedCurrency) : AcceptedCurrency {
    when(this) {
        is Currency1 -> return Currency1(number + convert(aCur))
        is Currency2 -> return Currency2(number + convert(aCur))
        is Dollar -> return Dollar(number + convert(aCur))
        is Penny -> return Penny(number + convert(aCur))
        is Nickel -> return Nickel(number + convert(aCur))
        is Dime -> return Dime(number + convert(aCur))
        is Quarter -> return Quarter(number + convert(aCur))
    }
}
/*
    overload the compareTo operator so we can compare sealed class's objects to each other
 */
operator fun AcceptedCurrency.compareTo(aCur: AcceptedCurrency) : Int {
    return number.compareTo(convert(aCur))
}

fun AcceptedCurrency.print() { //override toString instead of this
    println("amount: $number, scale: $scale")
}
/*
    check if wallet content (i.e. list of AcceptedCurrency) is enough to purchase item of given price
 */
fun canAfford(price : Dollar, wallet : List<AcceptedCurrency>) : Boolean {
    var total : AcceptedCurrency = Penny(0.toFloat())
    for (i in wallet)
        total = total + i
    return price < total
}

fun main() {

    println(DayOfTheWeek.getDay(3))
    println(DayOfTheWeek.getDay("Monday"))

    val c = Currency1(4.toFloat())
    val c2 = Currency2(16.toFloat())
    println((c+c2).print())
    println((c2+c).print())

    var price : Dollar = Dollar(4.2.toFloat())
    val curList : List<AcceptedCurrency> = listOf(Penny(100.toFloat()),Nickel(20.toFloat()),Quarter(4.toFloat()), Dime(11.toFloat()))
    //curList holds $4.10 sum in scale to the dollar

    assertFalse{canAfford(price, curList)} //4.2 > 4.1; can't afford

    price = Dollar(2.toFloat())
    assertTrue{canAfford(price, curList)} //2.0 > 4.1; can afford



}