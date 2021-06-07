object Monad01FromCollections extends App {

  /*
  Try it! Can you implement pipelines that branch depending on one or more
  conditions using monads? How about loops? See how far you can get.
  */

 // Returns Single Option type monad that contains 
 val repeatExpTwo = (pow : Int, word : String) => List(pow)
   .map( 1 << _ )
   .flatMap( count => (1 to count).toList)
   .map(v => s"$v $word")
   .foldLeft(Option("Start"))((acc, b) => acc.map(_ + "\n" + b))

   /* 
   TODO: Figure out why Some("Start") does not work (but Option does as written above)
   */
  repeatExpTwo(2, "present")
    .foreach(println)


    val mapToValue = (input : Boolean) => Option(input)
      .flatMap { 
         case true => Option("valid value")
         case false => None
       }

      List(true, false).foreach(
        mapToValue(_).foreach(println)
      )
}
