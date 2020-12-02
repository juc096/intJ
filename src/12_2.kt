import java.lang.NullPointerException

fun printFullName(firstname: String, lastname: String) : Unit {
    println("$firstname $lastname")
}
fun calculateFullName(firstname: String, lastname: String) : Pair<String, Int> {
    val temp = "$firstname $lastname"
    return Pair(temp, temp.length-1)
}
tailrec fun fibo(n : Int) : Int {
    if (n <= 2)
        return 1
    return fibo(n-2) + fibo(n-1)
}
fun add(n: Int, m: Int) : Int {
    return n + m
}
fun sub(n: Int, m: Int) : Int {
    return n - m
}

fun arithmeticOp(n: Int, m: Int, op: (Int, Int) -> Int) : Int {
    return op(n,m)
}

fun main(args: Array<String>) {

    printFullName("Justin", "Chen")

    val myName_length = calculateFullName("Justin", "Chen")
    println("Name: ${myName_length.first} Length: ${myName_length.second}")

    println(fibo(12))

    //arithmetic operation function expects a functional type
    //use method reference operator
    println(arithmeticOp(1, 2, ::add))
    println(arithmeticOp(1, 2, ::sub))

    val myFavoriteSong : String? = null
    //val myFavoriteSong : String? = "jinglebells"

    try {
        println(myFavoriteSong!!.length)
    }
    catch (e : NullPointerException) {
        println("Null song value")
    }

    println("Str length: ${myFavoriteSong?.length ?: "Null song value"}")

    println(myFavoriteSong ?: "I don't have a favorite song.")



}