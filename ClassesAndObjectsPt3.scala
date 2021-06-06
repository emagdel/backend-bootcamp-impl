object ClassesAndObjectsPt3 extends App {
  object Loggers {
    trait Logger {
      def error(t: Throwable, message: String): Unit = ???
      def warn(message: String): Unit = ???
      def info(message: String): Unit = ???
    }

    trait StdoutLogger extends Logger {
      override def error(t: Throwable, message: String) = {
        import java.io._

        val stringWriter = new StringWriter()
        t.printStackTrace(new PrintWriter(stringWriter))
        val stackTrace = stringWriter.toString.split("\n").take(7).mkString("", "\n", "\n at ....")

        println(s"[ERROR] $message\n$stackTrace")
      }

      override def warn(message: String) = println(s"[WARN] $message")

      override def info(message: String) = println(s"[INFO] $message")
    }

    // Let's write a meta-meta-logger!!!
    trait Slf4JLogger extends Logger {
      // Do slf4j things here...
      override def error(t: Throwable, message: String) = ???
      override def warn(message: String) = ???
      override def info(message: String) = ???
    }
  }

  trait HappyOutputter extends Loggers.StdoutLogger {
    def output(content : String) : Unit = info(content)
  }

  trait NormalOutputter extends Loggers.StdoutLogger {
    def output(content : String) : Unit = warn(content)
  }
  trait AngryOutputter extends Loggers.StdoutLogger {
    def output(content : String, word : String) : Unit = error(new IllegalStateException(content), word)
  }

  object Animals {
    abstract class Animal extends Loggers.Logger {
      def logSpokenWord(word: String) : Unit
    }

    class HappyCat() extends Animal with HappyOutputter {
      override def logSpokenWord(word: String) = output(s"purrrrr purrrrrrr $word pufffrrr")
    }

    class SleepyCat() extends Animal with NormalOutputter {
      override def logSpokenWord(word: String) = output("zzzzZZZZZzzzZZZ")
    }

    class GrumpyCat() extends Animal with AngryOutputter {
      override def logSpokenWord(word: String) = output(s"The worst part of my Monday....  is hearing you complain about your $word!", word)
    }
  }

  val cuteKitty = new Animals.HappyCat()

  cuteKitty.logSpokenWord("Good Cat")

}
