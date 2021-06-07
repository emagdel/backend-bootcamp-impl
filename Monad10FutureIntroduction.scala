object Monad10FutureIntroduction extends App {
  import Console.flush
  import scala.concurrent._
  import scala.concurrent.ExecutionContext.Implicits.global

  import scala.util.{Success,Failure}
  import scala.io.Source
  import java.io._


  val getProduct1234Info = Future { 
    //throw new RuntimeException("Fail")
    (1234, "Product description") 
  }
  // getProduct1234Info: Future[(Int, String)] = Future(Success((1234,Product description)))

  val getProduct1234Picture = Future {
    //throw new RuntimeException("Fail")
    val b = new ByteArrayOutputStream
    val p = new PrintStream(b)
    p.print("a beautiful image")
    b.toByteArray
  }
  // getProduct1234Picture: Future[Array[Byte]] = Future(Success([B@3caa3ba0))

  // Combine both futures' results
  // getProduct1234Info.flatMap { case (productId, description) =>
  //   getProduct1234Picture.map { picture =>
  //     (productId, description, picture)
  //   }
  // }

  val getInfoToDisplay = for {
    productInfo <- getProduct1234Info
    picture <- getProduct1234Picture
    } yield {
      val (productId, description) = productInfo
      (productId, description, picture)
    }

    getInfoToDisplay
      .onComplete{
        case Success(info) => println(info)
        case Failure(exception) => println(exception)
      }
    flush()
      /*
  1. As illustrated above, the main way Scala programs process Future results is
  to process those results in a callback and allow the current thread to
  process to completion. Why would that be?
    * By definition original thread has ended with completed execution, so we either need to
      spin another thread or handle it on the caller thread.
    * To allow synchronizing results with potential other jobs (aka reduce)

  2. Change getInfoToDisplay so that getProduct1234Info throws an exception and
    examine what happens. Does getProduct1234Picture still execute? Why or why
    not?
      * Yes, since future start executing concurrently and wrapped in try internally
        * There should be a way to make Future dependent, then getProduct1234Picture would not have
          executed
  3. Try the same with getProduct1234Picture and see what happens. Can you explain the program's behavior?
    * Same as 3

  4. Here's a Scala newbie mistake with Futures; what's not great about rewriting the example 
    above this way?
      TODO: Any technical reason?
      * Not testable as Future cannot be scheduled to run on the current thread



  */
}
