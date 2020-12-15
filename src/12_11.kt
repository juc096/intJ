class Address {
    var name : String = ""
    var street : String = ""
    var city : String = ""
        //get () = this.toString()
        set (value) {
            field = " $value + lols"
        }
    /*val lazyVal : String by lazy {
        it -> "$it + lazycat"
    }*/
}

fun copyAddress(address: Address) : Address {
    val copy = Address()
    copy.name = address.name
    copy.street = address.street
    copy.city = address.city
    return copy
}

fun main() {
    var a = Address()
    a.city = "cat"
    a.street = "amazing street"
    println(a.street)
    println(a.city)
}
