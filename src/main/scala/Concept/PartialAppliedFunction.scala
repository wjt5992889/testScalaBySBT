package Concept

/**
  * 部分应用函数（Partial Applied Function)是指缺少部分参数的函数.
  */
object PartialAppliedFunction {
  def main(args: Array[String]): Unit = {
    s2(2)
    s3(2,3)
  }

  def sum(x:Int,y:Int,z:Int)=x+y+z
  val s1=sum _
  //指定两个参数的部分应用函数
  val s2=sum(1,_:Int,3)
  //指定一个参数的部分应用函数
  val s3=sum(1,_:Int,_:Int)

  def currySum(a:Int)(b: Int)(c: Int)=a+b+c
  //currying和partialfuction的组合应用
  val m=currySum(1)_
}
