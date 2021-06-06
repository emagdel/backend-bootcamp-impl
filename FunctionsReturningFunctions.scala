object FunctionsReturningFunctions extends App {
  class Greeter(greeting: String) {
    def greet(directObject: String) = s"$greeting $directObject"
  }

  val formal = new Greeter("Hello")
  // formal: Greeter = repl.Session$App$Greeter@5085dc6b
  println( formal.greet("Frank"))

  def greeter(greeting: String) = { directObject: String => s"$greeting $directObject" }

  val cowboyGreet = greeter("Howdy")
  // cowboyGreet: String => String = <function1>
  println( cowboyGreet("Frank"))


  def greeterDelayed(greeting : String)(directObject : String) = s"$greeting, $directObject"

  println(greeterDelayed("Hi")("Frank"))
}

