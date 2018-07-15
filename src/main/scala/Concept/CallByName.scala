package Concept

object CallByName {

  def main(args: Array[String]): Unit = {
    //此处sum方法最后才会调用,来运算传入的值
      sumByName(1,sum(1,2))
    //传值调用时,参数会先被运算好
    sum(1,sumByName(1,2))
  }

  def sum(a: Int,b: Int)={
    println("by value start")
    a+b
  }

  def sumByName(a: Int,b: =>Int)={
    println("byname start")
    a+b
  }

}
