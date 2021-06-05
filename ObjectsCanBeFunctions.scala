
object ObjectsCanBeFunctions extends App {

  /*
  Create a function double with the type signature Int => Int (in the same way we
    wrote val sqr above) that returns twice its argument. Similarly, write a
  function named plusOne that (obviously) adds one to its argument value.
  */
  val double : Int => Int = v => v * 2

  println(double(10))

  val plusOne : Int => Int = _ + 1

  println(plusOne(0))


  /*
  We discussed one way to write function factories and we noted that functions
  created this way also have Function1 as a supertype. Let's play with this
  idea. Two methods on Function1 are andThen and compose. Given f1 and f2 both
  of type T => T, these let us create a new function f3 by writing
  f1.compose(f2) or f1 compose f2. Using double and plusOne from above, play
  with andThen and compose. What is their difference? How might this technique
  be useful more generally?
  */

  val doublePlusOne = double.andThen(plusOne)
  val plusOneAndDouble = double.compose(plusOne)

  println(doublePlusOne(10))
  println(plusOneAndDouble(10))
}
