package base.orgtype

import scala.annotation.tailrec

object TestList {
  def main(args: Array[String]): Unit = {
    testElement()
    val str = loop(List(1,2,3))

    testListMethods
  }

  def testElement()={
    var l = List(1,2,3,4)

    var l2 = 0 :: l

    println(l2)

    var l3 = l ::: l2

    println(l3)
  }

  /**
    * 使用递归思路遍历list
    * 使用@scala.annotation.tailrec可以保证递归校验
    * @param a
    */
  @tailrec
  def loop(a:List[Int]):String ={
    if(a.isEmpty) ""
    else return loop(a.tail)
  }

  def testListMethods()={
    var l = List(1,2,3,4,5,6,7)
    /***toList***/
    val list = "123 red balloons".toList


    /***filter***/
    //获取奇数,内部其实是一个匿名函数
    l.filter( x => x % 2 == 1)
    "12dwefw".toList.filter(x => x.isDigit).foreach(println(_))

    /***
      * takeWhile
      * 一直获取直到不符合条件的情况出现
      */
    "34dwefw".toList.takeWhile(x => x != 'd').foreach(println(_))

    //此处需要注意转List之后是以char存储的，不能直接toInt
    "34dwefw".toList.filter(x => x.isDigit && Integer.parseInt(x+"") < 5).foreach(println(_))


    /***map 用于值的映射***/
    "asdasdas".toList.map(_.toUpper).foreach(print(_))

    /***
      * reduceLeft 集合规约操作，将元素运算为一个值，类型与元素同
      *   reduceLeft(OP:(T,T) =》 T)
      * foldLeft   可设置初始值，结果类型与初始同
      *    foldLeft(z:U)(OP:(U,T) =》 U)
      */
    val i = l.reduceLeft(_+_)
    val i2 = l.foldLeft(0)(_+_)
    print(i+"   "+i2)
  }

}
