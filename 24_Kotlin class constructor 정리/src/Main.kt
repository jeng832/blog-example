fun main() {
    val myAnimal = Animal(4, "yellow", "Smith")

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

    constructor(_nLeg:Int, _color:String, _name:String) : this(_nLeg, _color) {
        println("=== Secondary constructor start ===")
        this.name = _name
        println("=== Secondary constructor end ===")
    }

    fun eat(something:String) {
        println("Eat $something")
    }

    fun cry() {
        println("Cry!!!")
    }
}