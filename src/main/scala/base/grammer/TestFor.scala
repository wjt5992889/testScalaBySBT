package base.grammer

import scala.util.control.Breaks._

/**
  * Created by Administrator on 2017/4/23.
  *
  * for 循环中的 yield 会把当前的元素记下来，保存在集合中，循环结束后将返回该集合。
  * Scala 中 for 循环是有返回值的。
  * 如果被循环的是 Map，返回的就是  Map，
  * 被循环的是 List，返回的就是 List，
  * 以此类推
  */
object TestFor {
  def main(args: Array[String]): Unit = {
//    loopRange()
//    loopCollection()
//    loopWithFilter()
//    loopWithYield()
//    loopWithYieldAndFilter
    loopArray()
  }

  def loopRange():Unit={
    var a = 0;
    // for loop execution with a range
    //    for( var x <- Range ){
    //      statement(s);
    //    }
    for( a <- 1 to 10){
      println( "Value of a to: " + a );
    }

    for( a <- 1 until 10){
      println( "Value of a until: " + a );
    }


    var b = 0;
    // for loop execution with a range
    for( a <- 1 to 3; b <- 1 to 3){
      println( "Value of a double: " + a );
      println( "Value of b double: " + b );
    }
  }

  def loopCollection():Unit={
//    for( var x <- List ){
//      statement(s);
//    }

    var a = 0;
    val numList = List(1,2,3,4,5,6);

    // for loop execution with a collection
    for( a <- numList ){
      println( "Value of a LIST: " + a );
    }
  }

  def loopWithFilter(): Unit ={
//    for( var x <- List
//    if condition1; if condition2...
//    ){
//      statement(s);
//    }

    var a = 0;
    val numList = List(1,2,3,4,5,6,7,8,9,10);

    // for loop execution with multiple filters
    for( a <- numList
         if a != 3; if a < 8 ){
      println( "Value of a Filter: " + a );
    }
  }

  def loopWithYield(): Unit ={
    var a = 0;
    val numList = List(1,2,3,4,5,6,7,8,9,10);

    // for loop execution with a yield
    var retVal = for{ a <- numList
                      if a != 3; if a < 8
    }yield a

    // Now print returned values using another loop.
    for( a <- retVal) {
      println("Value of a Yield: " + a);
    }

    for (i <- 1 to 5) yield i
    for (i <- 1 to 5) yield i * 2

  }

  def loopWithYieldAndFilter(): Unit ={
//    yield 关键字的简短总结:
//
//      针对每一次 for 循环的迭代, yield 会产生一个值，被循环记录下来 (内部实现上，像是一个缓冲区).
//    当循环结束后, 会返回所有 yield 的值组成的集合.
//      返回集合的类型与被遍历的集合类型是一致的.

    val a = Array(1, 2, 3, 4, 5)
    var retVal = for (e <- a if e > 2) yield e

    for(i<-retVal){
      println("Value of i YieldAndFilter"+i)
    }
  }

  def testBreak(): Unit ={
    breakable{
      for(i <- 1 to 55)
        if(i == 4) break


    }

  }

  def loopArray(): Unit ={
    val a = Array(1,2,3,4,5,6)

    for(i <- 0 until a.length){
      print(a(i))
    }
  }
}
