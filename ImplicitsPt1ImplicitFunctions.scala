object ImplicitsPt1ImplicitFunctions extends App {


  case class Person(firstName : String, lastName : String){

    def fullName = s"$firstName $lastName"
  }


  val people = List(("John", "Johnson"), ("Tim", "Bobov"))


  implicit def converter(person : Tuple2[String, String]) = Person(person._1, person._2)


  val print = (p : Person) => println(p.fullName)

  // TODO: Why can't I do: people.foreach(print)
  people.foreach(print(_))

}
