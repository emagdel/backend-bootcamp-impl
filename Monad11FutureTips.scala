object Monad11FutureTips extends App{

  import Console.flush

  import scala.util.{Success,Failure}

  import scala.concurrent._
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.util.control._

  val result = Future[String] {
    throw new RuntimeException("Couldn't read String!")
    "A useless return value that will never be returned"
    }.recover {
      case NonFatal(e) => "Use this default value instead"
    }

    result.onComplete{
      case Success(v) => println(v)
      case Failure(v) => println(v)

    }

    flush()

}

