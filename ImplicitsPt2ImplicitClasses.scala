object ImplicitsPt2ImplicitClasses extends App{
  import java.io.File
  import scala.io.Source



  implicit class FileOperations(f : File) {
    def /(path : String) = new File(f.getCanonicalPath() + "/" + path)
    def slurp : String = Source.fromFile(f.getCanonicalPath()).getLines().toList.mkString("\n")
  }

  val f = new File("/")/"etc"/"passwd"
  println(f.slurp)

}
