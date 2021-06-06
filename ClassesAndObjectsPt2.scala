object ClassesAndObjectsPt2 extends App {

  class Pet(val name : String) {

    def equals(p2 : Pet) : Boolean = name == p2.name

    override def hashCode: Int = name.map(_+0).reduce(_ + _)

    override def toString: String = name

  }

  object Pet {
    def apply(name : String) : Pet = new Pet(name)
    def speak(self : Pet): String = "Gaff"
  }

  val pet = Pet("dolmotin")
  println(Pet.speak(pet))
}
