package base.grammer

import scala.math._
/**
  * Created by Administrator on 2017/5/4.
  * 高阶函数主要有两种：
  *   1.一种是将一个函数当做另外一个函数的参数（即函数参数）；
  *   2.一种是返回值是函数的函数。
  */
object TestFunction {

  def main(args: Array[String]): Unit = {
    delayed(time);
    delayed2(time2);
    printInt(b=2,a=1)
    printStrings("Hello", "Scala", "Python");
    println( "Returned Value : " + addInt() );
    println( "Returned Value : " + addInt(1) );
    println( "Returned Value : " + addInt(b=1) );
  }

  def time2[Int](x:Int) = {
    println("Getting time in nano seconds")
    System.nanoTime+1
  }

  def time() = {
    println("Getting time in nano seconds")
    System.nanoTime
  }

  /**
    * 在这里，我们声明delayed方法， 该方法在变量名和变量类型使用 => 符号来设置传名调用
    * 在进入函数内部前，传值调用方式就已经将参数表达式的值计算完毕，
    * 而传名调用是在函数内部进行参数表达式的值计算的。
    * 这就造成了一种现象，每次使用传名调用时，解释器都会计算一次表达式的值。
    * @param t
    * @return
    */
  def delayed( t: => Long ) = {
    println("In delayed method")
    println("Param: " + t)
    t
  }

  def delayed2( t:Int => Long ) = {
    println("In delayed method")
    println("Param: " + t(1))
    t
  }


  /**
    * 在一个正常的函数调用，调用参数在调用函数的参数的顺序一一匹配。
    * 命名参数允许将参数以不同的顺序传递给的函数。
    * 语法很简单，每个参数前面有一个参数名和等号
    * @param a
    * @param b
    */
  def printInt( a:Int, b:Int ) = {
    println("Value of a : " + a );
    println("Value of b : " + b );
  }


  /**
    * Scala允许指出的最后一个参数的函数可以被重复。能够通过可变长度参数列表传递到函数
    * @param args
    */
  def printStrings( args:String* ) = {
    var i : Int = 0;
    for( arg <- args ){
      println("Arg value[" + i + "] = " + arg );
      i = i + 1;
    }
  }


  /**
    * Scala可以指定默认值函数的参数。
    * 对于这样的一个参数，可以任选地从一个函数调用，在这种情况下对应的参数将被填充使用默认参数值。
    * @param a
    * @param b
    * @return
    */
  def addInt( a:Int=5, b:Int=7 ) : Int = {
    var sum:Int = 0
    sum = a + b

    return sum
  }


  def apply(f: Int => String, v: Int) = f(v)

  def layout[A](x: A) = "[" + x.toString() + "]"
}
