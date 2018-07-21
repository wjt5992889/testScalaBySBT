package base.symbol

import java.io.{File, PrintWriter}

/**
  * {}和()可以互相替换
  * 但是需要注意的是:圆括号替换成花括号只能发生在接收一个参数值的函数上
  */
object TestBracketReplacement {

  def withPrintWriter(file: File, op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  def withPrintWriter2(file: File)( op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }


  def main(args: Array[String]): Unit = {
    print("==========")
    print{"----------"}

    withPrintWriter(new File("d:/date.txt"), writer => writer.println(new java.util.Date))
    withPrintWriter2(new File("d:/date1.txt")){
      writer => writer.println(new java.util.Date)
    }

  }
}
