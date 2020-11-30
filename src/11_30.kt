
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