data class Person(val name: String)

fun memberOf(person: Person, group: Array<Person>) : (Person) -> Boolean = {group.contains(person)}

class User (val name: String) {
    var ml : MovieList = MovieList()

    fun addUser(user : User) {ml.add(user)}

    fun printMovieList() {ml.print()}

    fun modAndPrint(temp_ml : MovieList) {
        temp_ml.add(User("$name adding : \" scoobydooby \""))
        temp_ml.print()
    }

    override fun toString(): String {
        return name
    }
}
class MovieList {
    var l : MutableList<User> = mutableListOf()

    fun add(user: User) {l.add(user)}

    fun print() {println(l)}
}

object Threshold {
    val limit = 20
    fun isAboveThreshold(value: Int) : Boolean {return value > limit}
}

interface ThresholdChecker {
    val lower : Int
    val upper : Int
    fun isLit(value : Int) : Boolean
    fun tooQuite(value : Int) : Boolean
}
fun main() {
    val group : Array<Person> = arrayOf(Person("pooh bear"), Person("tigger"), Person("piglet"))
    println(memberOf(Person("piglet"), group))
    println(memberOf(Person("eeyore"), group))

    val jane = User("Jane")
    val john = User("John")
    jane.addUser(User("Jane adding : mission impossible"))
    john.addUser(User("John adding : shrek 2"))
    jane.modAndPrint(john.ml)
    john.modAndPrint(jane.ml)
    jane.printMovieList()
    john.printMovieList()

    val t = Threshold
    println(t.isAboveThreshold(21))

    val anon_threshold = object : ThresholdChecker {
        override val lower: Int
            get() = 30
        override val upper: Int
            get() = 40

        override fun isLit(value: Int): Boolean {
            return value in lower..upper
        }

        override fun tooQuite(value: Int): Boolean {
            return !this.isLit(value)
        }
    }
    println(if(anon_threshold.isLit(31)) "nice" else ":(")
    println(if(anon_threshold.isLit(41)) "nice" else ":(")

    var s = ""
    s+= "hello"
    println(s)



}
