fun main() {
    val myAnimal = Animal()

    myAnimal.cry()
    myAnimal.eat("apple")
}

class Animal() {
    val nLeg:Int = 4
    val color:String = "yellow"
    var name:String = "Tom"

    fun eat(something:String) {
        println("Eat $something")
    }

    fun cry() {
        println("Cry!!!")
    }
}