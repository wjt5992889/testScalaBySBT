package Concept

object FunctionCurrying {

  /**
    * 函数柯里化的变化过程
    * @param a
    * @param b
    * @param c
    * @param d
    * @return
    */
  def func(a:Int,b:Int,c:Int,d:Int)=1
  def func1(a:Int)(b:Int)(c:Int)(d:Int)=1
  def func2=(a:Int)=>(b:Int)=>(c:Int)=>(d:Int)=>1


}
