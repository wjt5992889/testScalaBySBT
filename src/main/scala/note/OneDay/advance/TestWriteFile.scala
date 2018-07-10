package note.OneDay.advance

import java.io.{File, PrintWriter}

object TestWriteFile {
  def main(args: Array[String]) {
    val writer = new PrintWriter(new File("test.txt" ))

    writer.write("Scala语言")
    writer.close()
  }
}
