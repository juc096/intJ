
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

}