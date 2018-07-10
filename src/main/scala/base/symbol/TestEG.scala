package base.symbol

/**
  * EG  就是 =>
  */
object TestEG {
  def main(args: Array[String]): Unit = {

  }

  //1. 表示函数的类型(Function Type)
  //定义一个double函数
  def double(x: Int): Int = x*2
  //定义一个double函数的函数变量
//  f: (Double) => Double 定义函数参数为 double，返回值为double
  var x : (Int) => Int = double

  //2.匿名函数变量(x: Int) => x + 1是一个匿名的函数
  var xx = (x: Int) => x + 1
  //给一个高阶函数传入一个匿名的函数变量
  val newList = List(1,2,3).map { (x: Int) => x * 2 }


  //3.by name paramter，根据名字的参数
  def doubles(x: => Int) = {
    println("Now doubling " + x)
    x*2
  }


  //4.case中的应用
  def caseFunction{
    var x = 10
    var y = 20

    var max = x > y match {
      case true => x
      case false => y
    }


    println(max)
  }

  def test(x:String): Unit ={
    println(x)
  }

}
