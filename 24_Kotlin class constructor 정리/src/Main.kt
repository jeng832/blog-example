fun main() {
    val myAnimal = Animal(4, "yellow")

    myAnimal.cry()
    myAnimal.eat("apple")
}

class Animal(val nLeg:Int, val color:String) {
    var name:String = "Tom"
    init {
        println("=== Primary Init block ===")
        println("nLeg: $nLeg, color: $color, name: $name")
        // Do something!!
    }

    fun eat(something:String) {
        println("Eat $something")
    }

    fun cry() {
        println("Cry!!!")
    }
}