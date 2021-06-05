
object FunctionsAndLoops extends App {

  def encode(str : String) : String = {
    val wrapCharAZ = (int : Int) => int 
    str
      .map(_.toUpper)
      .map(_ + 1 )
      .map(wrapCharAZ)
      .map(_.toChar)
      .mkString("")
  }

  println(encode("xx"))

  def decode(str : String) : String = {
    val wrapCharAZ = (int : Int) => int 
    str
      .map(_.toLower)
      .map(_ - 1 )
      .map(wrapCharAZ)
      .map(_.toChar)
      .mkString("")
  }
  println(decode(encode("ab")))
}
