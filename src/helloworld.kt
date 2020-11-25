const val compileTimeConstant = 20
const val myAge = 27
fun main(args: Array<String>) {
    println("hello world!")
    var num = 10

    println(num)
    val ex : Example = Example()
    ex.print_val()

    var averageAge : Double = (myAge + 30)/2.0
    var testNumber = 49
    val evenOdd = testNumber
    print_num(testNumber, evenOdd)
    testNumber = 30
    print_num(testNumber, evenOdd)

    var answer = 0
    answer++
    answer += 10
    answer *= 10
    answer = answer shr 3
    println(answer)

    var x = 3.4.toInt()


    //strings
    var st_big = """hi
        |this
        |is
        |a
        |long
        |stringt
    """

    //pairs
    var z = Pair(1,2)
    var z_1 = 1 to 2
    var z_2 : Pair<Int, Int> = Pair<Int, Int>(1,2)

    //"Any" type
    //All types are "Any" in kotlin
    // similar to Java's "Object" class

    //Unit type
    //"Void" in java

    //Nothing type

    val coordinates = 2 to 3
    val row = coordinates.first
    val column = coordinates.second

    val mdy = Triple(11, 25 , 2020)
    val month = mdy.first
    val day = mdy.second
    val year = mdy.third

    val fullName = "Justin Chen"
    val myDetails = "Hello, my name is $fullName"
}

fun print_num(a: Int, b: Int) {
    println("$a $b")

}
class Example {
    fun print_val() {
        println(compileTimeConstant)
    }
}