package applicantion.implicitConvert

object SalaryDemo {
}

object Company{
  //在object中定义隐式值    注意：同一类型的隐式值只允许出现一次，否则会报错
  implicit  val aaa="zhangsan"
  implicit  val bbb=10000.00
}
class Boss {
  //定义一个用implicit修饰的参数，为隐式参数。类型为String
  //Scala会在两个范围内查找：
  //1.当前作用域内可见的val或var定义的隐式变量；
  //2.是隐式参数类型的伴生对象内的隐式值
  //注意参数匹配的类型   它需要的是String类型的隐式值
  def callName()(implicit name:String):String={
    name+" is coming !"
  }
  //定义一个用implicit修饰的参数
  //注意参数匹配的类型    它需要的是Double类型的隐式值
  def getMoney()(implicit money:Double):String={
    " 当月薪水："+money
  }
}
object Boss extends App{
  //使用import导入定义好的隐式值，注意：必须先加载否则会报错
  import Company._
  val boss =new Boss
  println(boss.callName()+boss.getMoney())
}
