package note.OneDay.advance

import java.io.{FileNotFoundException, FileReader, IOException}
/**
  * Scala异常处理：
  * 和Java类似。在Scala中借用了模式匹配的方法来在catch语句块中来进行异常匹配。
  */
object TestException {
  def main(args: Array[String]): Unit = {
    try {
      val f = new FileReader("input.txt")
    }catch {
      case ex: FileNotFoundException => {
        println("Missing file exception")
      }
      case ex: IOException => {
        println("IO Exception")
      }
    }finally {
      println("Exiting finally...")
    }
  }
}
