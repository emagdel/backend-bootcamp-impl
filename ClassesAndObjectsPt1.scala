object ClassesAndObjectsPt1 extends App {

  abstract class Pet(val name : String) {

    def equals(p2 : Pet) : Boolean = name == p2.name

    override def hashCode: Int = name.map(_+0).reduce(_ + _)

    override def toString: String = name

    def speak:String

   //hashCode, and toString, add a speak 

  }

  class Dog(name : String)  extends Pet(name) {
    def speak = "Gaff"
  }

  val dog = new Dog("dolmotin")
  println(dog.speak)
}
