object ImplicitsPt4ImplicitValues extends App{
  object DatabaseConfig {
    trait Environment
    class TestEnv extends Environment
    class ProdEnv extends Environment

    trait DB[E <: Environment] {
      def ask(q: String): String
    }

    class TestDb[E <: Environment] extends DB[E] {
      override def ask(query: String) = query + ": fake results"
    }

    class Hal[E <: Environment] extends DB[E] {
      override def ask(query: String) = "I'm sorry Dave, I just can't do that."
    }

    implicit val stub = new TestDb[TestEnv]
    implicit val hal = new Hal[ProdEnv]
  }

  import DatabaseConfig._

  implicit val env = new ProdEnv

  // Change this line so that
  // TODO: Review this
  def query[T<:Environment](q: String)(implicit environment : T, db : DB[T]): String = db.ask(q)

  // this line automatically picks up the implicit Hal instance
  val result = query("Open the cargo-bay doors")
  println( result)

}
