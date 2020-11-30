import kotlin.math.sqrt

fun main(args: Array<String>) {

    val readerBeforeAuthor = if ("reader".compareTo("author") < 0) true else false
    //val readerBeforeAuthor = "reader".compareTo("author") < 0
    println(readerBeforeAuthor)

    val reader = "Justin"
    val author = "Abc"
    val readerIsAuthor = if(reader.equals(author)) true else false
    //val readerIsAuthor = reader.equals(author)
    println(readerIsAuthor)


    val myAge = 27
    when (myAge) {
        in 13..19 -> println("Teenager")
        else -> println("not a teenager")
    }

    var p = 0
    var v = 1
    while(p < 10) {
        println("2 to power of $p : $v")
        v *= 2
        p += 1
    }

    println(calcDays("february", 2020))

    println(fact(4))

    //range [x, y]
    for (i in 1..5) //12345
        print("$i")
    println()


    //half open range [x, y)
    for (i in 1 until 5) //1234
        print("$i")
    println()

    for (i in 1..2) {
        print("%.2f ".format(sqrt(i.toDouble())))
        //print("${sqrt(i.toDouble())}")
    }
    println()

    repeat(1) {
        index -> print("$index ")
    }
    println()

    val age = 20
    when(age) {
        in 0..2 -> println("infant")
        in 3..12 -> println("child")
        in 13..19 -> println("teenager")
        in 20..39 -> println("adult")
        in 40..60 -> println("middle aged")
        else -> println("elderly")
    }

    val name_age = "Justin" to 27
    val (n, a) = name_age
    when(a) {
        in 0..2 -> println("$n is an infant")
        in 3..12 -> println("$n is a child")
        in 13..19 -> println("$n is a teenager")
        in 20..39 -> println("$n is an adult")
        in 40..60 -> println("$n is middle aged")
        else -> println("$n is elderly")
    }


}

fun calcDays (mon: String, year: Int) : Int {
    when(mon.toLowerCase()) {

        "february" -> {
            return if ((year % 4 == 0) && (year % 100 != 0)) 29 else 28
        }

        "january", "march", "may", "july", "august", "october", "december"
            -> return 31

    }
    return 30
}

fun fact(n : Int) : Int {
    var f = 1
    var it = 0
    while (it < n) {
        it += 1
        f *= it
    }
    return f

}