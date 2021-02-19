fun main(args: Array<String>) {
    print(splitInteger(11, 4))
    print(splitInteger(11,3))
    print(splitInteger(7,3))
}
fun splitInteger(num: Int, parts: Int) : ArrayList<Int> {
    var equalParts = ArrayList<Int>()
    var divisor = parts
    var sum = num
    while (sum != 0) {
        var element = sum / divisor
        equalParts.add(element)
        sum -= element
        divisor--

    }
    return equalParts
}