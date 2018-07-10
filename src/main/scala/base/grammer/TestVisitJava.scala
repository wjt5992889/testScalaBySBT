package base.grammer

import java.util

import scala.collection.mutable.ArrayBuffer
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.bufferAsJavaList
import scala.collection.mutable

/**
  * Created by Administrator on 2018/3/17.
  */
object TestVisitJava {
  def main(args: Array[String]): Unit = {
    visitJava()
  }

  def visitJava(): Unit ={
    var scalaArr = ArrayBuffer("1","2","3")

    //此处processBuilde为java方法,需java的list作为参数,进过隐式转换可以将ArrayBuffer传入
    val pb = new ProcessBuilder(scalaArr)
    System.out.println(pb)

    //java 转scala
     val command: mutable.Buffer[String] = pb.command()
    println(command)



  }

}
