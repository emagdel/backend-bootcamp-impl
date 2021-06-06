
object ClassesAndObjectsPt4 extends App {
  object Animalia {
    sealed trait Animal {
      val speciesName: String
    }

    case class Dog(name: String, breed: String, barkFrequencyPeaksHz : Set[Int]) extends Animal { override val speciesName="Canis Familiaris" }

    case class Cat(name: String, breed: String, meowFrequencyMillis: Int, sleepFrequencyMillis: Int) extends Animal { override val speciesName="Felis catus" }

    case class Parrot(name: String, favoritePhrases: Set[String]) extends Animal { override val speciesName="Psittaciformes" }

    def getBreed(a: Animal): Option[String] = a match {
      case Dog(_, breed, _) => Some(breed)
      case p: Parrot => None
      case y: Cat => Some("Cat")
    }
  }

  val cat = Animalia.Cat("Bob", "north", 10, 10)
  val breed = Animalia.getBreed(cat)
  println(breed)

}
