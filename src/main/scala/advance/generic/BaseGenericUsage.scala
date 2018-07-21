package advance.generic

/**
  * 当构建一个类或者函数时，如果我们不知道（或者说不确定）传入的参数的具体数据类型，这时候可以泛型
  *
  * 最常见的是数据库操作,差别只在类型,逻辑都相似(增删改查)
  */
object BaseGenericUsage extends App{
  val str = "123"
  val intv =123
  val strTest = new Test[String](str)
  val intTest = new Test[Int](intv)
  strTest.check;
  intTest.check;
}

class Test[T](val v:T){
  def check = {
    if(v.isInstanceOf[String]){
      println("the param is String");
    }
    if(v.isInstanceOf[Int]){
      println("the param is Int");
    }
  }
}
