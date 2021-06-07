
object FunctionsAndLoops extends App {

  val wrapCharAZ = (int : Int) => int 

  def encode(str : String) : String = {
    str
      .map(_.toUpper)
      .map(_ + 1 )
      .map(wrapCharAZ)
      .map(_.toChar)
      .mkString("")
  }

  println(encode("xx"))

  def decode(str : String) : String = {
    str
      .map(_.toLower)
      .map(_ - 1 )
      .map(wrapCharAZ)
      .map(_.toChar)
      .mkString("")
  }
  println(decode(encode("ab")))
}
