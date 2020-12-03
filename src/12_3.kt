fun removeOne(item: Int, list: List<Int>): List<Int> {
    return list.minus(item)
}

fun remove(item: Int, list: List<Int>): List<Int> {
    return list.filter{ it != item }
}

fun reverse(list: List<Int>): MutableList<Int> {
    var r_list = mutableListOf<Int>()

    for (i in (list.size - 1) downTo 0) {
        r_list.add(list[i])
    }

    return r_list

}

fun minMax(numbers: Array<Int>) : Pair<Int, Int> {
    var min = numbers.first()
    for (n in numbers) min = if(n < min) n else min

    var max = numbers.first()
    for (n in numbers) max = if(n > max) n else max

    return Pair(min, max)
}
fun isInvertible(map : Map<String, Int>) : Boolean {
    return map.values.size == map.values.toSet().size
}
fun mergeMaps(map1: Map <String, String>, map2: Map<String, String>) : Map<String, String> {
    return map1 + map2
}

fun lambdaPractice() {
    val nameList = listOf("mary","berry","cherry","sherry")
    println(nameList.fold("", {total, name -> total + name}))
    val namesAndAges = mapOf("mary" to 60, "berry" to 50, "cherry" to 40, "sherry" to 5)
    println(namesAndAges.filter{it.value < 18})
    println(namesAndAges.filter{it.value > 18}.keys.toList())
}
fun main(args: Array<String>) {
    val l = listOf(1,2,3,3,4)
    val f1 : Map<String, Int> = mapOf("one" to 1, "two" to 2, "three" to 3)
    val f2 = mapOf("one" to 1, "two" to 1, "three" to 3)
    val m1 = mapOf("1" to "2", "3" to "4", "5" to "6")
    val m2 = mapOf("1" to "11", "2" to "22", "3" to "33", "7" to "77")
    println(removeOne(3, l))
    println(remove(3, l))
    println(reverse(l))
    println(minMax(l.toTypedArray()))
    println("Map: f1 is ${if(isInvertible(f1)) "is" else "not"} invertible")
    println("Map: f1 is ${if(isInvertible(f2)) "is" else "not"} invertible")
    println(mergeMaps(m1, m2))
    lambdaPractice()
}